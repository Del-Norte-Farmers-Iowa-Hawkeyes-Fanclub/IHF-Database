package com.nighthawk.spring_portfolio.mvc.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/create")
    public Character createCharacter() {
        return characterService.createCharacter();
    }
}
