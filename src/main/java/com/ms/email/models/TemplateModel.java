package com.ms.email.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity( name = "templates")
public class TemplateModel implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID idTemplate;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String content;

}
