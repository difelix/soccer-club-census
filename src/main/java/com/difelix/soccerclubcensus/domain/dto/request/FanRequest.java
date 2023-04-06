package com.difelix.soccerclubcensus.domain.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FanRequest {

  @NotBlank
  private String name;

  @NotBlank
  @CPF
  private String cpf;

  @NotBlank
  private String nickname;

  @NotBlank
  private String soccerTeamName;
}
