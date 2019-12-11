package com.bintohimo.rockpaperscissorslizardspock;

import java.util.*;

/**
 * Game class handles game logic
 */
public class Game {

    private String choice;                      // stores user's choice
    private List<String> choices;               // stores available choices
    private Map<String, List<String>> beats;    // stores information which choice beats which choices
    private GameType gameType;                  // Rock-Paper-Scissors or Rock-Paper-Scissors-Lizard-Spock?

    public Game(String choice, GameType gameType) {
        choices = new ArrayList<String>(Arrays.asList("Rock", "Paper", "Scissors"));
        beats = new HashMap<String, List<String>>();
        beats.put("Rock", new ArrayList<String>(Arrays.asList("Scissors")));
        beats.put("Paper", new ArrayList<String>(Arrays.asList("Rock")));
        beats.put("Scissors", new ArrayList<String>(Arrays.asList("Paper")));
        if (gameType == GameType.RockPaperScissorsLizardSpock) {
            choices.add("Lizard");
            choices.add("Spock");
            beats.get("Rock").add("Lizard");
            beats.get("Paper").add("Spock");
            beats.get("Scissors").add("Lizard");
            beats.put("Lizard", new ArrayList<String>(Arrays.asList("Spock", "Paper")));
            beats.put("Spock", new ArrayList<String>(Arrays.asList("Scissors", "Rock")));
        }
        this.choice = choice;
        this.gameType = gameType;
    }

    /**
     * Main entry point for the game
     * @return result of the game and opponent's choice
     */
    public GameResult getResult() {
        checkValidity();

        Random random = new Random();
        int range = gameType == GameType.RockPaperScissorsLizardSpock ? 5 : 3;
        String opponent = choices.get(random.nextInt(range * 1000) / 1000);

        if (opponent.equals(choice))
            return new GameResult(GameResult.GameResultType.Draw, opponent);

        if (beats.get(choice).contains(opponent))
            return new GameResult(GameResult.GameResultType.Win, opponent);

        return new GameResult(GameResult.GameResultType.Lose, opponent);
    }

    /**
     * Checks if user entered valid choice
     */
    private void checkValidity() {
        if (choices.contains(choice))
            return;

        throw new IllegalArgumentException(choice + " is not valid argument! Possible choices: " + choices.toString());
    }

}
