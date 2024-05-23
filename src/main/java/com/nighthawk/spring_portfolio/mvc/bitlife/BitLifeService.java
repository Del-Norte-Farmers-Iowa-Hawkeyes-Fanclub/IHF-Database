package com.nighthawk.spring_portfolio.mvc.bitlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BitLifeService {
    @Autowired
    private EventRepository eventRepository;

    public Event getEvent(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.orElse(null);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> createEvents(List<Event> events) {
        return eventRepository.saveAll(events);
    }
}
