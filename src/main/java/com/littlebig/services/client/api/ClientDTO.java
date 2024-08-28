package com.littlebig.services.client.api;

import java.util.UUID;

public record ClientDTO(UUID id,
    String name,
    String address,
    boolean active ) {
}
