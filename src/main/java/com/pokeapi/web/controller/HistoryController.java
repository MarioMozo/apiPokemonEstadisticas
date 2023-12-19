package com.pokeapi.web.controller;

import com.pokeapi.service.IHistoryService;
import com.pokeapi.web.controller.dto.HistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/historial")
public class HistoryController {

    @Autowired
    private IHistoryService historialService;


    // ENDPOINT PARA MOSTRAR EN EL FRONTEND DE ESTADISTICAS
    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        List<HistoryDTO> historialEntity = historialService.findAll()
                .stream()
                .map(historial -> HistoryDTO.builder()
                        .idUser(historial.getIdUser())
                        .nameUser(historial.getNameUser())
                        .timeBetUser(historial.getTimeBetUser())
                        .winnerUser(historial.getWinnerUser())
                        .idUserPokemon(historial.getIdUserPokemon())
                        .nameOponent(historial.getNameOponent())
                        .typeOponent(historial.getTypeOponent())
                        .movesPokemon(historial.getMovesPokemon())
                        .hpOponent(historial.getHpOponent())
                        .winnerOponent(historial.getWinnerOponent())
                        .idOponent(historial.getIdOponent())
                        .nameOponent(historial.getNameOponent())
                        .typePokemon(historial.getTypePokemon())
                        .hpPokemon(historial.getHpPokemon())
                        .winnerPokemon(historial.getWinnerPokemon())
                        .build())
                .toList();
        return ResponseEntity.ok(historialEntity);
    }


}
