package org.example.core.repository;

import org.example.core.Adopter;

import java.util.List;
import java.util.Optional;

public interface AdopterRepository {
    Adopter save (Adopter adopter);
    Optional<Adopter> findById (Long id);
    List<Adopter> findAll();
    void deleteById(Long id);
}
