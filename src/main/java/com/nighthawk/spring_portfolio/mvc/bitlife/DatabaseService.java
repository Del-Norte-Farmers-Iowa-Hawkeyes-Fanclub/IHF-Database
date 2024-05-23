package com.nighthawk.spring_portfolio.mvc.bitlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    @Autowired
    private EventRepository eventRepository;

    public void clearDatabase() {
        eventRepository.deleteAll();
    }
}
