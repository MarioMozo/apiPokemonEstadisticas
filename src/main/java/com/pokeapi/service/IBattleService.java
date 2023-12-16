package com.pokeapi.service;

import com.pokeapi.entity.BattleEntity;
import com.pokeapi.entity.BattlePokemonEntity;

import java.util.List;
import java.util.Optional;

public interface IBattleService {
    List<BattleEntity> findAll();

    Optional<BattleEntity> findById(Integer id);
}
