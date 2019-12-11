package com.bintohimo.rockpaperscissorslizardspock;

/**
 * Enum indicating type of the game: Rock-Paper-Scissors or Rock-Paper-Scissors-Lizard-Spock
 */
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
