package com.littlebig.services.sourcing.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.littlebig.services.client.api.ClientDisabledEvent;
import com.littlebig.services.common.event.ApplicationEventListener;
import com.littlebig.services.notification.api.NotificationManagementInternalAPI;
import com.littlebig.services.sourcing.api.ConnectSourceExternalAPI;
import com.littlebig.services.sourcing.api.ConnectSourceInternalAPI;
import com.littlebig.services.sourcing.api.ConnectRfpCreationDTO;
import com.littlebig.services.sourcing.api.ConnectRfpDTO;
import com.littlebig.services.sourcing.mapper.ConnectRfpMapper;
import com.littlebig.services.sourcing.model.ConnectRfp;
import com.littlebig.services.sourcing.model.RfpStatus;
import com.littlebig.services.sourcing.repository.ConnectRfpRepository;

@Transactional(propagation =  Propagation.REQUIRED)
@Service
public class ConnectSourceManagementService implements ConnectSourceInternalAPI, ConnectSourceExternalAPI {

    private static final Logger LOG = LoggerFactory.getLogger(ConnectSourceManagementService.class);

    private static final String RFP_NOT_FOUND = "RFP_NOT_FOUND";
    private final ConnectRfpRepository connectRfpRepository;
    private final ConnectRfpMapper rfpMapper;
    private final NotificationManagementInternalAPI notificationManagementInternalAPI;

    @Autowired
    public ConnectSourceManagementService(ConnectRfpRepository connectRfpRepository, ConnectRfpMapper rfpMapper,
        NotificationManagementInternalAPI notificationManagementInternalAPI) {
        this.connectRfpRepository = connectRfpRepository;
        this.rfpMapper = rfpMapper;
        this.notificationManagementInternalAPI = notificationManagementInternalAPI;
    }

    @Override
    public UUID createRFP(ConnectRfpCreationDTO rfpDTO) {
        ConnectRfp rfp = rfpMapper.rfpDtoToRfp(rfpDTO);
        connectRfpRepository.save(rfp);
        return rfp.getId();
    }

    @Override
    public ConnectRfpDTO getRfpById(UUID id) {
        ConnectRfp rfp = connectRfpRepository.findById(id)
            .orElseThrow(() -> new RuntimeException(RFP_NOT_FOUND));
        return rfpMapper.rfpToRfpDTO(rfp);
    }

    @Override
    public void publishRfp(UUID rfpId) {
        LOG.debug("The following RFP will be published to marketplace {}", rfpId);
        ConnectRfp rfp = connectRfpRepository.findById(rfpId)
            .orElseThrow(() -> new RuntimeException(RFP_NOT_FOUND));
        rfp.setRfpStatus(RfpStatus.PUBLISHED);
        connectRfpRepository.save(rfp);
        notificationManagementInternalAPI.sendNotificationWhenRfpStatusChanged(rfpId, rfp.getRfpStatus().name(),
            RfpStatus.PUBLISHED.name());
    }

    @Override
    public void applyToRfp(UUID rfpId, UUID clientId) {
        LOG.debug("The following application happens on this RFP {}, Client ID{}", rfpId,clientId);
        ConnectRfp rfp = connectRfpRepository.findById(rfpId)
            .orElseThrow(() -> new RuntimeException(RFP_NOT_FOUND));
        rfp.setRfpApplicantClientId(clientId);
        connectRfpRepository.save(rfp);
    }

    @Override
    public void revokeRFP(UUID rfpId) {
        LOG.debug("The following RFP will be revoked {}", rfpId);
        ConnectRfp rfp = connectRfpRepository.findById(rfpId)
            .orElseThrow(() -> new RuntimeException(RFP_NOT_FOUND));
        rfp.setActive(Boolean.FALSE);
        rfp.setRfpStatus(RfpStatus.CLOSED);
        connectRfpRepository.save(rfp);
        notificationManagementInternalAPI.sendNotificationWhenRfpStatusChanged(rfpId, rfp.getRfpStatus().name(),
            RfpStatus.CLOSED.name());
    }

    @ApplicationEventListener
    public void onClientDisabledEvent(ClientDisabledEvent event) {
        connectRfpRepository.findConnectRfpByRfpApplicantClientId(event.clientId()).
            forEach(connectRfp -> revokeRFP(connectRfp.getId()));
    }
}
