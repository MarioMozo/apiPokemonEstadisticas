package com.pokeapi.persistence.impl;

import com.pokeapi.entity.BattlePlayerEntity;
import com.pokeapi.persistence.IBattlePlayerDAO;
import com.pokeapi.repository.BattlePlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BattlePlayerDAOImpl implements IBattlePlayerDAO {

    @Autowired
    private BattlePlayerRepository battlePlayerRepository;

    @Override
    public List<BattlePlayerEntity> findAll() {return (List<BattlePlayerEntity>) battlePlayerRepository.findAll();}

    @Override
    public Optional<BattlePlayerEntity> findById(Integer id) {
        return battlePlayerRepository.findById(id);
    }
}
