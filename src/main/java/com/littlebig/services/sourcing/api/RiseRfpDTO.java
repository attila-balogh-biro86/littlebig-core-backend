package com.littlebig.services.sourcing.api;

import java.util.UUID;

import com.littlebig.services.sourcing.model.WorkUnitType;

public record RiseRfpDTO(UUID id,
                         String name,
                         String description,
                         WorkUnitType workUnitType,
                         Double maximumPrice,
                         UUID rfpApplicantId) {
}
