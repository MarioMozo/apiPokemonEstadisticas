package com.pokeapi.web.controller;

import com.pokeapi.service.IPokemonService;
import com.pokeapi.web.controller.dto.PokemonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private IPokemonService pokemonService;

    @GetMapping("/findall")

    public ResponseEntity<?> findAll(){
        List<PokemonDTO> pokemonLista = pokemonService.findAll()
                .stream().map(pokemon -> PokemonDTO.builder()
                        .idPokemon(pokemon.getIdPokemon())
                        .nombre(pokemon.getNombre())
                        .nombreEstadistica(pokemon.getNombreEstadistica())
                        .valorEstadistica(pokemon.getValorEstadistica())
                        .batallas(pokemon.getBatallas())
                        .victorias(pokemon.getVictorias())
                        .derrotas(pokemon.getDerrotas())
                        .build())
                .toList();
        return ResponseEntity.ok(pokemonLista);

    }
}
