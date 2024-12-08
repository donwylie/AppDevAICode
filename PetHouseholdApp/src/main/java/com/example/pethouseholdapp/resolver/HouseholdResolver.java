package com.example.pethouseholdapp.resolver;

import com.example.pethouseholdapp.entity.Household;
import com.example.pethouseholdapp.service.HouseholdService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HouseholdResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final HouseholdService householdService;

    public Household getHouseholdByEircode(String eircode) {
        return householdService.findByEircode(eircode)
                .orElseThrow(() -> new IllegalArgumentException("Household with Eircode " + eircode + " not found"));
    }

    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    public Household createHousehold(String eircode) {
        Household household = Household.builder().eircode(eircode).build();
        return householdService.createHousehold(household);
    }
}