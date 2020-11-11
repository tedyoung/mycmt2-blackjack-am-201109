package com.jitterted.ebp.blackjack.domain;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameOutcomeTest {

  @Test
  public void playerBeatsDealer() throws Exception {
    Deck deck = new StubDeck(List.of(new Card(Suit.HEARTS, Rank.QUEEN),
                                     new Card(Suit.CLUBS, Rank.TWO),
                                     new Card(Suit.HEARTS, Rank.TEN),
                                     new Card(Suit.DIAMONDS, Rank.FOUR)));
    Game game = new Game(deck);

    game.initialDeal();
    game.playerStands();

    assertThat(game.determineOutcome())
        .startsWith("You beat the Dealer");
  }

  @Test
  public void playerWinsBlackjack() throws Exception {
    Deck deck = new StubDeck(List.of(new Card(Suit.HEARTS, Rank.QUEEN),
                                     new Card(Suit.CLUBS, Rank.TWO),
                                     new Card(Suit.HEARTS, Rank.ACE),
                                     new Card(Suit.DIAMONDS, Rank.FOUR)));
    Game game = new Game(deck);

    game.initialDeal();
    game.playerStands();

    assertThat(game.determineOutcome())
        .startsWith("You win Blackjack!");

  }




  static class StubDeck extends Deck {
    private final Iterator<Card> cardIterator;

    public StubDeck(List<Card> cards) {
      this.cardIterator = cards.listIterator();
    }

    public Card draw() {
      return cardIterator.next();
    }
  }

}

