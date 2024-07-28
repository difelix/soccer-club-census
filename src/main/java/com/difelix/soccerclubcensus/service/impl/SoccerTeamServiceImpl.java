package com.difelix.soccerclubcensus.service.impl;

import com.difelix.soccerclubcensus.domain.dto.request.SoccerTeamRequest;
import com.difelix.soccerclubcensus.domain.dto.response.SoccerTeamResponse;
import com.difelix.soccerclubcensus.domain.entity.SoccerTeam;
import com.difelix.soccerclubcensus.exceptions.BusinessException;
import com.difelix.soccerclubcensus.exceptions.enums.ErrorCode;
import com.difelix.soccerclubcensus.mappers.SoccerTeamMapper;
import com.difelix.soccerclubcensus.repository.SoccerTeamRepository;
import com.difelix.soccerclubcensus.service.SoccerTeamService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SoccerTeamServiceImpl implements SoccerTeamService {

  private final SoccerTeamRepository soccerTeamRepository;

  @Override
  public SoccerTeam findByName(String name) {
    Optional<SoccerTeam> soccerTeam = soccerTeamRepository.findByName(name);

    if (soccerTeam.isEmpty()) throw new BusinessException(
        "Time de futebol informado não existe, tente novamente!",
        ErrorCode.SOCCER_TEAM_NOT_FOUND
    );

    return soccerTeam.get();
  }

  @Override
  public List<SoccerTeamResponse> save(List<SoccerTeamRequest> soccerTeamRequest) {
    List<SoccerTeam> soccerTeamList = SoccerTeamMapper.toEntityList(soccerTeamRequest);
    soccerTeamRepository.insertSoccerTeamsWithBatchInsert(soccerTeamList);
    return SoccerTeamMapper.toResponseList(soccerTeamList);
  }
}
