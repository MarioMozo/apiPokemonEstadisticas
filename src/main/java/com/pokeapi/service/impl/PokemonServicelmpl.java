package com.pokeapi.service.impl;

import com.pokeapi.entity.PokemonEntity;
import com.pokeapi.persistence.IPokemonDAO;
import com.pokeapi.service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PokemonServicelmpl implements IPokemonService {
    @Autowired
    private IPokemonDAO pokemonDAO;

    @Override
    public List<PokemonEntity> findAll() {return pokemonDAO.findAll();}


    @Override
    public Optional<PokemonEntity> findById(Integer id) {return pokemonDAO.findById(id);}


    @Override
    public void save(PokemonEntity pokemon) {pokemonDAO.save(pokemon);}


    @Override
    public void deleteById(Integer id) {pokemonDAO.deleteById(id);}
}
