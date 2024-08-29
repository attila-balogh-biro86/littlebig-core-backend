package com.littlebig.services.sourcing.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.littlebig.services.common.exception.ResourceNotFoundException;
import com.littlebig.services.sourcing.api.RiseRfpCreationDTO;
import com.littlebig.services.sourcing.api.RiseSourceExternalAPI;
import com.littlebig.services.sourcing.api.RiseSourceInternalAPI;
import com.littlebig.services.sourcing.api.RiseRfpDTO;
import com.littlebig.services.sourcing.mapper.RiseRfpMapper;
import com.littlebig.services.sourcing.model.RiseRfp;
import com.littlebig.services.sourcing.repository.RiseRfpRepository;

@Service
public class RiseSourceManagementService implements RiseSourceInternalAPI, RiseSourceExternalAPI {

    private static final Logger LOG = LoggerFactory.getLogger(RiseSourceManagementService.class);
    private final RiseRfpRepository riseRfpRepository;
    private final RiseRfpMapper rfpMapper;
    private static final String RFP_NOT_FOUND = "Rfp with the given id not found.";

    public RiseSourceManagementService(RiseRfpRepository riseRfpRepository, RiseRfpMapper rfpMapper) {
        this.riseRfpRepository = riseRfpRepository;
        this.rfpMapper = rfpMapper;
    }

    @Override
    public UUID createRFP(RiseRfpCreationDTO rfpDTO) {
        LOG.debug("Create RFP with RFP DTO: {}", rfpDTO);
        RiseRfp rfp = rfpMapper.rfpDtoToRfp(rfpDTO);
        riseRfpRepository.save(rfp);
        return rfp.getId();
    }

    @Override
    public RiseRfpDTO getRfpById(UUID id) {
        RiseRfp rfp = riseRfpRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(RFP_NOT_FOUND, id));
        return rfpMapper.rfpToRfpDTO(rfp);
    }

    @Override
    public List<RiseRfpDTO> getAllRFPsByCustomerId(UUID customerId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
