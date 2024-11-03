package com.ms.email.dtos;

import lombok.Data;

import java.util.List;

@Data
public class TemplateDTO {
    private String name;
    private List<ContextDTO> contexts;
}
