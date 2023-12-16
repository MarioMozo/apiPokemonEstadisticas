package com.pokeapi.web.controller;

import com.pokeapi.entity.BattlePokemonEntity;
import com.pokeapi.service.IBattlePokemonService;
import com.pokeapi.web.controller.dto.BattlePokemonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/battlepokemon")
public class BattlePokemonController {
    @Autowired
    private IBattlePokemonService battlePokemonService;

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){

        List<BattlePokemonDTO> battleList = battlePokemonService.findAll()
                .stream().map(battle -> BattlePokemonDTO.builder()
                        .idBattle(battle.getIdBattle())
                        .battle(battle.getBattle())
                        .winner(battle.getWinner())
                        .defeat(battle.getDefeat())
                        .build())
                .toList();
        return ResponseEntity.ok(battleList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Optional<BattlePokemonEntity> battleOptional = battlePokemonService.findById(id);
        if (battleOptional.isPresent()){
            BattlePokemonEntity battlePokemon = battleOptional.get();

            BattlePokemonDTO battlePokemonDTO = BattlePokemonDTO.builder()
                    .idBattle(battlePokemon.getIdBattle())
                    .battle(battlePokemon.getBattle())
                    .winner(battlePokemon.getWinner())
                    .defeat(battlePokemon.getDefeat())
                    .build();
            return ResponseEntity.ok(battlePokemonDTO);
        }
        return ResponseEntity.notFound().build();

    }

}
