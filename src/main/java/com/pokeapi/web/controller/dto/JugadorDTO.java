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
public class JugadorDTO {

    private Integer idjugador;
    private String nombre;
    private Integer nivel;
    private Integer batallas;
    private Integer victorias;
    private Integer derrotas;
}
