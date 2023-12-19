package com.pokeapi.service;

import com.pokeapi.entity.HistoryEntity;

import java.util.List;
import java.util.Optional;

public interface IHistoryService {

    List<HistoryEntity> findAll();
    Optional<HistoryEntity> findById(Integer id);
    void save(HistoryEntity historyEntity);
    void deleteById(Integer id);
}
