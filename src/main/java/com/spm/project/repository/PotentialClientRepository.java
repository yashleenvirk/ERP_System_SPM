package com.spm.project.repository;

import com.spm.project.domain.ClientEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PotentialClientRepository extends CrudRepository<ClientEvent, Long>{
        List<ClientEvent> getAllByHasDoneFalse();
        ClientEvent getById(Long id);
    }