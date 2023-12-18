package com.pokeapi.web.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokemonUserDTO {

    private Integer idUserPokemon;

    private String name;

    private String type;

    private String moves;

    private Integer hp;

    private Boolean winner;

    private Integer battles;

    private Integer victories;

    private Integer defeats;
}
