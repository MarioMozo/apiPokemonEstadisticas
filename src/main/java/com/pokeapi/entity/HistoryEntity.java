package com.pokeapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "battle_history")
public class HistoryEntity {


    @Id
    @Column(name = "id_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUser;

    @Column(nullable = false, length = 50)
    private String nameUser;

    @Column(nullable = false)
    private Integer timeBetUser;

    @Column(nullable = false)
    private Boolean isWinnerUser;


    @Column(name = "id_user_pokemon", nullable = false)
    private Integer idUserPokemon;

    @Column(nullable = false, length = 50)
    private String namePokemon;

    @Column(nullable = false, length = 50)
    private String typePokemon;

    @Column(nullable = false, length = 50)
    private String movesPokemon;

    @Column(nullable = false)
    private Integer hpPokemon;

    @Column(nullable = false)
    private Boolean winnerPokemon;


    @Column(name = "id_oponent", nullable = false)
    private Integer idOponent;

    @Column(nullable = false, length = 50)
    private String isOponentUser;

    @Column(nullable = false, length = 25)
    private String typeOponent;

    @Column(nullable = false )
    private Integer hpOponent;

    @Column(nullable = false)
    private Boolean winnerOponent;
}
