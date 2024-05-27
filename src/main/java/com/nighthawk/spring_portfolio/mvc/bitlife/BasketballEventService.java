package com.nighthawk.spring_portfolio.mvc.bitlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BasketballEventService {
    private static final Logger LOGGER = Logger.getLogger(BasketballEventService.class.getName());

    @Autowired
    private BasketballEventRepository basketballEventRepository;

    public BasketballEvent getEvent(Long id) {
        LOGGER.info("Fetching basketball event with ID: " + id);
        Optional<BasketballEvent> event = basketballEventRepository.findById(id);
        if (event.isPresent()) {
            LOGGER.info("Basketball event found: " + event.get());
        } else {
            LOGGER.info("Basketball event not found for ID: " + id);
        }
        return event.orElse(null);
    }

    public BasketballEvent createEvent(BasketballEvent event) {
        LOGGER.info("Creating basketball event: " + event);
        return basketballEventRepository.save(event);
    }

    public List<BasketballEvent> createEvents(List<BasketballEvent> events) {
        LOGGER.info("Creating basketball events: " + events);
        return basketballEventRepository.saveAll(events);
    }

    public List<BasketballEvent> getAllEvents() {
        return basketballEventRepository.findAll();
    }
}
