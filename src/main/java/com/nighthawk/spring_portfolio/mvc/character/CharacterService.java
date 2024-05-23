package com.nighthawk.spring_portfolio.mvc.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public Character createCharacter() {
        Character character = new Character(
            Character.generateWeight(),
            Character.generateHeight(),
            0,
            Character.generateName(),
            0,
            false
        );
        return characterRepository.save(character);
    }
}
