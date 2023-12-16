package com.pokeapi.web.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BattlePlayerDTO {

    private Integer idBattle;

    private Integer battle;

    private Integer victory;

    private Integer defeat;
}
