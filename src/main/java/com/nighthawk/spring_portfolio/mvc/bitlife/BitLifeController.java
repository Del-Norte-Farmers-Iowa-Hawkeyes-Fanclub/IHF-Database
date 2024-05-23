package com.nighthawk.spring_portfolio.mvc.bitlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bitlife")
public class BitLifeController {
    @Autowired
    private BitLifeService bitLifeService;

    @GetMapping("/event/{id}")
    public Event getEvent(@PathVariable Long id) {
        return bitLifeService.getEvent(id);
    }

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return bitLifeService.getAllEvents();
    }

    @PostMapping("/event")
    public Event createEvent(@RequestBody Event event) {
        return bitLifeService.createEvent(event);
    }

    @PostMapping("/events")
    public List<Event> createEvents(@RequestBody List<Event> events) {
        return bitLifeService.createEvents(events);
    }
}
