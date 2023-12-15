package com.pokeapi.service;

import com.pokeapi.entity.JugadorEntity;

import java.util.List;
import java.util.Optional;


public interface IJugadorService{
    List<JugadorEntity> findAll();

    Optional<JugadorEntity> findById(Integer id);

    void save(JugadorEntity jugador);

    void deleteById(Integer id);
}
