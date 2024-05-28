package com.nighthawk.spring_portfolio.mvc.bitlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bitlife")
public class DatabaseController {
    @Autowired
    private DatabaseService databaseService;

    @DeleteMapping("/clear")
    public void clearDatabase() {
        databaseService.clearDatabase();
    }
}
