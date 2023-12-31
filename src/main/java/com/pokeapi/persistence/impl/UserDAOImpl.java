package com.pokeapi.persistence.impl;
import com.pokeapi.entity.UserEntity;
import com.pokeapi.persistence.IUserDAO;
import com.pokeapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAOImpl implements IUserDAO {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> findAll() {return (List<UserEntity>) userRepository.findAll(); }

    @Override
    public Optional<UserEntity> findById(Integer id) { return userRepository.findById(id); }

    @Override
    public void save(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    @Override
    public void deleById(Integer id){
        userRepository.deleteById(id);
    }
}
