package org.example;

import org.example.repository.AdopterRepository;
import org.example.repository.AdoptionRequestRepository;
import org.example.repository.AnimalRepository;
import org.example.repository.inmemory.InMemoryAdopterRepository;
import org.example.repository.inmemory.InMemoryAdoptionRequestRepository;
import org.example.repository.inmemory.InMemoryAnimalRepository;
import org.example.service.ShelterService;
import org.example.ui.ConsoleUI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AnimalRepository animalRepository = new InMemoryAnimalRepository();
        AdopterRepository adopterRepository = new InMemoryAdopterRepository();
        AdoptionRequestRepository adoptionRequestRepository = new InMemoryAdoptionRequestRepository();


        ShelterService service = new ShelterService(animalRepository, adopterRepository, adoptionRequestRepository);

        new ConsoleUI(service).run();
    }
}