package com.pokeapi.repository;

import com.pokeapi.entity.HistoryEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface HistoryRepository extends ListCrudRepository<HistoryEntity, Integer> {
}
