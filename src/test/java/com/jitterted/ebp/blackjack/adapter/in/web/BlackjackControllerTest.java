package com.jitterted.ebp.blackjack.adapter.in.web;

import com.jitterted.ebp.blackjack.domain.Card;
import com.jitterted.ebp.blackjack.domain.Deck;
import com.jitterted.ebp.blackjack.domain.Game;
import com.jitterted.ebp.blackjack.domain.Rank;
import com.jitterted.ebp.blackjack.domain.StubDeck;
import com.jitterted.ebp.blackjack.domain.Suit;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BlackjackControllerTest {

  @Test
  public void whenGameStartsDealtCardsAreInHands() throws Exception {
    Deck stubDeck = new StubDeck(List.of(new Card(Suit.HEARTS, Rank.QUEEN),
                                         new Card(Suit.CLUBS, Rank.TWO),
                                         new Card(Suit.HEARTS, Rank.ACE),
                                         new Card(Suit.DIAMONDS, Rank.FOUR)));
    Game game = new Game(stubDeck);
    BlackjackController blackjackController = new BlackjackController(game);
    blackjackController.initializeGame();

    Model model = new ConcurrentModel();
    blackjackController.getStartGame(model);

    HandView handView = (HandView) model.getAttribute("hands");
    assertThat(handView.getDealerCards())
        .containsExactly("2♣", "4♦");
    assertThat(handView.getPlayerCards())
        .containsExactly("Q♥", "A♥");
  }

  @Test
  public void postToStartGameDealsCards() throws Exception {
    Game game = new Game();
    BlackjackController blackjackController = new BlackjackController(game);

    blackjackController.initializeGame();

    assertThat(game.dealerHand().cards())
        .hasSize(2);
    assertThat(game.playerHand().cards())
        .hasSize(2);
  }

}