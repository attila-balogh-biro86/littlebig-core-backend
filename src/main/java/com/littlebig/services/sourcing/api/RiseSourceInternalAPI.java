package com.littlebig.services.sourcing.api;

import java.util.List;
import java.util.UUID;

public interface RiseSourceInternalAPI {
    List<RiseRfpDTO> getAllRFPsByCustomerId(UUID customerId);
}
