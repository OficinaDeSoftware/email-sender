package com.ms.email.services;

import com.ms.email.repositories.TemplateRepository;
import org.springframework.stereotype.Service;

@Service
public class TemplateService {

    private final TemplateRepository templateRepository;

    public TemplateService( TemplateRepository templateRepository ) {
        this.templateRepository = templateRepository;
    }

    public String templateByName( final String name ) {
        return templateRepository.findByName( name ).orElseThrow(
                () -> new RuntimeException( "Failed on find template" )
        ).getContent();
    }

}
