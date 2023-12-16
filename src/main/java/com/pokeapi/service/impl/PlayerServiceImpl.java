package com.pokeapi.service.impl;

import com.pokeapi.entity.PlayerEntity;
import com.pokeapi.persistence.IPlayerDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PlayerServiceImpl implements IPlayerDAO {

    @Autowired
    private IPlayerDAO playerDAO;

    @Override
    public List<PlayerEntity> findAll() { return playerDAO.findAll(); }

    @Override
    public Optional<PlayerEntity> findById(Integer id) { return Optional.empty(); }
}