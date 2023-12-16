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
public class BattlePokemonDTO {

    private Integer idBattle;

    private Integer battle;

    private Integer winner;

    private Integer defeat;
}
