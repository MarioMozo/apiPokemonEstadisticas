package com.pokeapi.web.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokemonDTO {

    private Integer idPokemon;
    private String nombre;
    private String nombreEstadistica;
    private Integer valorEstadistica;
    private Integer batallas;
    private Integer victorias;
    private Integer derrotas;

}
