package com.ms.email.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.email.models.ContextPayloadModel;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.io.IOException;
import java.util.List;

@Converter
public class ContextListJsonConverter implements AttributeConverter<List<ContextPayloadModel>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn( List<ContextPayloadModel> contextList ) {
        try {
            return objectMapper.writeValueAsString( contextList );
        } catch ( JsonProcessingException exception ) {
            throw new IllegalArgumentException( "Error converting list to JSON", exception );
        }
    }

    @Override
    public List<ContextPayloadModel> convertToEntityAttribute(String json) {
        try {
            return objectMapper.readValue( json, objectMapper.getTypeFactory().constructCollectionType( List.class, ContextPayloadModel.class ) );
        } catch ( IOException exception ) {
            throw new IllegalArgumentException("Error converting JSON to list", exception );
        }
    }
}