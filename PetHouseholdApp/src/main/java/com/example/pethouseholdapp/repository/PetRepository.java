package com.example.pethouseholdapp.repository;

import com.example.pethouseholdapp.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}