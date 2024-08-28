package com.littlebig.services.client.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.littlebig.services.client.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, UUID> {

}
