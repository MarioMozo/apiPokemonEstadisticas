package com.pokeapi.web.controller;

import com.pokeapi.persistence.entity.PokemonEntity;
import com.pokeapi.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class pokemonController {

    @Autowired
    private PokemonService pokemonService;


    @GetMapping
    public ResponseEntity<List<PokemonEntity>>getAll(){
        return ResponseEntity.ok(this.pokemonService.getAll());
    }
}
