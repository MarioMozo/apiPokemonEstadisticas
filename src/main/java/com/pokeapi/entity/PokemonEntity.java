package com.pokeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "pokemon")
public class PokemonEntity {

    @Id
    //Se genera automaticamente
   //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pokemon", nullable = false)
    private Integer idPokemon;

    @Column(nullable = false, length = 35)
    private String nombre;

    @Column(name= "nombre_estadistica",nullable = false, length = 35)
    private String nombreEstadistica;

    @Column(name="valor_estadistica",nullable = false)
    private Integer valorEstadistica;


}
