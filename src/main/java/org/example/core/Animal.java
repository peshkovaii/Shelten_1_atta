package org.example.core;

import org.example.core.enums.AnimalStatus;
import org.example.core.enums.Species;
import java.time.LocalDate;


public class Animal {
    private Long id;
    private String name;
    private Species species;
    private String breed;
    private int age;
    private AnimalStatus status;
    private LocalDate arrivalDate;

    public Animal(){}

    public Animal(String name, Species species, String breed, int age){
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.status = AnimalStatus.IN_SHELTER;
        this.arrivalDate = LocalDate.now();

    }

    public Long getId() { return id;}
    public void setId(Long id) { this.id = id;}
    public String getName() { return name;}
    public void setName(String name) { this.name = name;}
    public Species getSpecies() {return species;}
    public void setSpecies(Species species) {this.species = species;}
    public String getBreed() {return breed;}
    public void setBreed(String breed) {this.breed = breed;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public AnimalStatus getStatus() {return status;}
    public void setStatus(AnimalStatus status) {this.status = status;}
    public LocalDate getArrivalDate() {return arrivalDate;}
    public void setArrivalDate(LocalDate arrivalDate){this.arrivalDate = arrivalDate;}

    @Override
    public String toString(){
        return String.format("[%d] %s (%s, %s, %d лет) - %s",
                id, name, species, breed, age, status);

    }

}
