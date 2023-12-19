package com.pokeapi.persistence;

import com.pokeapi.entity.HistoryEntity;

import java.util.List;

public interface IHistoryDAO {

    List<HistoryEntity> findAll();
}
