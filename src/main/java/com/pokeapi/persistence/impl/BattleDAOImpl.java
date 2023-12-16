package com.pokeapi.persistence.impl;

import com.pokeapi.entity.BattleEntity;
import com.pokeapi.entity.BattlePokemonEntity;
import com.pokeapi.persistence.IBattleDAO;
import com.pokeapi.repository.BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BattleDAOImpl implements IBattleDAO {
    @Autowired
    BattleRepository battleRepository;

    @Override
    public List<BattleEntity> findAll() {
        return (List<BattleEntity>) battleRepository.findAll();
    }

    @Override
    public Optional<BattleEntity> findById(Integer id) {
        return Optional.empty();
    }
}
