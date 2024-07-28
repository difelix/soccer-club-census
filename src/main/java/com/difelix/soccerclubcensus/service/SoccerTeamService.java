package com.difelix.soccerclubcensus.service;

import com.difelix.soccerclubcensus.domain.dto.request.SoccerTeamRequest;
import com.difelix.soccerclubcensus.domain.dto.response.SoccerTeamResponse;
import com.difelix.soccerclubcensus.domain.entity.SoccerTeam;
import java.util.List;

public interface SoccerTeamService {

  SoccerTeam findByName(String name);

  List<SoccerTeamResponse> save(List<SoccerTeamRequest> soccerTeamRequest);
}
