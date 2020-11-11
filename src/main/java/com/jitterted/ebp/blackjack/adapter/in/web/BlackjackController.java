package com.jitterted.ebp.blackjack.adapter.in.web;

import com.jitterted.ebp.blackjack.domain.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlackjackController {

  private final Game game;

  public BlackjackController(Game game) {
    this.game = game;
  }

  @GetMapping("/start-game")
  public String getStartGame(Model model) {
    HandView handView = new HandView(game);

    model.addAttribute("hands", handView);
    return "blackjack";
  }

  @PostMapping("/start-game")
  public String initializeGame() {
    game.initialDeal();
    return "redirect:/start-game";
  }
}