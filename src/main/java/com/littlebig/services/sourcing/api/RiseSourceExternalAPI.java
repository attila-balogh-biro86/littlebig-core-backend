package com.littlebig.services.sourcing.api;

import java.util.UUID;

public interface RiseSourceExternalAPI {

    UUID createRFP(RiseRfpCreationDTO rfpDTO);

    RiseRfpDTO getRfpById(UUID id);
}
