package com.littlebig.services.sourcing.api;

import java.util.UUID;

public interface RiseSourceExternalAPI {

    UUID createRFP(RiseRfpDTO rfpDTO);

    RiseRfpDTO getRfpById(UUID id);
}
