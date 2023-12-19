package com.pokeapi.web.controller;

import com.pokeapi.entity.HistoryEntity;
import com.pokeapi.service.IHistoryService;
import com.pokeapi.web.controller.dto.HistoryDTO;
import com.pokeapi.web.controller.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/historial")
public class HistoryController {

    @Autowired
    private IHistoryService historyService;


    @Operation(summary = "ENDPOINT TO SHOW IN THE STATISTICS FRONTEND")
    // http://localhost:8080/api/historial/findall
    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        List<HistoryDTO> historialEntity = historyService.findAll()
                .stream()
                .map(historial -> HistoryDTO.builder()
                        .idUser(historial.getIdUser())
                        .nameUser(historial.getNameUser())
                        .timeBetUser(historial.getTimeBetUser())
                        .winnerUser(historial.getWinnerUser())
                        .idUserPokemon(historial.getIdUserPokemon())
                        .namePokemon(historial.getNamePokemon())
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

    @Operation(summary = "ENDPOINT FOR BATTLE NODEJS TEAM")
    //http://localhost:8080/api/historial/save
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody HistoryDTO historyDTO) throws URISyntaxException {
        if (historyDTO.getNameUser().isBlank()) {
            return  ResponseEntity.badRequest().build();
        }
        historyService.save(HistoryEntity.builder()
                .idUser(historyDTO.getIdUser())
                .nameUser(historyDTO.getNameUser())
                .timeBetUser(historyDTO.getTimeBetUser())
                .winnerUser(historyDTO.getWinnerUser())
                .idUserPokemon(historyDTO.getIdUserPokemon())
                .namePokemon(historyDTO.getNamePokemon())
                .typePokemon(historyDTO.getTypePokemon())
                .movesPokemon(historyDTO.getMovesPokemon())
                .hpPokemon(historyDTO.getHpPokemon())
                .winnerPokemon(historyDTO.getWinnerPokemon())
                .idOponent(historyDTO.getIdOponent())
                .nameOponent(historyDTO.getNameOponent())
                .typeOponent(historyDTO.getTypeOponent())
                .hpOponent(historyDTO.getHpOponent())
                .winnerOponent(historyDTO.getWinnerOponent())
                .build());
        return ResponseEntity.created(new URI("/api/historial/save")).build();


    }
}
