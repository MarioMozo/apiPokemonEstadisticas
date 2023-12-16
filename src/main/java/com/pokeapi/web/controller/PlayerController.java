package com.pokeapi.web.controller;

import com.pokeapi.entity.PlayerEntity;
import com.pokeapi.service.IPlayerService;
import com.pokeapi.web.controller.dto.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

public class PlayerController {

    @RestController
    @RequestMapping("/api/Player")
    public class playerController {
        @Autowired
        private IPlayerService playerService;

        @GetMapping("/findall")
        public ResponseEntity<?> findAll(){

            List<PlayerDTO> playerList = playerService.findAll()
                    .stream().map(player -> PlayerDTO.builder()
                            .idPlayer(player.getIdPlayer())
                            .username(player.getUsername())
                            .name(player.getName())
                            .level(player.getLevel())
                            .build())
                    .toList();
            return ResponseEntity.ok(playerList);
        }

        @GetMapping("/find/{id}")
        public ResponseEntity<?> findById(@PathVariable Integer id){
            Optional<PlayerEntity> battleOptional = playerService.findById(id);
            if (battleOptional.isPresent()){
                PlayerEntity player = battleOptional.get();

                PlayerDTO playerDTO= PlayerDTO.builder()
                        .idPlayer(player.getIdPlayer())
                        .username(player.getUsername())
                        .name(player.getName())
                        .level(player.getLevel())
                        .build();
                return ResponseEntity.ok(playerDTO);
            }
            return ResponseEntity.notFound().build();

        }

    }

}


