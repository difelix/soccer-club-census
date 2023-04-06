package com.difelix.soccerclubcensus.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class FanResponse {
  private BigInteger id;
  private String name;
  private String cpf;
  private String nickname;
  private String createdAt;
  private String updatedAt;
  private String soccerTeamName;
}
