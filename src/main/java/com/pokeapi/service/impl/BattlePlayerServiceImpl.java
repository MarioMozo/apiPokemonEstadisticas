package com.pokeapi.service.impl;

import com.pokeapi.entity.BattlePlayerEntity;
import com.pokeapi.persistence.IBattlePlayerDAO;
import com.pokeapi.persistence.IBattlePokemonDAO;
import com.pokeapi.service.IBattlePlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BattlePlayerServiceImpl implements IBattlePlayerService {

    @Autowired
    private IBattlePlayerDAO battlePlayerDAO;

    @Override
    public List<BattlePlayerEntity> findAll() {return battlePlayerDAO.findAll(); }

    @Override
    public Optional<BattlePlayerEntity> findById(Integer id) {return battlePlayerDAO.findById(id);}
}
