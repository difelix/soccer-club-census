package com.difelix.soccerclubcensus.controller;

import com.difelix.soccerclubcensus.domain.dto.request.FanRequest;
import com.difelix.soccerclubcensus.domain.dto.response.FanResponse;
import com.difelix.soccerclubcensus.domain.entity.Fan;
import com.difelix.soccerclubcensus.mappers.FanMapper;
import com.difelix.soccerclubcensus.service.FanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fan")
@RequiredArgsConstructor
public class FanController {

  private final FanService fanService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public FanResponse create(@RequestBody FanRequest fanRequest) {
    final Fan fan = fanService.create(
        FanMapper.toEntity(fanRequest), fanRequest.getSoccerTeamName()
    );
    return FanMapper.toResponse(fan);
  }
}
