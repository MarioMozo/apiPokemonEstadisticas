package com.pokeapi.persistence;

import com.pokeapi.entity.HistoryEntity;
import com.pokeapi.entity.OponentEntity;

import java.util.List;
import java.util.Optional;

public interface IHistoryDAO {

    List<HistoryEntity> findAll();
    Optional<HistoryEntity> findById(Integer id);
    void save(HistoryEntity historyEntity);
    void deleteById(Integer id);
}
