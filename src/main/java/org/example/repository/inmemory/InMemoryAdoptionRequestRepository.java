package org.example.repository.inmemory;


import org.example.core.AdoptionRequest;
import org.example.repository.AdoptionRequestRepository;

import java.util.*;

public class InMemoryAdoptionRequestRepository implements AdoptionRequestRepository {
    private final Map<Long, AdoptionRequest> storage = new HashMap<>();
    private long nextId = 1;


    @Override
    public AdoptionRequest save(AdoptionRequest request) {
        if (request.getId() == null) {
            request.setId(nextId++);
        }
        storage.put(request.getId(), request);
        return request;
    }

    @Override
    public Optional<AdoptionRequest> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<AdoptionRequest> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }


}
