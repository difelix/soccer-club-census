package com.difelix.soccerclubcensus.repository;

import com.difelix.soccerclubcensus.domain.entity.SoccerTeam;
import java.util.List;

public interface SoccerTeamRepositoryCustom {
  void insertSoccerTeams(List<SoccerTeam> soccerTeamList);
  void insertSoccerTeamsWithBatchInsert(List<SoccerTeam> soccerTeamList);
}
