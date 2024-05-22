package com.nighthawk.spring_portfolio.mvc.bitlife.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class GameState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToMany(mappedBy = "gameStateId")
    private List<Decision> decisions;

    // Getters and Setters
}
