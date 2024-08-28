package com.littlebig.services.sourcing.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.littlebig.services.sourcing.api.ConnectRfpCreationDTO;
import com.littlebig.services.sourcing.api.ConnectRfpDTO;
import com.littlebig.services.sourcing.model.ConnectRfp;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConnectRfpMapper {
    ConnectRfpDTO rfpToRfpDTO(ConnectRfp rfp);
    ConnectRfp rfpDtoToRfp(ConnectRfpDTO rfpDTO);
    ConnectRfp rfpDtoToRfp(ConnectRfpCreationDTO rfpDTO);
}
