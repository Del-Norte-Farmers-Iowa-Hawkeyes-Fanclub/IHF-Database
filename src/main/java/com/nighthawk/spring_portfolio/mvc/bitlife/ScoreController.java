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
    public Score saveOrUpdateScore(@RequestBody Score score) {
        return scoreService.saveOrUpdateScore(score.getPlayerName(), score.getScore());
    }

    @GetMapping
    public List<Score> getTopScores() {
        return scoreService.getTopScores();
    }
}
