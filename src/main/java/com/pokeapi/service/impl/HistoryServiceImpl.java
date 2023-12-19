package com.pokeapi.service.impl;

import com.pokeapi.entity.HistoryEntity;
import com.pokeapi.entity.PokemonUserEntity;
import com.pokeapi.persistence.IHistoryDAO;
import com.pokeapi.service.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryServiceImpl implements IHistoryService {

    @Autowired
    private IHistoryDAO historyDAO;

    @Override
    public List<HistoryEntity> findAll() {
        return historyDAO.findAll();
    }

    @Override
    public Optional<HistoryEntity> findById(Integer id) {
        return historyDAO.findById(id);
    }

    @Override
    public void save(HistoryEntity historyEntity) {
        historyDAO.save(historyEntity);
    }

    @Override
    public void deleteById(Integer id) {
        historyDAO.deleteById(id);
    }

}
