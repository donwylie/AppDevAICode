package com.example.pethouseholdapp;

import com.example.pethouseholdapp.entity.Household;
import com.example.pethouseholdapp.repository.HouseholdRepository;
import com.example.pethouseholdapp.service.HouseholdService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HouseholdServiceTest {

    @Mock
    private HouseholdRepository householdRepository;

    @InjectMocks
    private HouseholdService householdService;

    private Household testHousehold;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testHousehold = Household.builder()
                .eircode("E12345")
                .pets(new ArrayList<>())
                .build();
    }

    @Test
    void testCreateHousehold() {
        when(householdRepository.save(testHousehold)).thenReturn(testHousehold);

        Household createdHousehold = householdService.createHousehold(testHousehold);

        assertNotNull(createdHousehold);
        assertEquals("E12345", createdHousehold.getEircode());
        verify(householdRepository, times(1)).save(testHousehold);
    }

    @Test
    void testGetAllHouseholds() {
        List<Household> households = List.of(testHousehold);
        when(householdRepository.findAll()).thenReturn(households);

        List<Household> result = householdService.getAllHouseholds();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("E12345", result.get(0).getEircode());
        verify(householdRepository, times(1)).findAll();
    }

    @Test
    void testFindByEircode() {
        when(householdRepository.findById(Long.valueOf("E12345"))).thenReturn(Optional.of(testHousehold));

        Optional<Household> foundHousehold = householdService.findByEircode("E12345");

        assertTrue(foundHousehold.isPresent());
        assertEquals("E12345", foundHousehold.get().getEircode());
        verify(householdRepository, times(1)).findById(Long.valueOf("E12345"));
    }

    @Test
    void testUpdateHousehold() {
        when(householdRepository.findById(Long.valueOf("E12345"))).thenReturn(Optional.of(testHousehold));
        when(householdRepository.save(any(Household.class))).thenReturn(testHousehold);

        Household updatedHousehold = Household.builder().eircode("E12345").pets(new ArrayList<>()).build();
        Household result = householdService.updateHousehold("E12345", updatedHousehold);

        assertNotNull(result);
        assertEquals("E12345", result.getEircode());
        verify(householdRepository, times(1)).findById(Long.valueOf("E12345"));
        verify(householdRepository, times(1)).save(any(Household.class));
    }

    @Test
    void testDeleteHousehold() {
        when(householdRepository.findById(Long.valueOf("E12345"))).thenReturn(Optional.of(testHousehold));
        doNothing().when(householdRepository).delete(any(Household.class));

        householdService.deleteHousehold("E12345");

        verify(householdRepository, times(1)).findById(Long.valueOf("E12345"));
        verify(householdRepository, times(1)).delete(testHousehold);
    }
}