package com.littlebig.services.sourcing.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.littlebig.services.sourcing.model.Rfp;

@NoRepositoryBean
public interface AbstractRepository<T extends Rfp>
    extends CrudRepository<T, UUID> {
}
