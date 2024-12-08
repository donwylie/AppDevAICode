package com.example.pethouseholdapp.controller;

import com.example.pethouseholdapp.entity.Pet;
import com.example.pethouseholdapp.service.PetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    // POST: Create a new pet
    @PostMapping
    public ResponseEntity<Pet> createPet(@Valid @RequestBody Pet pet) {
        return new ResponseEntity<>(petService.savePet(pet), HttpStatus.CREATED);
    }

    // PUT: Update an existing pet
    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @Valid @RequestBody Pet pet) {
        return new ResponseEntity<>(petService.updatePet(id, pet), HttpStatus.OK);
    }

    // GET: Retrieve all pets
    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        return new ResponseEntity<>(petService.getAllPets(), HttpStatus.OK);
    }

    // GET: Retrieve a specific pet by ID
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        return new ResponseEntity<>(petService.getPetById(id), HttpStatus.OK);
    }

    // DELETE: Remove a pet by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}