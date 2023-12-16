package com.pokeapi.service;

import com.pokeapi.entity.BattlePlayerEntity;

import java.util.List;
import java.util.Optional;

public interface IBattlePlayerService {

    List<BattlePlayerEntity> findAll();

    Optional<BattlePlayerEntity> findById(Integer id);
}
