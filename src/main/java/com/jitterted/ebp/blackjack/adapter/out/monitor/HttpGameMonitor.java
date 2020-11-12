package com.jitterted.ebp.blackjack.adapter.out.monitor;

import com.jitterted.ebp.blackjack.domain.Game;
import com.jitterted.ebp.blackjack.domain.GameMonitor;
import org.springframework.web.client.RestTemplate;

public class HttpGameMonitor implements GameMonitor {
  private static final String MONITOR_SERVICE_API_URL = "https://blackjack-game-monitor.herokuapp.com/api/gameresults";

  @Override
  public void roundCompleted(Game game) {
    GameResultDto dto = GameResultDto.from(game);
    try {
      post(MONITOR_SERVICE_API_URL, dto);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void post(String uri, GameResultDto gameResultDto) throws Exception {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.postForObject(uri, gameResultDto, GameResultDto.class);
  }

}
