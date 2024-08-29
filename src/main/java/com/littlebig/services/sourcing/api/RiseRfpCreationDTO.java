package com.littlebig.services.sourcing.api;

import java.util.UUID;

import com.littlebig.services.sourcing.model.WorkUnitType;

public record RiseRfpCreationDTO(String name,
                                 String description,
                                 WorkUnitType workUnitType,
                                 Double maximumPrice,
                                 UUID preferredSupplierClientId) {
}
