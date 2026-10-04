package org.example.repository;


import org.example.core.AdoptionRequest;

import java.util.List;
import java.util.Optional;

public interface AdoptionRequestRepository {
    AdoptionRequest save(AdoptionRequest request);

    Optional<AdoptionRequest> findById(Long id);

    List<AdoptionRequest> findAll();

    void deleteById(Long id);
}
