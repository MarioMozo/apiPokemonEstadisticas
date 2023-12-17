package com.pokeapi.persistence.impl;

import com.pokeapi.entity.OponentEntity;
import com.pokeapi.persistence.IOponentDAO;
import com.pokeapi.repository.OponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OponentDAOImpl implements IOponentDAO {

    @Autowired
    private OponentRepository oponentRepository;

    @Override
    public List<OponentEntity> findAll() {
        return (List<OponentEntity>) oponentRepository.findAll();
    }

    @Override
    public Optional<OponentEntity> findById(Integer id) {
        return oponentRepository.findById(id);
    }

    @Override
    public void save(OponentEntity oponent) {
        oponentRepository.save(oponent);

    }

    @Override
    public void deleteById(Integer id) {
        oponentRepository.deleteById(id);

    }
}
