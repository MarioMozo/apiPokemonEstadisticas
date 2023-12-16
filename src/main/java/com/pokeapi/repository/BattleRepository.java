package com.pokeapi.repository;

import com.pokeapi.entity.BattleEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleRepository extends ListCrudRepository<BattleEntity, Integer> {
}
