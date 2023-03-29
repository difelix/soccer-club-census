package com.difelix.soccerclubcensus.repository;

import com.difelix.soccerclubcensus.domain.entity.Fan;
import java.math.BigInteger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FanRepository extends CrudRepository<Fan, BigInteger> {

  boolean existsByCpf(String cpf);

}
