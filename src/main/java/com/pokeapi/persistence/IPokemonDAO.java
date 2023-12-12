package com.pokeapi.persistence;

import com.pokeapi.entity.PokemonEntity;

import java.util.List;
import java.util.Optional;

public interface IPokemonDAO {
    List<PokemonEntity> findAll();

    Optional<PokemonEntity> findById(Integer id);

    void save(PokemonEntity pokemon);

    void deleteById(Integer id);
}
