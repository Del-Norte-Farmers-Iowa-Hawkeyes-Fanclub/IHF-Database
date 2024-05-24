package com.nighthawk.spring_portfolio.nbapredictor.monte_carlo;

public class Player {
    private String name;
    private PlayerStats stats;

    public Player() {
        this.stats = new PlayerStats();  // Initialize stats to avoid null
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerStats getStats() {
        return stats;
    }

    public void setStats(PlayerStats stats) {
        this.stats = stats;
    }
}