package com.pokeapi.persistence.impl;

import com.pokeapi.entity.JugadorEntity;
import com.pokeapi.persistence.IJugadorDAO;
import com.pokeapi.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JugadorDAOImpl implements IJugadorDAO {
    @Autowired
    private JugadorRepository jugadorRepository;


    @Override
    public List<JugadorEntity> findAll() {
        return (List<JugadorEntity>) jugadorRepository.findAll();
    }

    @Override
    public Optional<JugadorEntity> findById(Integer id) {return jugadorRepository.findById(id);}

    @Override
    public void save(JugadorEntity jugador) {
        jugadorRepository.save(jugador);
    }

    @Override
    public void deleteById(Integer id) {
        jugadorRepository.deleteById(id);
    }
}
