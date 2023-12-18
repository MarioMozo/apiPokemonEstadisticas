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
public class OponentDTO {

    private Integer idOponent;
    private String name;
    private String type;
    private Integer hp;
    private Boolean winner;
    private Integer battles;
    private Integer victories;
    private Integer defeats;
}
