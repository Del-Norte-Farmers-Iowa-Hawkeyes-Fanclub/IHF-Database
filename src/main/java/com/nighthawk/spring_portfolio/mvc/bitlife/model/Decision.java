package com.nighthawk.spring_portfolio.mvc.bitlife.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Decision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long gameStateId;
    private String description;
    private Long nextStateId;
    private int incomeImpact;

    // Getters and Setters
}
