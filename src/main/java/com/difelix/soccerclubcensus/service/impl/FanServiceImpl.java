package com.difelix.soccerclubcensus.service.impl;

import com.difelix.soccerclubcensus.domain.entity.Fan;
import com.difelix.soccerclubcensus.exceptions.BusinessException;
import com.difelix.soccerclubcensus.exceptions.enums.ErrorCode;
import com.difelix.soccerclubcensus.repository.FanRepository;
import com.difelix.soccerclubcensus.service.FanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FanServiceImpl implements FanService {

  private final FanRepository fanRepository;

  @Override
  public Fan create(Fan fan) {
    final boolean existsCpf = fanRepository.existsByCpf(fan.getCpf());

    if (existsCpf)
      throw new BusinessException("Já existe usuário cadastrado com CPF informado.", ErrorCode.INVALID_CPF);

    return fanRepository.save(fan);
  }
}
