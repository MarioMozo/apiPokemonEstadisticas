package com.pokeapi.service.impl;

import com.pokeapi.entity.OponentEntity;
import com.pokeapi.persistence.IOponentDAO;
import com.pokeapi.service.IOponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OponentServiceImpl implements IOponentService {
    @Autowired
    private IOponentDAO oponentDAO;


    @Override
    public List<OponentEntity> findAll() {
        return oponentDAO.findAll();
    }



    @Override
    public Optional<OponentEntity> findById(Integer id) {
        return oponentDAO.findById(id);
    }

    @Override
    public void save(OponentEntity oponent) {
        oponentDAO.save(oponent);
    }

    @Override
    public void deleteById(Integer id) {
        oponentDAO.deleteById(id);

    }
}
