package com.ms.email.models;

import com.ms.email.converters.ContextListJsonConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity( name = "template_payload")
public class TemplatePayloadModel implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "id_payload")
    @MapsId
    private PayloadModel payload;

    private String name;

    @Convert(converter = ContextListJsonConverter.class)
    @Column(columnDefinition = "TEXT")
    private List<ContextPayloadModel> contexts;

}
