package com.pokeapi.web.controller;

import com.pokeapi.entity.BattlePlayerEntity;
import com.pokeapi.service.IBattlePlayerService;
import com.pokeapi.web.controller.dto.BattlePlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/battleplayer")
public class BattlePlayerController {

    @Autowired
    private IBattlePlayerService battlePlayerService;

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){

        List<BattlePlayerDTO> battleList = battlePlayerService.findAll()
                .stream().map(battle -> BattlePlayerDTO.builder()
                        .idBattle(battle.getIdBattle())
                        .battle(battle.getBattle())
                        .victory(battle.getVictory())
                        .defeat(battle.getDefeat())
                        .build())
                .toList();
        return ResponseEntity.ok(battleList);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Optional<BattlePlayerEntity> battleOptional = battlePlayerService.findById(id);
        if (battleOptional.isPresent()){
            BattlePlayerEntity battlePlayer = battleOptional.get();

            BattlePlayerDTO battlePlayerDTO = BattlePlayerDTO.builder()
                    .idBattle(battlePlayer.getIdBattle())
                    .battle(battlePlayer.getBattle())
                    .victory(battlePlayer.getVictory())
                    .defeat(battlePlayer.getDefeat())
                    .build();
            return ResponseEntity.ok(battlePlayerDTO);
        }
        return ResponseEntity.notFound().build();

    }
}
