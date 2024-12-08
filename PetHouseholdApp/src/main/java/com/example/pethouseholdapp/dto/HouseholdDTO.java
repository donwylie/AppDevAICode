package com.example.pethouseholdapp.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseholdDTO {
    private String eircode; // Eircode of the household
    private List<String> petNames; // List of pet names in the household
}