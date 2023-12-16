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

public class PlayerDTO {

        private Integer idPlayer;

        private String username;

        private String name;

        private Integer level;

}
