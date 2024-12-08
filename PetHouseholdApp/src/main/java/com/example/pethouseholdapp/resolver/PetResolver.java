package com.example.pethouseholdapp.resolver;

import com.example.pethouseholdapp.entity.Household;
import com.example.pethouseholdapp.entity.Pet;
import com.example.pethouseholdapp.service.HouseholdService;
import com.example.pethouseholdapp.service.PetService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PetResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final PetService petService;
    private final HouseholdService householdService;

    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    public Pet createPet(String name, String type, int age, String eircode) {
        Household household = householdService.findByEircode(eircode)
                .orElseThrow(() -> new IllegalArgumentException("Household not found"));

        Pet pet = Pet.builder().name(name).type(type).age(age).household(household).build();
        return petService.createPet(pet);
    }
}