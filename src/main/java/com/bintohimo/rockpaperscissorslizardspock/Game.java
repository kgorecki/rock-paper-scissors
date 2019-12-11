package com.bintohimo.rockpaperscissorslizardspock;

import java.util.*;


public class Game {

    public enum GameType {
        RockPaperScissors(0),
        RockPaperScissorsLizardSpock(1);

        private final int value;
        GameType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    String choice;
    List<String> choices;
    Map<String, List<String>> beats;
    GameType gameType;

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

    private void checkValidity() {
        if (choices.contains(choice))
            return;

        throw new IllegalArgumentException(choice + " is not valid argument! Possible choices: " + choices.toString());
    }

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
}
