package com.pokeapi.web.controller;


import com.pokeapi.entity.PokemonUserEntity;

import com.pokeapi.service.IPokemonUserService;

import com.pokeapi.web.controller.dto.PokemonUserDTO;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "POKEMON_USER CONTROLLER OK / CONTROLLER TO SEE A POKEMON_USER BY ID")
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
                    .build();
            return ResponseEntity.ok(pokemonUserDTO);
        }
        return ResponseEntity.notFound().build();
    }
    @Operation(summary = "POKEMON_USER OK / CONTROLLER TO SEE POKEMON_USER LIST")
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
                        .build())
                .toList();
        return ResponseEntity.ok(pokemonUserDTOS);
    }
    @Operation(summary = "POKEMON_USER OK / CONTROLLER TO SAVE A POKEMON_USER")
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
                .build());
        return ResponseEntity.created(new URI("/api/pokemon/save")).build();
    }
    @Operation(summary = "POKEMON_USER OK / CONTROLLER TO UPDATE A POKEMON_USER")
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
            pokemonUserService.save(pokemon);
            return ResponseEntity.ok("Pokemon de usuario actualizado");
        }
        return ResponseEntity.notFound().build();
    }

}
