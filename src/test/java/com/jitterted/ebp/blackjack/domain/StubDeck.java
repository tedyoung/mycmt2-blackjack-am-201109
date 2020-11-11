package com.jitterted.ebp.blackjack.domain;

import java.util.Iterator;
import java.util.List;

public class StubDeck extends Deck {
  private final Iterator<Card> cardIterator;

  public StubDeck(List<Card> cards) {
    this.cardIterator = cards.listIterator();
  }

  public Card draw() {
    return cardIterator.next();
  }
}
