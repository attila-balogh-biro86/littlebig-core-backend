package com.littlebig.services.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.modulith.events.IncompleteEventPublications;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class IncompleteEventDeliveryHandlerManagement {

  private static final Logger LOGGER = LoggerFactory.getLogger(IncompleteEventDeliveryHandlerManagement.class);
  private final IncompleteEventPublications incompleteEventPublications;

  public IncompleteEventDeliveryHandlerManagement(IncompleteEventPublications incompleteEventPublications) {
    this.incompleteEventPublications = incompleteEventPublications;
  }

  @Scheduled(fixedDelay = 60_000)
  public void retryFailedEvents() {
    LOGGER.info("Retrying failed event deliveries");
    incompleteEventPublications.resubmitIncompletePublications(ep -> Boolean.TRUE);
  }
}

