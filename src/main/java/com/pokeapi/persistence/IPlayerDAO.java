package com.pokeapi.persistence;
import com.pokeapi.entity.BattlePokemonEntity;
import com.pokeapi.entity.PlayerEntity;

import java.util.List;
import java.util.Optional;

public interface IPlayerDAO {

    List<PlayerEntity> findAll();

    Optional<PlayerEntity> findById(Integer id);
}
