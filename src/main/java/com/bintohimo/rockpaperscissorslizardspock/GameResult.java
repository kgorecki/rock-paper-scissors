package com.bintohimo.rockpaperscissorslizardspock;

/**
 * Class holding result of the game and opponent's choice
 */
public class GameResult {

    public enum GameResultType {
        Win,
        Lose,
        Draw
    }

    public GameResultType gameResultType;

    public String value;    // opponent's value

    public GameResult(GameResultType gameResultType, String value) {
        this.gameResultType = gameResultType;
        this.value = value;
    }
}
