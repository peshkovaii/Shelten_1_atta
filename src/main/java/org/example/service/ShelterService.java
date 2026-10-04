package org.example.service;

import org.example.core.Adopter;
import org.example.core.AdoptionRequest;
import org.example.core.Animal;
import org.example.core.enums.AnimalStatus;
import org.example.core.enums.RequestStatus;
import org.example.repository.AdopterRepository;
import org.example.repository.AdoptionRequestRepository;
import org.example.repository.AnimalRepository;

import java.util.List;

public class ShelterService {
    private final AnimalRepository animalRepository;
    private final AdopterRepository adopterRepository;
    private final AdoptionRequestRepository requestRepository;

    public ShelterService(AnimalRepository animalRepository, AdopterRepository adopterRepository,AdoptionRequestRepository requestRepository){
        this.animalRepository = animalRepository;
        this.adopterRepository = adopterRepository;
        this.requestRepository = requestRepository;
    }

    public Animal addAnimal(Animal animal){
        return animalRepository.save(animal);
    }

    public List<Animal> getAllAnimals(){
        return animalRepository.findAll();
    }

    public Animal getAnimal(Long id){
        return animalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Животное не найдено: " + id));
    }

    public void deleteAnimal(Long id){
        animalRepository.deleteById(id);
    }

    public Adopter addAdopter(Adopter adopter){
        return adopterRepository.save(adopter);
    }

    public List<Adopter> getAllAdopters(){
        return adopterRepository.findAll();
    }


    public AdoptionRequest createRequest(Long animalId, Long adopterId){
        Animal animal = getAnimal(animalId);
        if (animal.getStatus() == AnimalStatus.ADOPTED){
            throw new IllegalStateException("Животное уже усыновлено");
        }
        adopterRepository.findById(adopterId).orElseThrow(() -> new IllegalArgumentException("Усыновитель не найден"));

        AdoptionRequest req =new AdoptionRequest(animalId, adopterId);
        return requestRepository.save(req);
    }

    public List<AdoptionRequest> getAllRequests(){
        return requestRepository.findAll();
    }


    public void approveRequest(Long requestId){
        AdoptionRequest req = requestRepository.findById(requestId).orElseThrow(() -> new IllegalArgumentException("Заявка не найдена"));
        req.setStatus(RequestStatus.APPROVED);
        Animal animal = getAnimal(req.getAnimalId());
        animal.setStatus(AnimalStatus.ADOPTED);
        animalRepository.save(animal);
        requestRepository.save(req);

    }

}
