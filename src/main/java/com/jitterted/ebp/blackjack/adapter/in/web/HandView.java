package com.jitterted.ebp.blackjack.adapter.in.web;

import com.jitterted.ebp.blackjack.domain.Card;
import com.jitterted.ebp.blackjack.domain.Game;

import java.util.ArrayList;
import java.util.List;

public class HandView {
  private List<String> dealerCards = new ArrayList<>();
  private List<String> playerCards = new ArrayList<>();

  public HandView(Game game) {
    for (Card card : game.dealerHand().cards()) {
      String cardView = card.rank().display() + card.suit().symbol();
      dealerCards.add(cardView);
    }

    for (Card card : game.playerHand().cards()) {
      String cardView = card.rank().display() + card.suit().symbol();
      playerCards.add(cardView);
    }
  }

  public List<String> getDealerCards() {
    return dealerCards;
  }

  public void setDealerCards(List<String> dealerCards) {
    this.dealerCards = dealerCards;
  }

  public List<String> getPlayerCards() {
    return playerCards;
  }

  public void setPlayerCards(List<String> playerCards) {
    this.playerCards = playerCards;
  }
}
