package com.pokeapi.service;

import com.pokeapi.entity.PokemonEntity;
import com.pokeapi.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }
    public List <PokemonEntity>getAll(){
        return this.pokemonRepository.findAll();
    }
}
