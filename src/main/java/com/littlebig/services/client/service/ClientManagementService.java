package com.littlebig.services.client.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.littlebig.services.client.api.ClientManagementExternalAPI;
import com.littlebig.services.client.api.ClientManagementInternalAPI;
import com.littlebig.services.client.api.ClientCreationDTO;
import com.littlebig.services.client.api.ClientDTO;
import com.littlebig.services.client.api.ClientDisabledEvent;
import com.littlebig.services.client.mapper.ClientMapper;
import com.littlebig.services.client.model.Client;
import com.littlebig.services.client.repository.ClientRepository;
import com.littlebig.services.notification.api.NotificationManagementInternalAPI;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class ClientManagementService implements ClientManagementInternalAPI, ClientManagementExternalAPI {

    private static final Logger LOG = LoggerFactory.getLogger(ClientManagementService.class);
    private final ClientRepository clientRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final ClientMapper clientMapper;
    private static final String RFP_NOT_FOUND = "RFP_NOT_FOUND";
    private final NotificationManagementInternalAPI notificationManagementInternalAPI;

    @Autowired
    public ClientManagementService(ClientRepository clientRepository,
        ApplicationEventPublisher applicationEventPublisher, ClientMapper clientMapper,
        NotificationManagementInternalAPI notificationManagementInternalAPI) {
        this.clientRepository = clientRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.clientMapper = clientMapper;
        this.notificationManagementInternalAPI = notificationManagementInternalAPI;
    }

    @Override
    public UUID createClient(ClientCreationDTO clientDTO) {
        Client client = clientMapper.clientDTOToClient(clientDTO);
        clientRepository.save(client);
        notificationManagementInternalAPI.sendNotificationWhenNewClientCreated(client.getId());
        return client.getId();
    }

    @Override
    public ClientDTO getClient(UUID id) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException(RFP_NOT_FOUND));
        return clientMapper.clientToClientDTO(client);
    }

    @Override
    public void disableClient(UUID clientId) {
        LOG.debug("Trying to disable client: {}", clientId);
        Client client = clientRepository.findById(clientId)
            .orElseThrow(() -> new RuntimeException("Client with id " + clientId + " not found"));
        client.setActive(Boolean.FALSE);
        clientRepository.save(client);
        applicationEventPublisher.publishEvent(new ClientDisabledEvent(clientId));
    }
}
