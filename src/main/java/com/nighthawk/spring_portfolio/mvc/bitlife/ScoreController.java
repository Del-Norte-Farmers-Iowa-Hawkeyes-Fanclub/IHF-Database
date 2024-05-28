package com.nighthawk.spring_portfolio.mvc.bitlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bitlife/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping
    public Score createOrUpdateScore(@RequestBody Score score) {
        return scoreService.createOrUpdateScore(score);
    }

    @GetMapping("/basketball")
    public List<Score> getTopBasketballScores() {
        return scoreService.getTopScores("basketball");
    }

    @GetMapping("/farming")
    public List<Score> getTopFarmerScores() {
        return scoreService.getTopScores("farming");
    }
}
