package com.jitterted.ebp.blackjack.adapter.out.monitor;

import com.jitterted.ebp.blackjack.domain.Game;

public class GameResultDto {
  private String playerName = "Ted";
  private String outcome;
  private int playerHandValue;
  private int dealerHandValue;

  public static GameResultDto from(Game game) {
    GameResultDto dto = new GameResultDto();
    dto.setOutcome(game.determineOutcome());
    dto.setDealerHandValue(Integer.parseInt(game.dealerHand().displayValue()));
    dto.setPlayerHandValue(Integer.parseInt(game.playerHand().displayValue()));
    return dto;
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public String getOutcome() {
    return outcome;
  }

  public void setOutcome(String outcome) {
    this.outcome = outcome;
  }

  public int getPlayerHandValue() {
    return playerHandValue;
  }

  public void setPlayerHandValue(int playerHandValue) {
    this.playerHandValue = playerHandValue;
  }

  public int getDealerHandValue() {
    return dealerHandValue;
  }

  public void setDealerHandValue(int dealerHandValue) {
    this.dealerHandValue = dealerHandValue;
  }
}
