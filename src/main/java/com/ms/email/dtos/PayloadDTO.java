package com.ms.email.dtos;

import lombok.Data;

import java.util.UUID;

@Data

public class PayloadDTO {
    private UUID nrUuidReceiver;
    private String receiver;
    private String subject;
    private TemplateDTO template;
}
