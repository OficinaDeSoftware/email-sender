package com.ms.email.models;

import com.ms.email.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table( name = "payload" )
public class PayloadModel implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID idPayload;
    private String nrUuidReceiver;

    private String subject;
    private String receiver;
    private String sender;

    private LocalDateTime sendDate;
    private StatusEmail statusEmail;

    @OneToOne( cascade = CascadeType.ALL, mappedBy = "payload" )
    @PrimaryKeyJoinColumn
    private TemplatePayloadModel template;

}
