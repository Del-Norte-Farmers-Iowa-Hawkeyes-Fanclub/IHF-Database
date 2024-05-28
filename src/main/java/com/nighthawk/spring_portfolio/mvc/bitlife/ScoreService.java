package com.nighthawk.spring_portfolio.mvc.bitlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public Score createOrUpdateScore(Score score) {
        Optional<Score> existingScore = scoreRepository.findByPlayerNameAndType(score.getPlayerName(), score.getType());
        if (existingScore.isPresent()) {
            Score scoreToUpdate = existingScore.get();
            if (score.getScore() > scoreToUpdate.getScore()) {
                scoreToUpdate.setScore(score.getScore());
                return scoreRepository.save(scoreToUpdate);
            } else {
                return scoreToUpdate;
            }
        } else {
            return scoreRepository.save(score);
        }
    }

    public List<Score> getTopScores(String type) {
        return scoreRepository.findTop10ByTypeOrderByScoreDesc(type);
    }
}
