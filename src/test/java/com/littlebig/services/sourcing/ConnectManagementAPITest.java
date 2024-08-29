package com.littlebig.services.sourcing;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import com.littlebig.services.sourcing.api.ConnectRfpCreationDTO;
import com.littlebig.services.sourcing.api.ConnectRfpDTO;
import com.littlebig.services.sourcing.model.WorkUnitType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConnectManagementAPITest {

  @Autowired
  TestRestTemplate restTemplate;

  @Test
  void shouldAddNewRfp() {
    ConnectRfpCreationDTO rfp = new ConnectRfpCreationDTO("test", "test",
        WorkUnitType.DAYS,120d);
    UUID rfpId = restTemplate.postForObject("/api/v1/connect/request-for-proposals", rfp, UUID.class);
    assertNotNull(rfpId);
  }

  @Test
  void shouldRetrieveRfp() {

    ConnectRfpCreationDTO rfp = new ConnectRfpCreationDTO("test2", "test2",
        WorkUnitType.DAYS,120d);
    UUID rfpId = restTemplate.postForObject("/api/v1/connect/request-for-proposals", rfp, UUID.class);
    assertNotNull(rfpId);
    ConnectRfpDTO rfpDTO = restTemplate.getForObject("/api/v1/connect/request-for-proposals/{id}", ConnectRfpDTO.class, rfpId);
    assertNotNull(rfpDTO);
    assertNotNull(rfpDTO.id());
    assertEquals(rfpId, rfpDTO.id());
  }
}