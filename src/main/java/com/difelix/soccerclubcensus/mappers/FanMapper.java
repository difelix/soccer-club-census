package com.difelix.soccerclubcensus.mappers;

import com.difelix.soccerclubcensus.domain.dto.request.FanRequest;
import com.difelix.soccerclubcensus.domain.dto.response.FanResponse;
import com.difelix.soccerclubcensus.domain.entity.Fan;
import org.springframework.stereotype.Component;

@Component
public class FanMapper {

  public static Fan toEntity(FanRequest fanRequest) {
    return Fan.builder()
        .name(fanRequest.getName())
        .cpf(fanRequest.getCpf())
        .nickname(fanRequest.getNickname())
        .build();
  }

  public static FanResponse toResponse(Fan fan) {
    return FanResponse.builder()
        .id(fan.getId())
        .cpf(fan.getCpf())
        .nickname(fan.getNickname())
        .name(fan.getName())
        .createdAt(fan.getCreatedAt().toString())
        .updatedAt( (fan.getUpdatedAt() != null) ? fan.getUpdatedAt().toString() : null)
        .soccerTeamName(fan.getSoccerTeam().getName())
        .build();
  }
}
