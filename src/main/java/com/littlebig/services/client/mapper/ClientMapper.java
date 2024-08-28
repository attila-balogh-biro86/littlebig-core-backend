package com.littlebig.services.client.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.littlebig.services.client.api.ClientCreationDTO;
import com.littlebig.services.client.api.ClientDTO;
import com.littlebig.services.client.model.Client;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {
    ClientDTO clientToClientDTO(Client client);
    Client clientDTOToClient(ClientCreationDTO clientDTO);
}
