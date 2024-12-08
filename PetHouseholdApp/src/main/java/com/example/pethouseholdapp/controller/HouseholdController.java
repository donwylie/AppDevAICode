package com.example.pethouseholdapp.controller;

import com.example.pethouseholdapp.entity.Household;
import com.example.pethouseholdapp.service.HouseholdService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/households")
public class HouseholdController {

    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    // POST: Create a new household
    @PostMapping
    public ResponseEntity<Household> createHousehold(@Valid @RequestBody Household household) {
        return new ResponseEntity<>(householdService.createHousehold(household), HttpStatus.CREATED);
    }

    // PUT: Update an existing household
    @PutMapping("/{eircode}")
    public ResponseEntity<Household> updateHousehold(@PathVariable String eircode, @Valid @RequestBody Household household) {
        return new ResponseEntity<>(householdService.updateHousehold(eircode, household), HttpStatus.OK);
    }

    // GET: Retrieve all households
    @GetMapping
    public ResponseEntity<List<Household>> getAllHouseholds() {
        return new ResponseEntity<>(householdService.getAllHouseholds(), HttpStatus.OK);
    }

    // GET: Retrieve a specific household by eircode
    @GetMapping("/{eircode}")
    public ResponseEntity<Household> getHouseholdByEircode(@PathVariable String eircode) {
        return householdService.findByEircode(eircode)
                .map(household -> new ResponseEntity<>(household, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE: Remove a household by eircode
    @DeleteMapping("/{eircode}")
    public ResponseEntity<Void> deleteHousehold(@PathVariable String eircode) {
        householdService.deleteHousehold(eircode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}