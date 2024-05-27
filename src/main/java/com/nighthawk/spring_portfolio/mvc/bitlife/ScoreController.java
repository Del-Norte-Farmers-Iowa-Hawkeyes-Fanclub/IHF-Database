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
    public Score createScore(@RequestBody Score score) {
        return scoreService.createScore(score);
    }

    @GetMapping("/basketball")
    public List<Score> getTopBasketballScores() {
        return scoreService.getTopScores("basketball");
    }

    @GetMapping("/farmer")
    public List<Score> getTopFarmerScores() {
        return scoreService.getTopScores("farmer");
    }
}
