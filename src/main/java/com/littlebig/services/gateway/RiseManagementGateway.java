package com.littlebig.services.gateway;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.littlebig.services.sourcing.api.RiseSourceExternalAPI;
import com.littlebig.services.sourcing.api.RiseRfpDTO;

@RestController
@RequestMapping("/api/rise")
public class RiseManagementGateway {

    private final RiseSourceExternalAPI riseSourceExternalAPI;

    @Autowired
    public RiseManagementGateway(RiseSourceExternalAPI riseSourceExternalAPI) {
        this.riseSourceExternalAPI = riseSourceExternalAPI;
    }

    @GetMapping("/request-for-proposals/{id}")
    public RiseRfpDTO getRfpById(@PathVariable("id") UUID id) {
        return riseSourceExternalAPI.getRfpById(id);
    }
}
