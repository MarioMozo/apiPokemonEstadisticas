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
    private Integer timeBet;

    @Column(nullable = false)
    private Boolean isWinnerUser;

    @Column(name = "id_user_pokemon", nullable = false)
    private Integer idUserPokemon;

    @Column(nullable = false, length = 50)
    private String nameUserPokemon;

    @Column(nullable = false, length = 50)
    private String typeUserPokemon;

    @Column(nullable = false, length = 50)
    private String moveUserPokemon;

    @Column(nullable = false)
    private Integer hpUserPokemon;

    @Column(nullable = false)
    private Boolean isOpntWinner;

    @Column(nullable = false, length = 25)
    private String nameOpntPokemon;

    @Column(nullable = false, length = 25)
    private String typeOpnt;

    @Column(nullable = false, length = 25)
    private String moveOpntPokemon;

    @Column(nullable = false )
    private Integer hpOpntPokemon;

    @Column(nullable = false )
    private Integer numberTurns;

}
