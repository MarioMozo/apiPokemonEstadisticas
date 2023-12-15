package com.pokeapi.service;

import com.pokeapi.entity.BattlePokemonEntity;
import com.pokeapi.entity.JugadorEntity;

import java.util.List;
import java.util.Optional;

public interface IBattlePokemonService {

    List<BattlePokemonEntity> findAll();

    Optional<BattlePokemonEntity> findById(Integer id);
}
