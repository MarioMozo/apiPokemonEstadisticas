package com.pokeapi.repository;

import com.pokeapi.entity.BattlePokemonEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattlePokemonRepository extends ListCrudRepository<BattlePokemonEntity, Integer> {
}
