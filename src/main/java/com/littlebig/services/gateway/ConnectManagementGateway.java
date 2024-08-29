package com.littlebig.services.gateway;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.littlebig.services.sourcing.api.ConnectRfpCreationDTO;
import com.littlebig.services.sourcing.api.ConnectSourceExternalAPI;
import com.littlebig.services.sourcing.api.ConnectRfpDTO;

@RestController
@RequestMapping("/api/v1/connect")
public class ConnectManagementGateway {

    private final ConnectSourceExternalAPI connectSourceExternalAPI;

    @Autowired
    public ConnectManagementGateway(ConnectSourceExternalAPI connectSourceExternalAPI) {
        this.connectSourceExternalAPI = connectSourceExternalAPI;
    }

    @GetMapping("/request-for-proposals/{id}")
    public ConnectRfpDTO getRfpById(@PathVariable("id") UUID id) {
        return connectSourceExternalAPI.getRfpById(id);
    }

    @PostMapping("/request-for-proposals")
    public UUID saveRfp(@RequestBody ConnectRfpCreationDTO dto) {
        return connectSourceExternalAPI.createRFP(dto);
    }
}
