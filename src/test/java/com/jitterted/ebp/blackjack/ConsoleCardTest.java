package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.fusesource.jansi.Ansi.ansi;

public class ConsoleCardTest {

  private static final Rank DUMMY_RANK = Rank.TEN;
  private static final Suit DUMMY_SUIT = Suit.CLUBS;

  @Test
  public void displayTenAsString() throws Exception {
    Card card = new Card(DUMMY_SUIT, Rank.TEN);

    assertThat(ConsoleCard.display(card))
        .isEqualTo("\u001B[30m┌─────────┐\u001B[1B\u001B[11D│10       │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│    ♣    │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│       10│\u001B[1B\u001B[11D└─────────┘");
  }

  @Test
  public void displayNonTenAsString() throws Exception {
    Card card = new Card(DUMMY_SUIT, Rank.FIVE);

    assertThat(ConsoleCard.display(card))
        .isEqualTo("\u001B[30m┌─────────┐\u001B[1B\u001B[11D│5        │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│    ♣    │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│        5│\u001B[1B\u001B[11D└─────────┘");
  }

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


  @Test
  public void suitOfHeartsOrDiamondsIsDisplayedInRed() throws Exception {
    // given a card with Hearts or Diamonds
    Card heartsCard = new Card(Suit.HEARTS, DUMMY_RANK);
    Card diamondsCard = new Card(Suit.DIAMONDS, DUMMY_RANK);

    // when we ask for its display representation
    String ansiRedString = ansi().fgRed().toString();

    // then we expect a red color ansi sequence
    assertThat(ConsoleCard.display(heartsCard))
        .contains(ansiRedString);
    assertThat(ConsoleCard.display(diamondsCard))
        .contains(ansiRedString);
  }

}
