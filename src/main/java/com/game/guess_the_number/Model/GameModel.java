package com.game.guess_the_number.Model;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private int targetNumber;
    private int attempts;
    private List<Integer> numberOptions;
    public GameModel() {
        this.targetNumber = (int) (Math.random() * 100) + 1;
        this.attempts = 0;
        this.numberOptions = generateNumberOptions();
    }
    private List<Integer> generateNumberOptions() {
        List<Integer> options = new ArrayList<>();
        options.add(targetNumber);
        while (options.size() < 5) {
            int number = (int) (Math.random() * 100) + 1;
            if (!options.contains(number)) {
                options.add(number);
            }
        }
        java.util.Collections.shuffle(options);
        return options;
    }



    public int getTargetNumber() {
        return targetNumber;
    }

    public int getAttempts() {
        return attempts;
    }

    public List<Integer> getNumberOptions() {
        return numberOptions;
    }

    public void incrementAttempts() {
        this.attempts++;
    }
}