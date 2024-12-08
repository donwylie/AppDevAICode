package com.example.pethouseholdapp.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationErrorResponse {
    private String message;
    private Map<String, String> errors;
    private LocalDateTime timestamp;

    public ValidationErrorResponse(String message, Map<String, String> errors) {
        this.message = message;
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and setters
}