package com.pokeapi.persistence;

import com.pokeapi.entity.BattlePlayerEntity;


import java.util.List;
import java.util.Optional;

public interface IBattlePlayerDAO {

    List<BattlePlayerEntity> findAll();

    Optional<BattlePlayerEntity> findById(Integer id);
}
