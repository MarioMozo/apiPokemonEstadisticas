package com.pokeapi.service;

import com.pokeapi.entity.OponentEntity;

import java.util.List;
import java.util.Optional;

public interface IOponentService {

    List<OponentEntity> findAll();
    Optional<OponentEntity> findById(Integer id);
    void save(OponentEntity oponent);
    void deleteById(Integer id);
}
