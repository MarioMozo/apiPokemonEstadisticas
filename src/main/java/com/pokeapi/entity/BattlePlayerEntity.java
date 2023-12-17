package com.pokeapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "battle_player")
public class BattlePlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_battle", nullable = false)
    private Integer idBattle;

    @Column (nullable = false)
    private Integer battle;

    @Column (nullable = false)
    private Integer victory;

    @Column (nullable = false)
    private Integer defeat;

}
