package com.pokeapi.persistence.impl;
import com.pokeapi.entity.BattlePokemonEntity;
import com.pokeapi.entity.PlayerEntity;
import com.pokeapi.persistence.IPlayerDAO;
import com.pokeapi.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PlayerDAOImpl implements IPlayerDAO {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<PlayerEntity> findAll() {return (List<PlayerEntity>) playerRepository.findAll(); }

    @Override
    public Optional<PlayerEntity> findById(Integer id) { return playerRepository.findById(id); }
}
