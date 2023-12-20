package com.pokeapi.web.controller.dto;

import jakarta.persistence.Column;
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

    private Integer timeBet;

    private Boolean isWinnerUser;

    private Integer idUserPokemon;

    private String nameUserPokemon;

    private String typeUserPokemon;

    private String moveUserPokemon;

    private Integer hpUserPokemon;

    private Boolean isOpntWinner;

    private String nameOpntPokemon;

    private String typeOpnt;

    private String moveOpntPokemon;

    private Integer hpOpntPokemon;

    private Integer numberTurns;

}
