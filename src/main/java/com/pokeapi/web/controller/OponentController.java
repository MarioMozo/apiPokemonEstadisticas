package com.pokeapi.web.controller;

import com.pokeapi.entity.OponentEntity;
import com.pokeapi.service.IOponentService;
import com.pokeapi.web.controller.dto.OponentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/oponent")
public class OponentController {

    @Autowired
    private IOponentService oponentService;
    //OPPONENT CONTROLLER OK /CONTROLLER TO SEE AN OPPONENT BY ID
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {

        Optional<OponentEntity> oponentOptional = oponentService.findById(id);
        if (oponentOptional.isPresent()) {
            OponentEntity oponent = oponentOptional.get();
            OponentDTO oponentDTO = OponentDTO.builder()
                    .idOponent(oponent.getIdOponent())
                    .name(oponent.getName())
                    .type(oponent.getType())
                    .hp(oponent.getHp())
                    .winner(oponent.getWinner())
                    .battles(oponent.getBattles())
                    .battles(oponent.getVictories())
                    .battles(oponent.getDefeats())
                    .build();
            return ResponseEntity.ok(oponentDTO);

        }
        return ResponseEntity.notFound().build();
    }
    //CONTROLLER OPPONENT OK / CONTROLLER TO SEE LIST OF OPPONENTS
    @GetMapping("/finall")
    public ResponseEntity<?> findAll() {
        List<OponentDTO> oponentDTOList = oponentService.findAll()
                .stream()
                .map(oponent -> OponentDTO.builder()
                        .idOponent(oponent.getIdOponent())
                        .name(oponent.getName())
                        .type(oponent.getType())
                        .hp(oponent.getHp())
                        .winner(oponent.getWinner())
                        .battles(oponent.getBattles())
                        .battles(oponent.getVictories())
                        .battles(oponent.getDefeats())
                        .build())
                .toList();
        return ResponseEntity.ok(oponentDTOList);
    }
    //OPONENT CONTROLLER OK /CONTROLLER TO SAVE AN OPONENT
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody OponentDTO oponentDTO) throws URISyntaxException {
        if (oponentDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        oponentService.save(OponentEntity.builder()
                .idOponent(oponentDTO.getIdOponent())
                .name(oponentDTO.getName())
                .type(oponentDTO.getType())
                .hp(oponentDTO.getHp())
                .winner(oponentDTO.getWinner())
                        .battles(oponentDTO.getBattles())
                        .victories(oponentDTO.getVictories())
                        .defeats(oponentDTO.getDefeats())
                .build());
        return ResponseEntity.created(new URI("/api/oponent/save")).build();
    }
    //OPONENT CONTROLLER OK /CONTROLLER TO UPDATE AN OPONENT
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody OponentDTO oponentUpdate) {
        Optional<OponentEntity> optionalOponentEntity = oponentService.findById(id);
        if (optionalOponentEntity.isPresent()) {
            OponentEntity oponent = optionalOponentEntity.get();
            oponent.setIdOponent(oponentUpdate.getIdOponent());
            oponent.setName(oponentUpdate.getName());
            oponent.setType(oponentUpdate.getType());
            oponent.setHp(oponentUpdate.getHp());
            oponent.setWinner(oponentUpdate.getWinner());
            oponent.setBattles(oponentUpdate.getBattles());
            oponent.setVictories(oponentUpdate.getVictories());
            oponent.setDefeats(oponentUpdate.getDefeats());
            oponentService.save(oponent);
            return ResponseEntity.ok("Pokemon actualizado");
        }
        return ResponseEntity.notFound().build();
    }
    //OPONENT CONTROLLER OK / CONTROLLER TO ELIMINATE AN OPPONENT
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        if (id != null){
            oponentService.deleteById(id);
            return ResponseEntity.ok("Pokemon eliminado");
        }
        return ResponseEntity.badRequest().build();
    }

}

