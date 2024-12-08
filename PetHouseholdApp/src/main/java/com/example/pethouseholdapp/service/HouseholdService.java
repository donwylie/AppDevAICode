package com.example.pethouseholdapp.service;

import com.example.pethouseholdapp.entity.Household;
import com.example.pethouseholdapp.repository.HouseholdRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HouseholdService {

    private final HouseholdRepository householdRepository;

    // Create a new household
    public Household createHousehold(@Valid Household household) {
        return householdRepository.save(household);
    }

    // Retrieve all households
    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    // Retrieve a household by eircode
    public Optional<Household> findByEircode(String eircode) {
        return householdRepository.findById(Long.valueOf(eircode));
    }

    // Update an existing household
    public Household updateHousehold(String eircode, @Valid Household updatedHousehold) {
        Household existingHousehold = findByEircode(eircode)
                .orElseThrow(() -> new IllegalArgumentException("Household with eircode " + eircode + " not found"));

        // Update fields
        existingHousehold.setPets(updatedHousehold.getPets());

        return householdRepository.save(existingHousehold);
    }

    // Delete a household by eircode
    public void deleteHousehold(String eircode) {
        Household existingHousehold = findByEircode(eircode)
                .orElseThrow(() -> new IllegalArgumentException("Household with eircode " + eircode + " not found"));
        householdRepository.delete(existingHousehold);
    }

    // Save a household (helper method)
    public Household saveHousehold(@Valid Household household) {
        return householdRepository.save(household);
    }
    // Retrieve a household by Eircode with pets eagerly
    public Optional<Household> findByEircodeWithPets(String eircode) {
        return householdRepository.findByEircodeWithPets(eircode);
    }
    // Find list of households with no pets
    public List<Household> findHouseholdsWithNoPets() {
        return householdRepository.findHouseholdsWithNoPets();
    }
}