package com.difelix.soccerclubcensus.domain.entity;

import com.difelix.soccerclubcensus.domain.enums.StateEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigInteger;
import java.sql.Timestamp;
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
@Entity
@Table(name = "soccer_team")
public class SoccerTeam {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private BigInteger id;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Column(name = "foundation_date", nullable = false)
  private Timestamp foundationDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "state", nullable = false, length = 2)
  private StateEnum state;

  @Column(name = "fans_amount", nullable = false)
  private BigInteger fansAmount;

  @Column(name = "last_update", nullable = false)
  private Timestamp lastUpdate;
}
