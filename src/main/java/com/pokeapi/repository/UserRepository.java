package com.pokeapi.repository;
import com.pokeapi.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface UserRepository extends ListCrudRepository<UserEntity, Integer> {

    }


