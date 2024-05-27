package com.nighthawk.spring_portfolio.mvc.bitlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bitlife/basketball")
public class BasketballEventController {
    @Autowired
    private BasketballEventService basketballEventService;

    @GetMapping("/event/{id}")
    public BasketballEvent getEvent(@PathVariable Long id) {
        return basketballEventService.getEvent(id);
    }

    @GetMapping("/events")
    public List<BasketballEvent> getAllEvents() {
        return basketballEventService.getAllEvents();
    }

    @PostMapping("/event")
    public BasketballEvent createEvent(@RequestBody BasketballEvent event) {
        return basketballEventService.createEvent(event);
    }

    @PostMapping("/events")
    public List<BasketballEvent> createEvents(@RequestBody List<BasketballEvent> events) {
        return basketballEventService.createEvents(events);
    }
}
