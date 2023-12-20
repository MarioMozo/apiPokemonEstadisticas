package com.pokeapi.web.controller;


import com.pokeapi.entity.PokemonUserEntity;

import com.pokeapi.service.IPokemonUserService;

import com.pokeapi.web.controller.dto.PokemonUserDTO;
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
import java.util.Optional;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonUserController {

    @Autowired
    private IPokemonUserService pokemonUserService;
    //swagger
    @Operation(summary = "POKEMON_USER CONTROLLER OK / CONTROLLER TO SEE A POKEMON_USER BY ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "POKEMON ID SUCCESSFULLY FOUND",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PokemonUserDTO.class ))
                    }),
            @ApiResponse(responseCode = "500",description = "ID INVALID",content = @Content)
    })
    // fin swagger
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {

        Optional<PokemonUserEntity> pokemonUserEntity = pokemonUserService.findById(id);
        if (pokemonUserEntity.isPresent()) {
            PokemonUserEntity pokemon = pokemonUserEntity.get();
            PokemonUserDTO pokemonUserDTO = PokemonUserDTO.builder()
                    .idUserPokemon(pokemon.getIdUserPokemon())
                    .name(pokemon.getName())
                    .type(pokemon.getType())
                    .moves(pokemon.getMoves())
                    .hp(pokemon.getHp())
                    .winner(pokemon.getWinner())
                    .battles(pokemon.getBattles())
                    .victories(pokemon.getVictories())
                    .defeats(pokemon.getDefeats())
                    .build();
            return ResponseEntity.ok(pokemonUserDTO);
        }
        return ResponseEntity.notFound().build();
    }
    //swagger
    @Operation(summary = "POKEMON_USER OK / CONTROLLER TO SEE POKEMON_USER LIST")

    //fin de swagger
    @GetMapping("/finall")
    public ResponseEntity<?> findAll() {
        List<PokemonUserDTO> pokemonUserDTOS = pokemonUserService.findAll()
                .stream()
                .map(pokemon -> PokemonUserDTO.builder()
                        .idUserPokemon(pokemon.getIdUserPokemon())
                        .name(pokemon.getName())
                        .type(pokemon.getType())
                        .moves(pokemon.getMoves())
                        .hp(pokemon.getHp())
                        .winner(pokemon.getWinner())
                        .battles(pokemon.getBattles())
                        .victories(pokemon.getVictories())
                        .defeats(pokemon.getDefeats())
                        .build())
                .toList();
        return ResponseEntity.ok(pokemonUserDTOS);
    }
    //swagger
    @Operation(summary = "POKEMON_USER OK / CONTROLLER TO SAVE A POKEMON_USER")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "POKEMON SUCCESSFULLY CREATED",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation =PokemonUserDTO.class ))
                    }),
            @ApiResponse(responseCode = "500",description = "PARAMETER ERROR",content = @Content),
            @ApiResponse(responseCode = "400",description = "RESPONSE ERROR",content = @Content)
    })
    //fin de swagger
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PokemonUserDTO pokemonUserDTO) throws URISyntaxException {
        if (pokemonUserDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        pokemonUserService.save(PokemonUserEntity.builder()
                .idUserPokemon(pokemonUserDTO.getIdUserPokemon())
                .name(pokemonUserDTO.getName())
                .type(pokemonUserDTO.getType())
                .moves(pokemonUserDTO.getMoves())
                .hp(pokemonUserDTO.getHp())
                .winner(pokemonUserDTO.getWinner())
                        .battles(pokemonUserDTO.getBattles())
                        .victories(pokemonUserDTO.getVictories())
                        .defeats(pokemonUserDTO.getDefeats())
                .build());
        return ResponseEntity.created(new URI("/api/pokemon/save")).build();
    }
    //swagger
    @Operation(summary = "POKEMON_USER OK / CONTROLLER TO UPDATE A POKEMON_USER")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "POKEMON UPDATE",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation =PokemonUserDTO.class ))
                    }),
            @ApiResponse(responseCode = "500",description = "PARAMETER ERROR",content = @Content),
            @ApiResponse(responseCode = "400",description = "RESPONSE ERROR",content = @Content)
    })
    //fin de swagger
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody PokemonUserDTO pokemonUpdate) {
        Optional<PokemonUserEntity> pokemonUserEntityOptional = pokemonUserService.findById(id);
        if (pokemonUserEntityOptional.isPresent()) {
            PokemonUserEntity pokemon = pokemonUserEntityOptional.get();
            pokemon.setIdUserPokemon(pokemonUpdate.getIdUserPokemon());
            pokemon.setName(pokemonUpdate.getName());
            pokemon.setType(pokemonUpdate.getType());
            pokemon.setMoves(pokemonUpdate.getMoves());
            pokemon.setHp(pokemonUpdate.getHp());
            pokemon.setWinner(pokemonUpdate.getWinner());
            pokemon.setBattles(pokemonUpdate.getBattles());
            pokemon.setVictories(pokemonUpdate.getVictories());
            pokemon.setDefeats(pokemonUpdate.getDefeats());
            pokemonUserService.save(pokemon);
            return ResponseEntity.ok("Updated User Pokemon");
        }
        return ResponseEntity.notFound().build();
    }

}
