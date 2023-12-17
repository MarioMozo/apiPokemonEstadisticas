package com.pokeapi.persistence.impl;

import com.pokeapi.entity.PokemonUserEntity;
import com.pokeapi.entity.UserEntity;
import com.pokeapi.persistence.IPokemonUserDAO;
import com.pokeapi.repository.PokemonUserRespository;
import com.pokeapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PokemonUserDAOImpl implements IPokemonUserDAO {

    @Autowired
    private PokemonUserRespository pokemonUserRespository;

    @Override
    public List<PokemonUserEntity> findAll() {
        return (List<PokemonUserEntity>) pokemonUserRespository.findAll(); }

    @Override
    public Optional<PokemonUserEntity> findById(Integer id) {
        return pokemonUserRespository.findById(id);}

    @Override
    public void save(PokemonUserEntity pokemonUserEntity){
        pokemonUserRespository.save(pokemonUserEntity);
    }

    @Override
    public void deleById(PokemonUserEntity id) {
        pokemonUserRespository.delete(id);
    }
}
