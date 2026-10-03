package org.example.repository.inmemory;

import org.example.core.Animal;
import org.example.repository.AnimalRepository;

import java.util.*;

public class InMemoryAnimalRepository implements AnimalRepository {
    private final Map<Long, Animal> storage = new HashMap<>();
    private long nextId = 1;

    @Override
    public Animal save(Animal animal){
        if (animal.getId() == null){
            animal.setId(nextId++);
        }
        storage.put(animal.getId(), animal);
        return animal;
    }

    @Override
    public Optional<Animal> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Animal> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }
}
