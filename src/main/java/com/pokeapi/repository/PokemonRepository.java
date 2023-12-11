package com.pokeapi.repository;

import com.pokeapi.entity.PokemonEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PokemonRepository extends ListCrudRepository <PokemonEntity,Integer>{
}
