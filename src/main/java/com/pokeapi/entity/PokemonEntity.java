package com.pokeapi.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pokemon")
public class PokemonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pokemon", nullable = false)
    private Integer idPokemon;

    @Column(nullable = false, length = 35)
    private String nombre;

    @Column(name= "nombre_estadistica",nullable = false, length = 35)
    private String nombreEstadistica;

    @Column(name="valor_estadistica",nullable = false)
    private Integer valorEstadistica;

    @Column(nullable = false)
    private Integer batallas;

    @Column(nullable = false)
    private Integer victorias;

    @Column(nullable = false)
    private Integer derrotas;
}
