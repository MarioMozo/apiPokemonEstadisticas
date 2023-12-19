package com.pokeapi.service.impl;

import com.pokeapi.entity.UserEntity;
import com.pokeapi.persistence.IUserDAO;
import com.pokeapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<UserEntity> findAll() {
        return userDAO.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Integer id){
        return userDAO.findById(id);
    }

    @Override
    public void save(UserEntity userEntity){
        userDAO.save(userEntity);
    }

    @Override
    public void deleteById(Integer id){
        userDAO.deleById(id);
    }
}
