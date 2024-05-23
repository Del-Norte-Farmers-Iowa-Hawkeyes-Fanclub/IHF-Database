package com.nighthawk.spring_portfolio.mvc.bitlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public Score saveOrUpdateScore(String playerName, int score) {
        Score existingScore = scoreRepository.findByPlayerName(playerName);
        if (existingScore != null) {
            if (existingScore.getScore() < score) {
                existingScore.setScore(score);
                return scoreRepository.save(existingScore);
            } else {
                return existingScore;
            }
        } else {
            Score newScore = new Score();
            newScore.setPlayerName(playerName);
            newScore.setScore(score);
            return scoreRepository.save(newScore);
        }
    }

    public List<Score> getTopScores() {
        return scoreRepository.findTop10ByOrderByScoreDesc();
    }
}
