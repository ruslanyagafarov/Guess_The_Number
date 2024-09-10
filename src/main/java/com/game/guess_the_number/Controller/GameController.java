package com.game.guess_the_number.Controller;

import com.game.guess_the_number.Service.GameService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/guess")
    public String processGuess(@RequestParam int number, Model model, HttpSession session) {
        boolean isCorrect = gameService.checkGuess(number);
        Integer attempts = (Integer) session.getAttribute("attempts");
        if (attempts == null) {
            attempts = 0;
        }
        attempts++;
        session.setAttribute("attempts", attempts);
        List<Integer> numberOptions = (List<Integer>) session.getAttribute("numberOptions");
        if (numberOptions == null) {
            numberOptions = gameService.getNumberOptions();
            session.setAttribute("numberOptions", numberOptions);
        }
        model.addAttribute("numberOptions", numberOptions);

        if (isCorrect) {
            model.addAttribute("result", "Поздравляем, вы угадали число " + gameService.getTargetNumber() + " с " + attempts + " попыток!");
            gameService.resetGame();
            session.setAttribute("attempts", 0);
            session.removeAttribute("numberOptions");
        } else {
            // Если число угадано неправильно
            model.addAttribute("result", "Неправильный ответ, попробуйте еще раз.");
        }
        model.addAttribute("attempts", attempts);
        return "result";
    }

    @GetMapping("/reset")
    public String resetGame(HttpSession session) {
        gameService.resetGame(); // Сброс игры
        session.setAttribute("attempts", 0);
        session.removeAttribute("numberOptions");
        return "redirect:/";
    }

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        Integer attempts = (Integer) session.getAttribute("attempts");
        if (attempts == null) {
            attempts = 0;
        }

        List<Integer> numberOptions = (List<Integer>) session.getAttribute("numberOptions");
        if (numberOptions == null) {
            numberOptions = gameService.getNumberOptions();
            session.setAttribute("numberOptions", numberOptions);
        }
        model.addAttribute("numberOptions", numberOptions);
        model.addAttribute("attempts", attempts);

        return "index";
    }
}