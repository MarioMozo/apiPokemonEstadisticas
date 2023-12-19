package com.pokeapi.service.impl;

import com.pokeapi.entity.HistoryEntity;
import com.pokeapi.persistence.IHistoryDAO;
import com.pokeapi.service.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements IHistoryService {
    @Autowired
    private IHistoryDAO historyDAO;

    @Override
    public List<HistoryEntity> findAll() {
        return historyDAO.findAll();
    }

}
