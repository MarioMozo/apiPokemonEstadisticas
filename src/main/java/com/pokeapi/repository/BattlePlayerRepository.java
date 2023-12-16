package com.pokeapi.repository;

import com.pokeapi.entity.BattlePlayerEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattlePlayerRepository extends ListCrudRepository<BattlePlayerEntity,Integer> {
}
