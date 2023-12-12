package com.pokeapi.service.impl;

import com.pokeapi.entity.JugadorEntity;
import com.pokeapi.persistence.IJugadorDAO;
import com.pokeapi.service.IJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorServiceImpl implements IJugadorService {
    @Autowired
    private IJugadorDAO jugadorDAO;

    @Override
    public List<JugadorEntity> findAll() {
        return jugadorDAO.findAll();
    }

    @Override
    public Optional<JugadorEntity> findById(Integer id) {return jugadorDAO.findById(id);}

    @Override
    public void save(JugadorEntity jugador) {jugadorDAO.save(jugador);}

    @Override
    public void deleteById(Integer id) {
        jugadorDAO.deleteById(id);
    }
}
