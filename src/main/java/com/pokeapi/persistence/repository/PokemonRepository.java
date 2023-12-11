package com.pokeapi.persistence.repository;

import com.pokeapi.persistence.entity.PokemonEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PokemonRepository extends ListCrudRepository <PokemonEntity,Integer>{
}
