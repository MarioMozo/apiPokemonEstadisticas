package com.pokeapi.service.impl;

import com.pokeapi.entity.BattlePokemonEntity;
import com.pokeapi.entity.JugadorEntity;
import com.pokeapi.persistence.IBattlePokemonDAO;
import com.pokeapi.service.IBattlePokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BattlePokemonServiceImpl implements IBattlePokemonService {

    @Autowired
    private IBattlePokemonDAO battlePokemonDAO;

    @Override
    public List<BattlePokemonEntity> findAll() { return battlePokemonDAO.findAll();    }

    @Override
    public Optional<BattlePokemonEntity> findById(Integer id) {
        return Optional.empty();
    }
}
