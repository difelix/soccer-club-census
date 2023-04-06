package com.difelix.soccerclubcensus.service;

import com.difelix.soccerclubcensus.domain.entity.Fan;

public interface FanService {

  Fan create(Fan fan, String soccerTeamName);
}
