package com.pokeapi.service.impl;

import com.pokeapi.entity.PokemonUserEntity;
import com.pokeapi.persistence.IPokemonUserDAO;
import com.pokeapi.service.IPokemonUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonUserServiceImpl implements IPokemonUserService {

    @Autowired
    private IPokemonUserDAO pokemonUserDAO;
    @Override
    public List<PokemonUserEntity> findAll()
        {return pokemonUserDAO.findAll();}


    @Override
    public Optional<PokemonUserEntity> findById(Integer id) {
        return pokemonUserDAO.findById(id);
    }

    @Override
    public void save(PokemonUserEntity pokemonUserEntity) {
        pokemonUserDAO.save(pokemonUserEntity);
    }

    @Override
    public void deleteById(Integer id) {
        pokemonUserDAO.deleById(id);
    }
}
