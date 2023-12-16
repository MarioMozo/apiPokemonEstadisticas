package com.pokeapi.web.controller;


import com.pokeapi.entity.PokemonEntity;
import com.pokeapi.service.IPokemonService;
import com.pokeapi.web.controller.dto.PokemonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private IPokemonService pokemonService;

    @GetMapping("/findall")

    public ResponseEntity<?> findAll() {
        List<PokemonDTO> pokemonLista = pokemonService.findAll()
                .stream().map(pokemon -> PokemonDTO.builder()
                        .idPokemon(pokemon.getIdPokemon())
                        .nombre(pokemon.getNombre())
                        .nombreEstadistica(pokemon.getNombreEstadistica())
                        .valorEstadistica(pokemon.getValorEstadistica())
                        .build())
                .toList();
        return ResponseEntity.ok(pokemonLista);
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<?> findByid(@PathVariable Integer id) {
        Optional<PokemonEntity> pokemonEntityOptional = pokemonService.findById(id);
        if (pokemonEntityOptional.isPresent()) {
            PokemonEntity pokemon = pokemonEntityOptional.get();

            PokemonDTO pokemonDTO = PokemonDTO.builder()
                    .idPokemon(pokemon.getIdPokemon())
                    .nombre(pokemon.getNombre())
                    .nombreEstadistica(pokemon.getNombreEstadistica())
                    .valorEstadistica(pokemon.getValorEstadistica())
                    .build();
            return ResponseEntity.ok(pokemonEntityOptional);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody PokemonDTO pokemonDTO) throws URISyntaxException {
        if (pokemonDTO.getNombre().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        pokemonService.save(PokemonEntity.builder()
                .nombre(pokemonDTO.getNombre())
                .nombreEstadistica(pokemonDTO.getNombreEstadistica())
                .valorEstadistica(pokemonDTO.getValorEstadistica())
                .build());
        return ResponseEntity.created(new URI("/api/pokemon/guardar")).build();


    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePokemon(@PathVariable Integer id, @RequestBody PokemonDTO pokemonDTO){
        Optional<PokemonEntity> pokemonUpdate = pokemonService.findById(id);

        if (pokemonUpdate.isPresent()){

            PokemonEntity pokemon =pokemonUpdate.get();
                    pokemon.setNombre(pokemonDTO.getNombre());
                    pokemon.setNombreEstadistica(pokemonDTO.getNombreEstadistica());
                    pokemon.setValorEstadistica(pokemonDTO.getValorEstadistica());
                    pokemonService.save(pokemon);
            return ResponseEntity.ok("Se actualizo correctamente");
        }
        return ResponseEntity.notFound().build();
        }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        if (id != null){
            pokemonService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }

}

