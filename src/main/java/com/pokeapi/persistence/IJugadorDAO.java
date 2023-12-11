package com.pokeapi.persistence;

import com.pokeapi.entity.JugadorEntity;

import java.util.List;
import java.util.Optional;

public interface IJugadorDAO {
    List<JugadorEntity> findAll();

    Optional<JugadorEntity> findById(Integer id);

    void save(JugadorEntity jugador);

    void deleteById(Integer id);

}
