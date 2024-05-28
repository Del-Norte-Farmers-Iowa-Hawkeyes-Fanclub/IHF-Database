package com.nighthawk.spring_portfolio.mvc.bitlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BitLifeService {
    private static final Logger LOGGER = Logger.getLogger(BitLifeService.class.getName());

    @Autowired
    private EventRepository eventRepository;

    public Event getEvent(Long id) {
        LOGGER.info("Fetching event with ID: " + id);
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            LOGGER.info("Event found: " + event.get());
        } else {
            LOGGER.info("Event not found for ID: " + id);
        }
        return event.orElse(null);
    }

    public Event createEvent(Event event) {
        LOGGER.info("Creating event: " + event);
        return eventRepository.save(event);
    }

    public List<Event> createEvents(List<Event> events) {
        LOGGER.info("Creating events: " + events);
        return eventRepository.saveAll(events);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
