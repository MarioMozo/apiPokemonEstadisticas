package com.pokeapi.web.controller;


import com.pokeapi.entity.UserEntity;
import com.pokeapi.service.IUserService;
import com.pokeapi.web.controller.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;
    //USER CONTROLLER OK / CONTROLLER TO SEE A USER BY ID
    @GetMapping("find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Optional<UserEntity> userOptional = userService.findById(id);
        if (userOptional.isPresent()){
            UserEntity user = userOptional.get();

            UserDTO userDTO = UserDTO.builder()
                    .idUser(user.getIdUser())
                    .name(user.getName())
                    .timeBet(user.getTimeBet())
                    .winner(user.getWinner())
                    .battles(user.getBattles())
                    .victories(user.getVictories())
                    .defeats(user.getDefeats())
                    .build();
            return ResponseEntity.ok(userDTO);

        }
        return ResponseEntity.notFound().build();
    }

    //USER CONTROLLER OK / CONTROLLER TO SEE A LIST OF USER
    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        List<UserDTO> userDTO = userService.findAll()
                .stream()
                .map(user -> UserDTO.builder()
                        .idUser(user.getIdUser())
                        .name(user.getName())
                        .timeBet(user.getTimeBet())
                        .winner(user.getWinner())
                        .battles(user.getBattles())
                        .victories(user.getVictories())
                        .defeats(user.getDefeats())
                        .build())
                .toList();
        return ResponseEntity.ok(userDTO);
    }
    //USER CONTROLLER OK / CONTROLLER TO SAVE A USER
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) throws URISyntaxException {
        if (userDTO.getName().isBlank()) {
            return  ResponseEntity.badRequest().build();
        }
        userService.save(UserEntity.builder()
                .idUser(userDTO.getIdUser())
                .name(userDTO.getName())
                .winner(userDTO.getWinner())
                .timeBet(userDTO.getTimeBet())
                        .battles(userDTO.getBattles())
                        .victories(userDTO.getVictories())
                        .defeats(userDTO.getDefeats())
                .build());
        return ResponseEntity.created(new URI("/api/user/save")).build();
    }
    //USER CONTROLLER OK / CONTROLLER TO SAVE A USER
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody UserDTO userDTO){
        Optional<UserEntity> userEntityOptional = userService.findById(id);

        if (userEntityOptional.isPresent()){
            UserEntity user = userEntityOptional.get();
            user.setIdUser(userDTO.getIdUser());
            user.setName(userDTO.getName());
            user.setTimeBet(userDTO.getTimeBet());
            user.setWinner(userDTO.getWinner());
            user.setBattles(userDTO.getBattles());
            user.setVictories(userDTO.getVictories());
            user.setDefeats(userDTO.getDefeats());
            userService.save(user);
            return ResponseEntity.ok("Usuario actualizado correctamente");
        }
        return ResponseEntity.notFound().build();
    }


}
