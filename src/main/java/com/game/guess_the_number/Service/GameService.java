package com.game.guess_the_number.Service;

import com.game.guess_the_number.Model.GameModel;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private GameModel game;

    public GameService() {
        this.game = new GameModel();
    }

    public String guess(int number) {
        game.incrementAttempts();
        if (number == game.getTargetNumber()) {
            return "Поздравляем, вы угадали число " + number + " с " + game.getAttempts() + " попыток!";
        } else if (number < game.getTargetNumber()) {
            return "Загаданное число больше!";
        } else {
            return "Загаданное число меньше!";
        }
    }

    public void resetGame() {
        this.game = new GameModel();
    }
}
