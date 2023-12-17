package com.pokeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//USERENTITY OK

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @Column(name = "id_user", nullable = false)
    private Integer idUser;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private Integer timeBet;

    @Column(nullable = false)
    private Boolean winner;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//
//    private List<PokemonUserEntity> pokemonList = new ArrayList<>();

}
