package com.littlebig.services.client.api;

import java.util.UUID;

public interface ClientManagementExternalAPI {

    UUID createClient(ClientCreationDTO clientDTO);

    ClientDTO getClient(UUID id);
}
