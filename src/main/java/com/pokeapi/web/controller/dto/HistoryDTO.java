package com.pokeapi.web.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoryDTO {

    private Integer idUser;

    private String nameUser;

    private Integer timeBetUser;

    private Boolean winnerUser;

    private Integer idUserPokemon;

    private String namePokemon;

    private String typePokemon;

    private String movesPokemon;

    private Integer hpPokemon;

    private Boolean winnerPokemon;

    private Integer idOponent;

    private String nameOponent;

    private String typeOponent;

    private Integer hpOponent;

    private Boolean winnerOponent;

}
