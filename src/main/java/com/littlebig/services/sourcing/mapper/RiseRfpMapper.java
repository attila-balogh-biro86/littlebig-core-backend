package com.littlebig.services.sourcing.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.littlebig.services.sourcing.api.RiseRfpDTO;
import com.littlebig.services.sourcing.model.RiseRfp;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RiseRfpMapper {

    RiseRfpDTO rfpToRfpDTO(RiseRfp rfp);
    RiseRfp rfpDtoToRfp(RiseRfpDTO rfpDTO);
}
