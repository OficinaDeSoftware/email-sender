package com.ms.email.consumers;

import com.ms.email.dtos.PayloadDTO;
import com.ms.email.mappers.PayloadMapper;
import com.ms.email.models.PayloadModel;
import com.ms.email.services.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailConsumer {

    private final EmailService emailService;
    private final PayloadMapper payloadMapper;

    public EmailConsumer( EmailService emailService, PayloadMapper payloadMapper ) {
        this.emailService = emailService;
        this.payloadMapper = payloadMapper;
    }

    @RabbitListener(queues = "${broker.queue.email.name}" )
    public void listenEmailQueue( @Payload PayloadDTO payloadDTO ) {
        log.info("Receive new payload");
        PayloadModel payloadModel = payloadMapper.toModel( payloadDTO );
        payloadModel.getTemplate().setPayload( payloadModel );
        emailService.send( payloadModel );
        log.info("Payload process finished");
    }

}
