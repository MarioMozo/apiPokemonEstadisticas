package com.pokeapi.repository;
import com.pokeapi.entity.BattlePokemonEntity;
import com.pokeapi.entity.PlayerEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface PlayerRepository extends ListCrudRepository<PlayerEntity, Integer> {

    }


