package com.difelix.soccerclubcensus.controller;

import com.difelix.soccerclubcensus.domain.dto.request.SoccerTeamRequest;
import com.difelix.soccerclubcensus.domain.dto.response.SoccerTeamResponse;
import com.difelix.soccerclubcensus.service.SoccerTeamService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class SoccerTeamController {

  private final SoccerTeamService soccerTeamService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public List<SoccerTeamResponse> save(@RequestBody List<SoccerTeamRequest> soccerTeamRequestList) {
    return soccerTeamService.save(soccerTeamRequestList);
  }
}
