package com.pokeapi.persistence.impl;

import com.pokeapi.entity.PokemonEntity;
import com.pokeapi.persistence.IPokemonDAO;
import com.pokeapi.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PokemonDAOImpl implements IPokemonDAO {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public List<PokemonEntity> findAll() { return (List<PokemonEntity>) pokemonRepository.findAll();}


    @Override
    public Optional<PokemonEntity> findById(Integer id) {return pokemonRepository.findById(id);}



    @Override
    public void save(PokemonEntity pokemon) {pokemonRepository.save(pokemon);}



    @Override
    public void deleteById(Integer id) {pokemonRepository.deleteById(id);}
}
