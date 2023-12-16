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
public class BattleDTO {

    private Integer idPlayer;
    private Integer idPokemon;
    private Integer idBattle;
    private Boolean winner;
}
