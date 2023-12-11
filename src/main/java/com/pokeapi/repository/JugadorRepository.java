package com.pokeapi.repository;

import com.pokeapi.entity.JugadorEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends ListCrudRepository<JugadorEntity, Integer> {

}
