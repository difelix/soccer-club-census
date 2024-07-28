package com.difelix.soccerclubcensus.domain.dto.response;

import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SoccerTeamResponse {
  private BigInteger id;
  private String name;
  private String foundationDate;
  private String state;
  private BigInteger fansAmount;
  private String lastUpdate;
}
