package com.nighthawk.spring_portfolio.mvc.bitlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bitlife/farmer")
public class FarmerEventController {
    @Autowired
    private FarmerEventService farmerEventService;

    @GetMapping("/event/{id}")
    public FarmerEvent getEvent(@PathVariable Long id) {
        return farmerEventService.getEvent(id);
    }

    @GetMapping("/events")
    public List<FarmerEvent> getAllEvents() {
        return farmerEventService.getAllEvents();
    }

    @PostMapping("/event")
    public FarmerEvent createEvent(@RequestBody FarmerEvent event) {
        return farmerEventService.createEvent(event);
    }

    @PostMapping("/events")
    public List<FarmerEvent> createEvents(@RequestBody List<FarmerEvent> events) {
        return farmerEventService.createEvents(events);
    }
}
