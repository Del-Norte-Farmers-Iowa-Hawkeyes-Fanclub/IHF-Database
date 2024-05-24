package com.nighthawk.spring_portfolio.nbapredictor.monte_carlo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MonteCarloSimulatorUpgrade {

    private final Random random = new Random();

    public Map<String, Double[]> simulateFantasyPoints(GameTeams teamsData) {
        double randomScoreA = 50 + (150 - 50) * random.nextDouble();  // Random score between 50 and 150
        double randomScoreB = 50 + (150 - 50) * random.nextDouble();  // Random score between 50 and 150

        Map<String, Double[]> response = new HashMap<>();
        response.put("projectedFantasyPointsTeamA", new Double[]{randomScoreA});
        response.put("projectedFantasyPointsTeamB", new Double[]{randomScoreB});

        return response;
    }
}
