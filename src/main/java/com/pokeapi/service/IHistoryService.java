package com.pokeapi.service;

import com.pokeapi.entity.HistoryEntity;

import java.util.List;

public interface IHistoryService {

    List<HistoryEntity> findAll();
}
