package com.pokeapi.persistence.impl;

import com.pokeapi.entity.BattlePokemonEntity;
import com.pokeapi.entity.JugadorEntity;
import com.pokeapi.persistence.IBattlePokemonDAO;
import com.pokeapi.repository.BattlePokemonRepository;
import com.pokeapi.service.impl.BattlePokemonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BattlePokemonDAOImpl implements IBattlePokemonDAO {

    @Autowired
    private BattlePokemonRepository battlePokemonRepository;

    @Override
    public List<BattlePokemonEntity> findAll() {
        return (List<BattlePokemonEntity>) battlePokemonRepository.findAll();
    }

    @Override
    public Optional<BattlePokemonEntity> findById(Integer id) {
        return battlePokemonRepository.findById(id);
    }
}
