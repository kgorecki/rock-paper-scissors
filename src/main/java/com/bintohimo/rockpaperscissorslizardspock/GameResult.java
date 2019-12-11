package com.bintohimo.rockpaperscissorslizardspock;

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
