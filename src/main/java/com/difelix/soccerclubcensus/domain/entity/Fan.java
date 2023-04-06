package com.difelix.soccerclubcensus.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "fan")
public class Fan {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private BigInteger id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "cpf", nullable = false, unique = true, length = 11)
  private String cpf;

  @Column(name = "nickname", nullable = false, unique = true)
  private String nickname;

  @Builder.Default
  @Column(name = "created_at", nullable = false)
  private Timestamp createdAt = Timestamp.from(Instant.now());

  @Column(name = "updated_at")
  private Timestamp updatedAt;

  @OneToOne
  @JoinColumn(name = "soccer_team_id", referencedColumnName = "id")
  private SoccerTeam soccerTeam;
}
