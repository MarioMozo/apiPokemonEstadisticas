package com.pokeapi.service.impl;

import com.pokeapi.entity.BattleEntity;
import com.pokeapi.entity.BattlePokemonEntity;
import com.pokeapi.persistence.IBattleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BattleServiceImpl {
    @Autowired
    private IBattleDAO battleDAO;


    public List<BattleEntity> findAll() { return battleDAO.findAll();    }


    public Optional<BattleEntity> findById(Integer id) {
        return Optional.empty();
    }
}
