package com.difelix.soccerclubcensus.service;

import com.difelix.soccerclubcensus.domain.entity.SoccerTeam;

public interface SoccerTeamService {

  SoccerTeam findByName(String name);
}
