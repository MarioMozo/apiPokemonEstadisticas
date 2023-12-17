package com.pokeapi.service;

import com.pokeapi.entity.PokemonUserEntity;
import com.pokeapi.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IPokemonUserService {


    List<PokemonUserEntity> findAll();

    Optional<PokemonUserEntity> findById(Integer id);

    void save(PokemonUserEntity pokemonUserEntity);

    void deleteById(Integer id);
}
