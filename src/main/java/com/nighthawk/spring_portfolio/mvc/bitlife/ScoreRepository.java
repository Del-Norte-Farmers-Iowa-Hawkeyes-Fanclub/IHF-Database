package com.nighthawk.spring_portfolio.mvc.bitlife;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findTop10ByTypeOrderByScoreDesc(String type);
    Optional<Score> findByPlayerNameAndType(String playerName, String type);
}
