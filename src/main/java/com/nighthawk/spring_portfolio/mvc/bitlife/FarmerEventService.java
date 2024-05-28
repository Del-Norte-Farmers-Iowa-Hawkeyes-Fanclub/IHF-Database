package com.nighthawk.spring_portfolio.mvc.bitlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class FarmerEventService {
    private static final Logger LOGGER = Logger.getLogger(FarmerEventService.class.getName());

    @Autowired
    private FarmerEventRepository farmerEventRepository;

    public FarmerEvent getEvent(Long id) {
        LOGGER.info("Fetching farmer event with ID: " + id);
        Optional<FarmerEvent> event = farmerEventRepository.findById(id);
        if (event.isPresent()) {
            LOGGER.info("Farmer event found: " + event.get());
        } else {
            LOGGER.info("Farmer event not found for ID: " + id);
        }
        return event.orElse(null);
    }

    public FarmerEvent createEvent(FarmerEvent event) {
        LOGGER.info("Creating farmer event: " + event);
        return farmerEventRepository.save(event);
    }

    public List<FarmerEvent> createEvents(List<FarmerEvent> events) {
        LOGGER.info("Creating farmer events: " + events);
        return farmerEventRepository.saveAll(events);
    }

    public List<FarmerEvent> getAllEvents() {
        return farmerEventRepository.findAll();
    }
}
