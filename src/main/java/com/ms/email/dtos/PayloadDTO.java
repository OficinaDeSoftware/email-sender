package com.ms.email.dtos;

import lombok.Data;

import java.util.UUID;

@Data

public class PayloadDTO {
    private String nrUuidReceiver;
    private String receiver;
    private String subject;
    private TemplateDTO template;
}
