package com.difelix.soccerclubcensus.service.impl;

import com.difelix.soccerclubcensus.domain.entity.Fan;
import com.difelix.soccerclubcensus.domain.entity.SoccerTeam;
import com.difelix.soccerclubcensus.exceptions.BusinessException;
import com.difelix.soccerclubcensus.exceptions.enums.ErrorCode;
import com.difelix.soccerclubcensus.repository.FanRepository;
import com.difelix.soccerclubcensus.service.FanService;
import com.difelix.soccerclubcensus.service.SoccerTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FanServiceImpl implements FanService {

  private final FanRepository fanRepository;
  private final SoccerTeamService soccerTeamService;

  @Transactional
  @Override
  public Fan create(Fan fan, String soccerTeamName) {
    final boolean existsCpf = fanRepository.existsByCpf(fan.getCpf());
    if (existsCpf)
      throw new BusinessException(
          "Já existe usuário cadastrado com CPF informado.",
          ErrorCode.INVALID_CPF
      );

    final SoccerTeam soccerTeam = soccerTeamService.findByName(soccerTeamName);
    fan.setSoccerTeam(soccerTeam);

    return fanRepository.save(fan);
  }
}
