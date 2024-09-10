package com.game.guess_the_number.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private int targetNumber;
    private int attempts;

    public GameService() {
        resetGame();
    }

    public void resetGame() {
        targetNumber = (int) (Math.random() * 100) + 1;
        attempts = 0;
    }

    public boolean checkGuess(int guess) {
        return guess == targetNumber;
    }

    public List<Integer> getNumberOptions() {
        List<Integer> options = new ArrayList<>();
        options.add(targetNumber);
        while (options.size() < 10) {int number = (int) (Math.random() * 100) + 1;
            if (!options.contains(number)) {
                options.add(number);
            }
        }
        java.util.Collections.shuffle(options);
        return options;
    }

    public int incrementAttempts() {
        return ++attempts;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public int getAttempts() {
        return attempts;
    }
}