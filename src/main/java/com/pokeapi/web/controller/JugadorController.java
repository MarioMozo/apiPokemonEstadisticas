package com.pokeapi.web.controller;

import com.pokeapi.service.IJugadorService;
import com.pokeapi.web.controller.dto.JugadorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jugador")
public class JugadorController {

    @Autowired
    private IJugadorService jugadorService;

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        List<JugadorDTO> jugadorLista = jugadorService.findAll()
                        .stream().map(jugador -> JugadorDTO.builder()
                        .idjugador(jugador.getIdjugador())
                        .nombre(jugador.getNombre())
                        .nivel(jugador.getNivel())
                        .batallas(jugador.getBatallas())
                        .victorias(jugador.getVictorias())
                        .derrotas(jugador.getDerrotas())
                        .build())
                .toList();
        return ResponseEntity.ok(jugadorLista);

    }
}
