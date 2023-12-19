package com.pokeapi.persistence.impl;

import com.pokeapi.entity.HistoryEntity;
import com.pokeapi.persistence.IHistoryDAO;
import com.pokeapi.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HistoryDAOImpl implements IHistoryDAO {

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public List<HistoryEntity> findAll() {
        return (List<HistoryEntity>) historyRepository.findAll();
    }
}
