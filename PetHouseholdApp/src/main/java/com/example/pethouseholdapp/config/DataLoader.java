package com.example.pethouseholdapp.config;

import com.example.pethouseholdapp.entity.Household;
import com.example.pethouseholdapp.entity.User;
import com.example.pethouseholdapp.repository.UserRepository;
import com.example.pethouseholdapp.service.HouseholdService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    HouseholdService householdService;

    // Query to get a household by Eircode
    public Household getHouseholdByEircode(String eircode) {
        return householdService.findByEircode(eircode)
                .orElseThrow(() -> new IllegalArgumentException("Household with Eircode " + eircode + " not found"));
    }
    // Query to get a household by Eircode with pets eagerly
    public Household getHouseholdByEircodeWithPets(String eircode) {
        return householdService.findByEircodeWithPets(eircode)
                .orElseThrow(() -> new IllegalArgumentException("Household with Eircode " + eircode + " not found"));
    }
    // Mutation to create a new household
    public Household createHousehold(String eircode) {
        Household household = Household.builder().eircode(eircode).build();
        return householdService.createHousehold(household);
    }
    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin123"))
                    .role("ROLE_ADMIN")
                    .build();
            userRepository.save(admin);
        }
        System.out.println("Admin user created with username 'admin' and password 'admin123'");
    }

}