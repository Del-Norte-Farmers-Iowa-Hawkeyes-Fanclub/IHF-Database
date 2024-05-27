package com.nighthawk.spring_portfolio.mvc.bitlife;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketballEventRepository extends JpaRepository<BasketballEvent, Long> {
}
