package com.pokeapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jugador")
public class JugadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador", nullable = false)
    private Integer idjugador;


    @Column(nullable = false, length = 35)
    private String nombre;

    @Column(nullable = false)
    private Integer nivel;

    @Column(nullable = false)
    private Integer batallas;

    @Column(nullable = false)
    private Integer victorias;

    @Column(nullable = false)
    private Integer derrotas;

    @OneToOne
    @JoinColumn(name="id_pokemon",referencedColumnName = "id_pokemon",insertable = false,updatable = false)
    private List<PokemonEntity> pokemonEntity = new ArrayList<>();
}
