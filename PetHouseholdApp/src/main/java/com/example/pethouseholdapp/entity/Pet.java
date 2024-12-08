package com.example.pethouseholdapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Type is mandatory")
    @Column(nullable = false)
    private String type;

    @NotNull(message = "Age is mandatory")
    @Column(nullable = false)
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "household_eircode", referencedColumnName = "eircode", nullable = false)
    private Household household;
}