package com.jitterted.ebp.blackjack.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameOutcomeTest {

  @Test
  public void playerBeatsDealer() throws Exception {
    Deck deck = new StubDeck(List.of(new Card(Suit.HEARTS, Rank.QUEEN),
                                     new Card(Suit.CLUBS, Rank.THREE),
                                     new Card(Suit.HEARTS, Rank.TEN),
                                     new Card(Suit.DIAMONDS, Rank.FOUR),
                                     new Card(Suit.DIAMONDS, Rank.KING),
                                     new Card(Suit.DIAMONDS, Rank.QUEEN)
    ));
    Game game = new Game(deck);

    game.initialDeal();
    game.playerStands();

    assertThat(game.determineOutcome())
        .startsWith("You beat the Dealer");
  }

  @Test
  public void playerWinsBlackjack() throws Exception {
    Deck deck = new StubDeck(List.of(new Card(Suit.HEARTS, Rank.QUEEN),
                                     new Card(Suit.CLUBS, Rank.THREE),
                                     new Card(Suit.HEARTS, Rank.ACE),
                                     new Card(Suit.DIAMONDS, Rank.FOUR),
                                     new Card(Suit.DIAMONDS, Rank.KING),
                                     new Card(Suit.DIAMONDS, Rank.QUEEN)
                                     ));
    Game game = new Game(deck);

    game.initialDeal();
    game.playerStands();

    assertThat(game.determineOutcome())
        .startsWith("You win Blackjack!");

  }


}


