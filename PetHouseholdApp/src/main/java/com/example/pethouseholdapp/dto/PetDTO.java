package com.example.pethouseholdapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetDTO {
    private String name; // Name of the pet
    private String type; // Type of pet (e.g., Dog, Cat)
    private int age; // Age of the pet
    private String householdEircode; // Eircode of the household this pet belongs to
}