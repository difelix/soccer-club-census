package com.difelix.soccerclubcensus.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.difelix.soccerclubcensus.domain.dto.request.FanRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class FanControllerTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  @Sql("/sql/add-soccer-team-and-clean-fan-table.sql")
  @DisplayName("should save fan with success")
  void test1() throws Exception {
    final FanRequest fanRequest = FanRequest.builder()
        .name("Diego Félix da Silva")
        .cpf("43386869874")
        .nickname("difelix")
        .soccerTeamName("Vasco da Gama")
        .build();

    mvc.perform(
        post("/fan")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(fanRequest)))
        .andDo(print())
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.name").value("Diego Félix da Silva"))
        .andExpect(jsonPath("$.soccerTeamName").value("Vasco da Gama"))
        .andReturn();
  }
}
