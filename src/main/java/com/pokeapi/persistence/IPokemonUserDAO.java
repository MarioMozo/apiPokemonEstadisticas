package com.pokeapi.persistence;

import com.pokeapi.entity.PokemonUserEntity;
import com.pokeapi.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IPokemonUserDAO {

    List<PokemonUserEntity> findAll();

    Optional<PokemonUserEntity> findById(Integer id);

    void save(PokemonUserEntity userEntity);

    void deleById(Integer id);
}
