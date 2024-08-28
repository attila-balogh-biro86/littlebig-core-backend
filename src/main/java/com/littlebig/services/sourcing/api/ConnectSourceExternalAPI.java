package com.littlebig.services.sourcing.api;

import java.util.UUID;

public interface ConnectSourceExternalAPI {

    UUID createRFP(ConnectRfpCreationDTO rfpDTO);

    ConnectRfpDTO getRfpById(UUID id);

    void publishRfp(UUID rfpId);

    void applyToRfp(UUID rfpId, UUID clientId);
}
