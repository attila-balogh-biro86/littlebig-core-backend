package com.littlebig.services.notification.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.littlebig.services.notification.api.NotificationManagementInternalAPI;
import com.littlebig.services.sourcing.model.RfpStatus;

@Service
public class NotificationManagementService implements NotificationManagementInternalAPI {

    private static final Logger LOG = LoggerFactory.getLogger(NotificationManagementService.class);

    @Override
    public void sendNotificationWhenNewClientCreated(UUID clientId) {
        LOG.debug("sendNotificationWhenNewClientCreated: {}", clientId);
    }

    @Override
    public void sendNotificationWhenRfpStatusChanged(UUID rfpId, String oldStatus, String newStatus) {
        LOG.debug("sendNotificationWhenRfpStatusChanged: {}", rfpId);
    }
}
