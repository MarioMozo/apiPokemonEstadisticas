package com.pokeapi.web.controller;

import com.pokeapi.entity.HistoryEntity;
import com.pokeapi.service.IHistoryService;
import com.pokeapi.web.controller.dto.HistoryDTO;
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
@RequestMapping("/api/history")
public class HistoryController {

    @Autowired
    private IHistoryService historyService;

    //swagger
    @Operation(summary = "ENDPOINT TO SHOW IN THE STATISTICS FRONTEND")
    //fin de swagger
    // http://localhost:8091/api/history/findall
    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        List<HistoryDTO> historialEntity = historyService.findAll()
                .stream()
                .map(historial -> HistoryDTO.builder()
                        .idUser(historial.getIdUser())
                        .nameUser(historial.getNameUser())
                        .timeBet(historial.getTimeBet())
                        .isWinnerUser(historial.getIsWinnerUser())
                        .idUserPokemon(historial.getIdUserPokemon())
                        .nameUserPokemon(historial.getNameUserPokemon())
                        .typeUserPokemon(historial.getTypeUserPokemon())
                        .moveUserPokemon(historial.getMoveUserPokemon())
                        .hpUserPokemon(historial.getHpUserPokemon())
                        .isOpntWinner(historial.getIsOpntWinner())
                        .nameOpntPokemon(historial.getNameOpntPokemon())
                        .typeOpnt(historial.getTypeOpnt())
                        .moveOpntPokemon(historial.getMoveOpntPokemon())
                        .hpOpntPokemon(historial.getHpOpntPokemon())
                        .numberTurns(historial.getNumberTurns())
                        .build())
                .toList();
        return ResponseEntity.ok(historialEntity);
    }
    //swagger
    @Operation(summary = "ENDPOINT FOR BATTLE NODEJS TEAM")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "HISTORY SUCCESSFULLY CREATED",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation =HistoryDTO.class ))
                    }),
            @ApiResponse(responseCode = "500",description = "PARAMETER ERROR",content = @Content),
            @ApiResponse(responseCode = "400",description = "RESPONSE ERROR",content = @Content)
    })
    //fin de swagger
    //http://localhost:8091/api/history/save
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody HistoryDTO historyDTO) throws URISyntaxException {
        if (historyDTO.getNameUser().isBlank()) {
            return  ResponseEntity.badRequest().build();
        }
        historyService.save(HistoryEntity.builder()
                        .nameUser(historyDTO.getNameUser())
                        .timeBet(historyDTO.getTimeBet())
                        .isWinnerUser(historyDTO.getIsWinnerUser())
                        .idUserPokemon(historyDTO.getIdUserPokemon())
                        .nameUserPokemon(historyDTO.getNameUserPokemon())
                        .typeUserPokemon(historyDTO.getTypeUserPokemon())
                        .moveUserPokemon(historyDTO.getMoveUserPokemon())
                        .hpUserPokemon(historyDTO.getHpUserPokemon())
                        .isOpntWinner(historyDTO.getIsOpntWinner())
                        .nameOpntPokemon(historyDTO.getNameOpntPokemon())
                        .typeOpnt(historyDTO.getTypeOpnt())
                        .moveOpntPokemon(historyDTO.getMoveOpntPokemon())
                        .hpOpntPokemon(historyDTO.getHpOpntPokemon())
                        .numberTurns(historyDTO.getNumberTurns())
                .build());
        return ResponseEntity.created(new URI("/api/historial/save")).build();


    }
}
