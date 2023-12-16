package com.pokeapi.service;

import com.pokeapi.entity.PlayerEntity;
import com.pokeapi.entity.JugadorEntity;

import java.util.List;
import java.util.Optional;

public interface IPlayerService {

    List<PlayerEntity> findAll();

    Optional<PlayerEntity> findById(Integer id);
}
