package org.example.repository.inmemory;

import org.example.core.Adopter;
import org.example.repository.AdopterRepository;

import java.util.*;

public class InMemoryAdopterRepository implements AdopterRepository {
    private final Map<Long, Adopter> storage = new HashMap<>();
    private long nextId = 1;


    @Override
    public Adopter save(Adopter adopter){
        if (adopter.getId() == null){
            adopter.setId(nextId++);
        }
        storage.put(adopter.getId(), adopter);
        return adopter;
    }

    @Override
    public Optional<Adopter> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Adopter> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }
}
