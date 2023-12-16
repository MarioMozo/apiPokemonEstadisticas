package com.pokeapi.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "battle")
@IdClass(BattleId.class)
public class BattleEntity {

    //EL ID VIENE DE JUGANDOR, LO CUAL NO SE GENERARÁ,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idBattle;

    @Id
    @Column(name ="id_player", nullable = false)
    private Integer idPlayer;

    @Id
    @Column(name = "id_pokemon", nullable = false)
    private Integer idPokemon;

    @Column(nullable = false)
    private Boolean winner;

    @ManyToMany
    @JoinColumn(name = "id_pokemon", referencedColumnName = "id_pokemon", insertable = false, updatable = false)
    private PokemonEntity pokemon;


    @ManyToMany
    @JoinColumn(name = "id_player", referencedColumnName = "id_player", insertable = false, updatable = false)
    private PlayerEntity player;
    
}
