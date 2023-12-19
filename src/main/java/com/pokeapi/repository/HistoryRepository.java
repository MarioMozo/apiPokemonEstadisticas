package com.pokeapi.repository;

import com.pokeapi.entity.HistoryEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface HistoryRepository extends ListCrudRepository<HistoryEntity, Integer> {

}
