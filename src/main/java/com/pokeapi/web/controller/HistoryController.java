package com.pokeapi.web.controller;

import com.pokeapi.entity.HistoryEntity;
import com.pokeapi.service.IHistoryService;
import com.pokeapi.web.controller.dto.HistoryDTO;

import com.pokeapi.web.controller.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

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

    //swagger
    @Operation(summary = "ENDPOINT TO SHOW IN THE STATISTICS FRONTEND")
    //fin de swagger
    // http://localhost:8080/api/historial/findall
    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        List<HistoryDTO> historialEntity = historyService.findAll()
                .stream()
                .map(historial -> HistoryDTO.builder()
                        .idUser(historial.getIdUser())
                        .nameUser(historial.getNameUser())
                        .timeBetUser(historial.getTimeBetUser())
                        .isWinnerUser(historial.getIsWinnerUser())
                        .idUserPokemon(historial.getIdUserPokemon())
                        .namePokemon(historial.getNamePokemon())
                        .typeOponent(historial.getTypeOponent())
                        .movesPokemon(historial.getMovesPokemon())
                        .hpOponent(historial.getHpOponent())
                        .winnerOponent(historial.getWinnerOponent())
                        .idOponent(historial.getIdOponent())
                        .isOponentUser(historial.getIsOponentUser())
                        .typePokemon(historial.getTypePokemon())
                        .hpPokemon(historial.getHpPokemon())
                        .winnerPokemon(historial.getWinnerPokemon())
                        .build())
                .toList();
        return ResponseEntity.ok(historialEntity);
    }
    //swagger
    @Operation(summary = "ENDPOINT FOR BATTLE NODEJS TEAM")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "HISTORY SUCCESSFULLY CREATED",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation =HistoryDTO.class ))
                    }),
            @ApiResponse(responseCode = "500",description = "PARAMETER ERROR",content = @Content),
            @ApiResponse(responseCode = "400",description = "RESPONSE ERROR",content = @Content)
    })
    //fin de swagger
    //http://localhost:8080/api/historial/save
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody HistoryDTO historyDTO) throws URISyntaxException {
        if (historyDTO.getNameUser().isBlank()) {
            return  ResponseEntity.badRequest().build();
        }
        historyService.save(HistoryEntity.builder()
                .nameUser(historyDTO.getNameUser())
                .timeBetUser(historyDTO.getTimeBetUser())
                .isWinnerUser(historyDTO.getIsWinnerUser())
                .idUserPokemon(historyDTO.getIdUserPokemon())
                .namePokemon(historyDTO.getNamePokemon())
                .typePokemon(historyDTO.getTypePokemon())
                .movesPokemon(historyDTO.getMovesPokemon())
                .hpPokemon(historyDTO.getHpPokemon())
                .winnerPokemon(historyDTO.getWinnerPokemon())
                .idOponent(historyDTO.getIdOponent())
                .isOponentUser(historyDTO.getIsOponentUser())
                .typeOponent(historyDTO.getTypeOponent())
                .hpOponent(historyDTO.getHpOponent())
                .winnerOponent(historyDTO.getWinnerOponent())
                .build());
        return ResponseEntity.created(new URI("/api/historial/save")).build();


    }
}
