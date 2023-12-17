package com.pokeapi.service;

import com.pokeapi.entity.UserEntity;
import org.apache.catalina.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<UserEntity> findAll();

    Optional<UserEntity> findById(Integer id);

    void save(UserEntity userEntity);

    void deleteById(Integer id);
}
