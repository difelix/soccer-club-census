package com.difelix.soccerclubcensus.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.difelix.soccerclubcensus.domain.entity.Fan;
import com.difelix.soccerclubcensus.domain.entity.SoccerTeam;
import com.difelix.soccerclubcensus.domain.enums.StateEnum;
import com.difelix.soccerclubcensus.exceptions.BusinessException;
import com.difelix.soccerclubcensus.exceptions.enums.ErrorCode;
import com.difelix.soccerclubcensus.repository.FanRepository;
import java.math.BigInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FanServiceImplTest {

  @Mock
  private FanRepository fanRepository;

  @InjectMocks
  private FanServiceImpl fanService;

  @Test
  @DisplayName("should save fan with success")
  void test1() {
    final Fan fan = buildFanObject();

    when(fanRepository.existsByCpf(fan.getCpf())).thenReturn(false);
    when(fanRepository.save(fan)).thenReturn(fan);

    final Fan fanSaved = fanService.create(fan);

    assertNotNull(fanSaved);
  }

  @Test
  @DisplayName("should throws exception when cpf already exists")
  void test2() {
    final Fan fan = buildFanObject();

    when(fanRepository.existsByCpf(fan.getCpf())).thenReturn(true);

    BusinessException businessException = assertThrows(
        BusinessException.class,
        () -> fanService.create(fan)
    );

    assertEquals(ErrorCode.INVALID_CPF, businessException.getErrorCode());
    assertEquals("Já existe usuário cadastrado com CPF informado.", businessException.getMessage());

    verify(fanRepository, never()).save(any());
  }

  private Fan buildFanObject() {
    final SoccerTeam soccerTeam = SoccerTeam.builder()
        .id(BigInteger.ONE)
        .name("Sao Paulo Futebol Clube")
        .state(StateEnum.SP)
        .build();

    return Fan.builder()
        .id(BigInteger.ONE)
        .cpf("22836527820")
        .name("Diego Silva")
        .nickname("difelix")
        .soccerTeam(soccerTeam)
        .build();
  }

}
