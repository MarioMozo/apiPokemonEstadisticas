package com.pokeapi.repository;

import com.pokeapi.entity.BattleEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface BattleRepository extends ListCrudRepository<BattleEntity, Integer> {
}
