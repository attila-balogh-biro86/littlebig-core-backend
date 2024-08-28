package com.littlebig.services.notification.api;

import java.util.UUID;

public interface NotificationManagementInternalAPI {

     void sendNotificationWhenNewClientCreated(UUID clientId);

     void sendNotificationWhenRfpStatusChanged(UUID rfpId, String oldStatus, String newStatus);

}
