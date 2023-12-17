package com.pokeapi.persistence;
import com.pokeapi.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {

    List<UserEntity> findAll();

    Optional<UserEntity> findById(Integer id);

    void save(UserEntity userEntity);

    void deleById(Integer id);
}
