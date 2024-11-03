package com.ms.email.mappers;

import com.ms.email.dtos.PayloadDTO;
import com.ms.email.models.PayloadModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PayloadMapper {

    private final ModelMapper modelMapper;

    public PayloadMapper( ModelMapper modelMapper ) {
        this.modelMapper = modelMapper;
    }

    public PayloadModel toModel( final PayloadDTO payloadDTO ) {
        return modelMapper.map( payloadDTO, PayloadModel.class );
    }

}
