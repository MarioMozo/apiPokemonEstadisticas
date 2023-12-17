package com.pokeapi.repository;

import com.pokeapi.entity.PokemonUserEntity;
import com.pokeapi.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PokemonUserRespository extends ListCrudRepository<PokemonUserEntity, Integer> {

}
