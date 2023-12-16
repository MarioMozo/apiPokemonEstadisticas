package com.pokeapi.web.controller;


import com.pokeapi.entity.BattleEntity;
import com.pokeapi.service.IBattleService;
import com.pokeapi.web.controller.dto.BattleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/battle")
public class BattleController {
    @Autowired
    private IBattleService battleService;

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){

        List<BattleDTO> battleDTOList = battleService.findAll()
                .stream().map(battle -> BattleDTO.builder()
                        .idBattle(battle.getIdBattle())
                        .winner(battle.getWinner())
                        .build())
                .toList();
        return ResponseEntity.ok(battleDTOList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Optional<BattleEntity> battleOptional = battleService.findById(id);
        if (battleOptional.isPresent()){
            BattleEntity battleEntity = battleOptional.get();

            BattleDTO battleDTO = BattleDTO.builder()
                    .idPlayer(battleEntity.getIdPlayer())
                    .idPokemon(battleEntity.getIdPokemon())
                    .winner(battleEntity.getWinner())
                    .build();
            return ResponseEntity.ok(battleDTO);
        }
        return ResponseEntity.notFound().build();
    }
}

