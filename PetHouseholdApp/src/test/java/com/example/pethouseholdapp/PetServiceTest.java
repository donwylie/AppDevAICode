package com.example.pethouseholdapp;

import com.example.pethouseholdapp.entity.Household;
import com.example.pethouseholdapp.entity.Pet;
import com.example.pethouseholdapp.repository.PetRepository;
import com.example.pethouseholdapp.service.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PetServiceTest {

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetService petService;

    private Pet testPet;
    private Household testHousehold;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Sample data
        testHousehold = Household.builder().eircode("E12345").build();
        testPet = Pet.builder()
                .id(1L)
                .name("Buddy")
                .type("Dog")
                .age(3)
                .household(testHousehold)
                .build();
    }

    @Test
    void testSavePet() {
        when(petRepository.save(testPet)).thenReturn(testPet);

        Pet savedPet = petService.savePet(testPet);

        assertNotNull(savedPet);
        assertEquals("Buddy", savedPet.getName());
        verify(petRepository, times(1)).save(testPet);
    }

    @Test
    void testGetPetById() {
        when(petRepository.findById(1L)).thenReturn(Optional.of(testPet));

        Pet foundPet = petService.getPetById(1L);

        assertNotNull(foundPet);
        assertEquals("Buddy", foundPet.getName());
        verify(petRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdatePet() {
        when(petRepository.findById(1L)).thenReturn(Optional.of(testPet));
        when(petRepository.save(testPet)).thenReturn(testPet);

        Pet updatedPet = petService.updatePet(1L, testPet);

        assertNotNull(updatedPet);
        assertEquals("Buddy", updatedPet.getName());
        verify(petRepository, times(1)).save(testPet);
    }
}