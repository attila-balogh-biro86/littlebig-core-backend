package com.littlebig.services.sourcing.api;

import java.util.UUID;

import com.littlebig.services.sourcing.model.RfpStatus;

public record RfpStatusChangedEvent(UUID rfpId, RfpStatus oldStatus, RfpStatus newStatus) {
}