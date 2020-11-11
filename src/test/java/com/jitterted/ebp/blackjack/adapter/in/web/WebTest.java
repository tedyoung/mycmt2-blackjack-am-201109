package com.jitterted.ebp.blackjack.adapter.in.web;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest
@Tag("spring")
public class WebTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getOfHomePageIsStatus200() throws Exception {
    mockMvc.perform(get("/index.html"))
           .andExpect(status().is2xxSuccessful()
           );
  }

  @Test
  public void startGamePageIs200() throws Exception {
    mockMvc.perform(get("/game"))
           .andExpect(status().is2xxSuccessful())
           .andExpect(view().name("blackjack"))
           .andExpect(model().attributeExists("hands"));
  }

  @Test
  public void postToStartGameRedirectsToStartGamePage() throws Exception {
    MvcResult mvcResult = mockMvc.perform(post("/start-game"))
                                 .andExpect(status().is3xxRedirection())
                                 .andExpect(redirectedUrl("/game"))
                                 .andReturn();

    String redirectedUrl = mvcResult.getResponse().getRedirectedUrl();
    mockMvc.perform(get(redirectedUrl))
           .andExpect(status().isOk());
  }

  @Test
  public void postForHitRedirectsBackToGamePage() throws Exception {
    MvcResult mvcResult = mockMvc.perform(post("/game"))
                                 .andExpect(status().is3xxRedirection())
                                 .andExpect(redirectedUrl("/game"))
                                 .andReturn();
  }

  @Test
  public void getForDonePageIs200() throws Exception {
    mockMvc.perform(get("/done"))
           .andExpect(status().is2xxSuccessful())
           .andExpect(view().name("done"))
           .andExpect(model().attributeExists("hands"))
           .andExpect(model().attributeExists("outcome"));
  }
}
