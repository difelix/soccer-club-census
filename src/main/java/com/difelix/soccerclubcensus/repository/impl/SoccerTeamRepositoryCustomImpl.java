package com.difelix.soccerclubcensus.repository.impl;

import com.difelix.soccerclubcensus.domain.entity.SoccerTeam;
import com.difelix.soccerclubcensus.repository.SoccerTeamRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.util.List;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

public class SoccerTeamRepositoryCustomImpl implements SoccerTeamRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  @Transactional
  public void insertSoccerTeams(List<SoccerTeam> soccerTeamList) {
    for(SoccerTeam soccerTeam : soccerTeamList) {
      Query query = entityManager.createNativeQuery(
          "INSERT INTO soccer_team(name, foundation_date, state, fans_amount) "
              + "VALUES(:name, :foundationDate, :state, :fansAmount)"
      );
      query.setParameter("name", soccerTeam.getName());
      query.setParameter("foundationDate", soccerTeam.getFoundationDate());
      query.setParameter("state", soccerTeam.getState());
      query.setParameter("fansAmount", soccerTeam.getFansAmount());

      query.executeUpdate();
    }
  }

  @Override
  public void insertSoccerTeamsWithBatchInsert(List<SoccerTeam> soccerTeamList) {
    entityManager.unwrap(Session.class)
        .doWork(connection -> {
          try (PreparedStatement ps = connection.prepareStatement("INSERT INTO soccer_team (name, foundation_date, state, fans_amount) VALUES (?, ?, ?, ?)")) {
            for (SoccerTeam soccerTeam : soccerTeamList) {
              ps.setString(1, soccerTeam.getName());
              ps.setString(2, soccerTeam.getFoundationDate());
              ps.setString(3, soccerTeam.getState());
              ps.setBigDecimal(4, new BigDecimal(soccerTeam.getFansAmount()));
              ps.addBatch();
            }
            ps.executeBatch();
          }
        });
  }
}
