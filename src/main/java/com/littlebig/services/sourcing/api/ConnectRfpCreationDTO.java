package com.littlebig.services.sourcing.api;

import com.littlebig.services.sourcing.model.WorkUnitType;

public record ConnectRfpCreationDTO(
                                    String name,
                                    String description,
                                    WorkUnitType workUnitType,
                                    Double maximumPrice) {
}
