package org.example.core;

import org.example.core.enums.RequestStatus;

import java.time.LocalDate;

public class AdoptionRequest {
    private Long id;
    private Long animalId;
    private Long adopterId;
    private LocalDate creatData;
    private RequestStatus status;

    public AdoptionRequest() {
    }

    public AdoptionRequest(Long animalId, Long adopterId) {
        this.animalId = animalId;
        this.adopterId = adopterId;
        this.creatData = LocalDate.now();
        this.status = RequestStatus.PENDING; // на рассмотрении
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public Long getAdopterId() {
        return adopterId;
    }

    public void setAdopterId(Long adopterId) {
        this.adopterId = adopterId;
    }

    public LocalDate getCreatData() {
        return creatData;
    }

    public void setCreatData(LocalDate creatData) {
        this.creatData = creatData;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return String.format("Заявка [%d]: animal=%d, adopter=%d, %s, %s",
                id, animalId, adopterId, creatData, status);
    }


}
