package org.example.core.repository;

import org.example.core.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository {
    Animal save (Animal animal);
    Optional<Animal> findById (Long id);
    List<Animal> findAll();
    void deleteById(Long id);
}
