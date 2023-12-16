package com.pokeapi.persistence;

import com.pokeapi.entity.BattleEntity;
import com.pokeapi.entity.BattlePokemonEntity;

import java.util.List;
import java.util.Optional;

public interface IBattleDAO {

    List<BattleEntity> findAll();

    Optional<BattleEntity> findById(Integer id);

}
