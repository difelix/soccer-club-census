package com.difelix.soccerclubcensus.mappers;

import com.difelix.soccerclubcensus.domain.dto.request.SoccerTeamRequest;
import com.difelix.soccerclubcensus.domain.dto.response.SoccerTeamResponse;
import com.difelix.soccerclubcensus.domain.entity.SoccerTeam;
import java.util.List;

public class SoccerTeamMapper {

  public static SoccerTeam toEntity(SoccerTeamRequest soccerTeamRequest) {
    return SoccerTeam.builder()
        .state(soccerTeamRequest.getState())
        .foundationDate(soccerTeamRequest.getFoundationDate())
        .fansAmount(soccerTeamRequest.getFansAmount())
        .name(soccerTeamRequest.getName())
        .build();
  }

  public static List<SoccerTeam> toEntityList(List<SoccerTeamRequest> soccerTeamRequestList) {
    return soccerTeamRequestList.stream().map(SoccerTeamMapper::toEntity).toList();
  }

  public static SoccerTeamResponse toResponse(SoccerTeam soccerTeam) {
    return SoccerTeamResponse.builder()
        .id(soccerTeam.getId())
        .fansAmount(soccerTeam.getFansAmount())
        .foundationDate(soccerTeam.getFoundationDate())
        .lastUpdate(soccerTeam.getLastUpdate())
        .name(soccerTeam.getName())
        .build();
  }

  public static List<SoccerTeamResponse> toResponseList(List<SoccerTeam> soccerTeamList) {
    return soccerTeamList.stream().map(SoccerTeamMapper::toResponse).toList();
  }
}
