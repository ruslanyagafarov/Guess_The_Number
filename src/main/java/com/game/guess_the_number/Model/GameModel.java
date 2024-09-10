package com.game.guess_the_number.Model;

public class GameModel {
    private int targetNumber;
    private int attempts;

    public GameModel() {
        this.targetNumber = (int) (Math.random() * 100) + 1;
        this.attempts = 0;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public int getAttempts() {
        return attempts;
    }

    public void incrementAttempts() {
        this.attempts++;
    }
}
