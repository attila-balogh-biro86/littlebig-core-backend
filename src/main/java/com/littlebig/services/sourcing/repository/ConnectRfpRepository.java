package com.littlebig.services.sourcing.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.littlebig.services.sourcing.model.ConnectRfp;

@Repository
public interface ConnectRfpRepository extends AbstractRepository<ConnectRfp> {

  List<ConnectRfp> findConnectRfpByRfpApplicantClientId(UUID rfpApplicantClientId);
}
