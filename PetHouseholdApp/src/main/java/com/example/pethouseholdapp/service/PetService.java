package com.example.pethouseholdapp.service;

import com.example.pethouseholdapp.entity.Pet;
import com.example.pethouseholdapp.repository.PetRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    // Create a new pet
    public Pet createPet(@Valid Pet pet) {
        return petRepository.save(pet);
    }

    // Retrieve all pets
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    // Delete a pet by ID
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    // Save a pet (for use in create or update scenarios)
    public Pet savePet(@Valid Pet pet) {
        return petRepository.save(pet);
    }

    // Update an existing pet
    public Pet updatePet(Long id, @Valid Pet updatedPet) {
        return petRepository.findById(id)
                .map(existingPet -> {
                    existingPet.setName(updatedPet.getName());
                    existingPet.setType(updatedPet.getType());
                    existingPet.setAge(updatedPet.getAge());
                    existingPet.setHousehold(updatedPet.getHousehold());
                    return petRepository.save(existingPet);
                })
                .orElseThrow(() -> new IllegalArgumentException("Pet not found with ID: " + id));
    }

    // Retrieve a pet by ID
    public Pet getPetById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pet not found with ID: " + id));
    }
}