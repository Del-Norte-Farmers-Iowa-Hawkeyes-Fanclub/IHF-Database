package com.nighthawk.spring_portfolio.mvc.bitlife;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findTop10ByTypeOrderByScoreDesc(String type);
}
