package com.littlebig.services.sourcing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.littlebig.services.sourcing.api.ConnectRfpCreationDTO;
import com.littlebig.services.sourcing.api.ConnectRfpDTO;
import com.littlebig.services.sourcing.api.RiseRfpCreationDTO;
import com.littlebig.services.sourcing.model.WorkUnitType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RiseManagementAPITest {

  @Autowired
  TestRestTemplate restTemplate;

  @Test
  void shouldAddNewRfp() {
    RiseRfpCreationDTO rfp = new RiseRfpCreationDTO("test", "test",
        WorkUnitType.DAYS,120d, UUID.randomUUID());
    UUID rfpId = restTemplate.postForObject("/api/rise/request-for-proposals", rfp, UUID.class);
    assertNotNull(rfpId);
  }

  @Test
  void shouldRetrieveRfp() {

    RiseRfpCreationDTO rfp = new RiseRfpCreationDTO("test", "test",
        WorkUnitType.DAYS,120d, UUID.randomUUID());
    UUID rfpId = restTemplate.postForObject("/api/rise/request-for-proposals", rfp, UUID.class);
    assertNotNull(rfpId);
    ConnectRfpDTO rfpDTO = restTemplate.getForObject("/api/rise/request-for-proposals/{id}", ConnectRfpDTO.class, rfpId);
    assertNotNull(rfpDTO);
    assertNotNull(rfpDTO.id());
    assertEquals(rfpId, rfpDTO.id());
  }
}