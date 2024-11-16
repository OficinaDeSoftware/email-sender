package com.ms.email.services;

import com.ms.email.enums.StatusEmail;
import com.ms.email.models.ContextPayloadModel;
import com.ms.email.models.PayloadModel;
import com.ms.email.models.TemplatePayloadModel;
import com.ms.email.repositories.PayloadRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class EmailService {

    @Value(value = "${spring.mail.username}")
    private String sender;

    private final PayloadRepository payloadRepository;
    private final JavaMailSender emailSender;
    private final TemplateEngine templateEngine;
    private final TemplateService templateService;

    public EmailService(
            PayloadRepository payloadRepository,
            JavaMailSender emailSender,
            TemplateEngine templateEngine,
            TemplateService templateService ) {

        this.payloadRepository = payloadRepository;
        this.emailSender = emailSender;
        this.templateService = templateService;

        StringTemplateResolver stringTemplateResolver = new StringTemplateResolver();
        templateEngine.setTemplateResolver(stringTemplateResolver);
        this.templateEngine = templateEngine;
    }

    /**
     * Converts a list of {@link ContextPayloadModel} into a {@link Context} object.
     *
     * @param contextsPayload the list of {@link ContextPayloadModel} containing the key-value pairs to be set in the {@link Context}
     * @return a {@link Context} object populated with the key-value pairs from the provided list
     */

    public Context toContext( final List<ContextPayloadModel> contextsPayload ) {

        log.info("Converting contextsPayload to context");

        Context context = new Context();

        contextsPayload.forEach( contextPayload -> {
            context.setVariable( contextPayload.getKey(), contextPayload.getValue() );
        });

        log.info("End converting contextsPayload to context");

        return context;

    }

    /**
     * Sends an email based on the provided payload model. The method processes the email template,
     * sets necessary email details, and sends the email through the email sender. If the email sending
     * fails, it updates the email status to ERROR. Finally, the payload model is saved in the repository.
     *
     * @param payloadModel the model containing the email details such as receiver, subject, and template information
     */

    @Transactional
    public void send( PayloadModel payloadModel ) {

        log.info("Sending email");

        try {

            final TemplatePayloadModel templatePayload = payloadModel.getTemplate();

            final Context context = toContext( templatePayload.getContexts() );

            final String rawTemplate = templateService.templateByName( templatePayload.getName() );

            final String process = templateEngine.process( rawTemplate, context );

            payloadModel.setSendDate( LocalDateTime.now() );
            payloadModel.setSender( sender );

            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper( message, true, "UTF-8" );

            helper.setTo( payloadModel.getReceiver() );
            helper.setSubject( payloadModel.getSubject() );
            helper.setText( process, true );

            emailSender.send( message );

            payloadModel.setStatusEmail( StatusEmail.SENT );

        } catch ( Exception exception ){
            // TODO implement retry thread, with configure attempts on database
            log.info("Failed on send e-mail");
            payloadModel.setStatusEmail( StatusEmail.ERROR );
        }

        log.info("Process finished, start save payload");

        payloadRepository.save( payloadModel );
    }

}
