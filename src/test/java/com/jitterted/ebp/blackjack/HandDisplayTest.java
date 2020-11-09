package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandDisplayTest {
  @Test
  public void displayFirstCard() throws Exception {
    Hand hand = new Hand(List.of(
        new Card(Suit.HEARTS, Rank.ACE),
        new Card(Suit.CLUBS, Rank.EIGHT)));

    assertThat(ConsoleCard.displayFirstCard(hand))
        .isEqualTo("\u001B[31m┌─────────┐\u001B[1B\u001B[11D│A        │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│    ♥    │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│        A│\u001B[1B\u001B[11D└─────────┘");
  }

  @Test
  public void displayHand() throws Exception {
    Hand hand = new Hand(List.of(
        new Card(Suit.SPADES, Rank.QUEEN),
        new Card(Suit.DIAMONDS, Rank.NINE)));

    assertThat(ConsoleCard.cardsAsString(hand))
        .isEqualTo("\u001B[30m┌─────────┐\u001B[1B\u001B[11D│Q        │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│    ♠    │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│        Q│\u001B[1B\u001B[11D└─────────┘\u001B[6A\u001B[1C\u001B[31m┌─────────┐\u001B[1B\u001B[11D│9        │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│    ♦    │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│        9│\u001B[1B\u001B[11D└─────────┘");

  }
}
