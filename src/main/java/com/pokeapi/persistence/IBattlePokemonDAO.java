package com.pokeapi.persistence;

import com.pokeapi.entity.BattlePokemonEntity;
import com.pokeapi.entity.JugadorEntity;

import java.util.List;
import java.util.Optional;

public interface IBattlePokemonDAO {


    List<BattlePokemonEntity> findAll();

    Optional<BattlePokemonEntity> findById(Integer id);
}
