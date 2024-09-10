package com.game.guess_the_number.Controller;

import com.game.guess_the_number.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/guess")
    public String makeGuess(@RequestParam int number, Model model) {
        String result = gameService.guess(number);
        model.addAttribute("result", result);
        return "result";
    }

    @GetMapping("/reset")
    public String resetGame() {
        gameService.resetGame();
        return "redirect:/";
    }
}
