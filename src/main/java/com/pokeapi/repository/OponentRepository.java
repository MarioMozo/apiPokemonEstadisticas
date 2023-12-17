package com.pokeapi.repository;

import com.pokeapi.entity.OponentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface OponentRepository extends ListCrudRepository<OponentEntity, Integer> {
}
