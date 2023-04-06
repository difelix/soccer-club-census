package com.difelix.soccerclubcensus.repository;

import com.difelix.soccerclubcensus.domain.entity.SoccerTeam;
import java.math.BigInteger;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoccerTeamRepository extends CrudRepository<SoccerTeam, BigInteger> {

  Optional<SoccerTeam> findByName(String name);
}
