package com.pokeapi.repository;

import com.pokeapi.entity.PokemonEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends ListCrudRepository <PokemonEntity, Integer>{
}
