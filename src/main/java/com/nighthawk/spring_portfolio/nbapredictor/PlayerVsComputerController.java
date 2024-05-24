package com.nighthawk.spring_portfolio.nbapredictor;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlayerVsComputerController {
    private List<String> currentPlayers = Arrays.asList(
        "LeBron James", "Anthony Davis", "D'Angelo Russell", "Jayson Tatum", "Jaylen Brown", "Derrick White",
        "Jalen Brunson", "Josh Hart", "Joel Embiid", "Tyrese Maxey", "Tyrese Haliburton", "Domantas Sabonis",
        "Shai Gilgeous-Alexander", "Luka Doncic", "Kyrie Irving", "Anthony Edwards", "Karl-Anthony Towns",
        "Rudy Gobert", "Donovan Mitchell", "Trae Young", "Scottie Barnes", "Kawhi Leonard", "Paul George",
        "Russell Westbrook", "Victor Wembanyama", "Cade Cunningham", "LaMelo Ball", "Jalen Green", "Damian Lillard",
        "Giannis Antetokounmpo", "Stephen Curry", "Draymond Green", "Klay Thompson", "Kevin Durant", "Devin Booker",
        "Bradley Beal", "Nikola Jokic", "Jamal Murray", "Aaron Gordon", "Jimmy Butler"
    );

    private List<String> allTimePlayers = Arrays.asList(
        "LeBron James", "Kareem Abdul-Jabbar", "Wilt Chamberlain", "Kobe Bryant", "Shaquille O'Neal", "Jerry West",
        "Oscar Robertson", "Tim Duncan", "Stephen Curry", "Magic Johnson", "Michael Jordan", "Scottie Pippen",
        "Larry Bird", "Bill Russell", "Hakeem Olajuwon", "Jason Kidd", "Kevin Durant", "Moses Malone", "Karl Malone",
        "Kevin Garnett", "Paul Pierce", "Isiah Thomas", "Derrick Rose", "Dirk Nowitzki", "Julius Erving", "Elgin Baylor",
        "Dwayne Wade", "Charles Barkley", "John Havlicek", "Allen Iverson", "John Stockton", "Steve Nash", "Patrick Ewing",
        "Bob Cousy", "Rick Barry", "Dominique Wilkins", "Gary Payton", "Clyde Drexler", "Reggie Miller", "Ray Allen"
    );

    private final Random random = new Random();

    @PostMapping("/player-vs-computer")
    public Map<String, Object> playerVsComputer(@RequestBody Map<String, String> request) {
        String playerChoice = request.get("player");
        String listChoice = request.get("list");
        List<String> chosenList = listChoice.equals("current") ? currentPlayers : allTimePlayers;

        Map<String, Object> response = new HashMap<>();
        response.put("userChoice", playerChoice);
        response.put("userScore", calculateFantasyScore(playerChoice));

        List<String> availablePlayers = new ArrayList<>(chosenList);
        availablePlayers.removeAll(Collections.singleton(playerChoice));

        String computerChoice = availablePlayers.get(random.nextInt(availablePlayers.size()));
        response.put("computerChoice", computerChoice);
        response.put("computerScore", calculateFantasyScore(computerChoice));

        return response;
    }

    private double calculateFantasyScore(String player) {
        return 20 + (150 - 20) * random.nextDouble();  // Random score between 20 and 150
    }
}
