package com.littlebig.services.sourcing.api;

import java.util.UUID;

import com.littlebig.services.sourcing.model.RfpStatus;
import com.littlebig.services.sourcing.model.RfpType;
import com.littlebig.services.sourcing.model.WorkUnitType;

public record ConnectRfpDTO(UUID id,
                            String name,
                            String description,
                            RfpType rfpType,
                            RfpStatus rfpStatus,
                            WorkUnitType workUnitType,
                            Double maximumPrice) {
}
