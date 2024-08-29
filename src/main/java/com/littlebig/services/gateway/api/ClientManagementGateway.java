package com.littlebig.services.gateway.api;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.littlebig.services.client.api.ClientCreationDTO;
import com.littlebig.services.client.api.ClientDTO;
import com.littlebig.services.client.api.ClientManagementExternalAPI;
@RestController
@RequestMapping("/api/v1/client")
public class ClientManagementGateway {

  private final ClientManagementExternalAPI clientManagementExternalAPI;

  @Autowired
  public ClientManagementGateway(ClientManagementExternalAPI clientManagementExternalAPI) {
    this.clientManagementExternalAPI = clientManagementExternalAPI;
  }

  @GetMapping("/clients/{id}")
  public ClientDTO getClientById(@PathVariable("id") UUID id) {
    return  clientManagementExternalAPI.getClient(id);
  }

  @PostMapping("/clients")
  public UUID saveRfp(@RequestBody ClientCreationDTO dto) {
    return clientManagementExternalAPI.createClient(dto);
  }
}
