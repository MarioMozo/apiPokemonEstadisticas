package com.pokeapi.web.controller;

import com.pokeapi.entity.OponentEntity;
import com.pokeapi.service.IOponentService;
import com.pokeapi.web.controller.dto.OponentDTO;
import com.pokeapi.web.controller.dto.PokemonUserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    //swagger
    @Operation(summary = "OPPONENT CONTROLLER OK /CONTROLLER TO SEE AN OPPONENT BY ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "OPONENT ID SUCCESSFULLY FOUND",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = OponentDTO.class ))
                    }),
            @ApiResponse(responseCode = "500",description = "ID INVALID",content = @Content)
    })
    // fin swagger
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
                    .battles(oponent.getDefeats())
                    .build();
            return ResponseEntity.ok(oponentDTO);

        }
        return ResponseEntity.notFound().build();
    }
    //swagger
    @Operation(summary = "CONTROLLER OPPONENT OK / CONTROLLER TO SEE LIST OF OPPONENTS")
    //fin de swagger
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
                        .build())
                .toList();
        return ResponseEntity.ok(oponentDTOList);
    }
    //swagger
    @Operation(summary = "OPONENT CONTROLLER OK /CONTROLLER TO SAVE AN OPONENT")
    //fn de swagger
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
                .build());
        return ResponseEntity.created(new URI("/api/oponent/save")).build();
    }
    //swagger
    @Operation(summary = "OPONENT CONTROLLER OK /CONTROLLER TO UPDATE AN OPONENT")
    //fin de swagger
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
            oponentService.save(oponent);
            return ResponseEntity.ok("Pokemon actualizado");
        }
        return ResponseEntity.notFound().build();
    }
    //swagger
    @Operation(summary = "OPONENT CONTROLLER OK / CONTROLLER TO ELIMINATE AN OPPONENT")
    //fin de swagger
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        if (id != null){
            oponentService.deleteById(id);
            return ResponseEntity.ok("Pokemon eliminado");
        }
        return ResponseEntity.badRequest().build();
    }

}

