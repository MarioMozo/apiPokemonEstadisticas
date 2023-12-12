package com.pokeapi.web.controller;

import com.pokeapi.entity.JugadorEntity;
import com.pokeapi.service.IJugadorService;
import com.pokeapi.web.controller.dto.JugadorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jugador")
public class JugadorController {

    @Autowired
    private IJugadorService jugadorService;

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        List<JugadorDTO> jugadorLista = jugadorService.findAll()
                        .stream().map(jugador -> JugadorDTO.builder()
                        .idjugador(jugador.getIdjugador())
                        .nombre(jugador.getNombre())
                        .nivel(jugador.getNivel())
                        .batallas(jugador.getBatallas())
                        .victorias(jugador.getVictorias())
                        .derrotas(jugador.getDerrotas())
                        .build())
                .toList();
        return ResponseEntity.ok(jugadorLista);

    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<?> findByid(@PathVariable Integer id){
        Optional<JugadorEntity> jugadorEntityOptional = jugadorService.findById(id);
        if (jugadorEntityOptional.isPresent()){
            JugadorEntity jugador = jugadorEntityOptional.get();

            JugadorDTO jugadorDTO = JugadorDTO.builder()
                    .idjugador(jugador.getIdjugador())
                    .nombre(jugador.getNombre())
                    .nivel(jugador.getNivel())
                    .batallas(jugador.getBatallas())
                    .victorias(jugador.getVictorias())
                    .derrotas(jugador.getDerrotas())
                    .build();
            return ResponseEntity.ok(jugadorEntityOptional);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody JugadorDTO jugadorDTO) throws URISyntaxException {
        if (jugadorDTO.getNombre().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        jugadorService.save(JugadorEntity.builder()
                .nombre(jugadorDTO.getNombre())
                        .nivel(jugadorDTO.getNivel())
                        .batallas(jugadorDTO.getBatallas())
                        .victorias(jugadorDTO.getVictorias())
                        .derrotas(jugadorDTO.getDerrotas())
                .build());
        return ResponseEntity.created(new URI("/api/jugador/guardar")).build();

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJugador(@PathVariable Integer id, @RequestBody JugadorDTO jugadorDTO){
        Optional<JugadorEntity> jugadorUpdate = jugadorService.findById(id);

        if (jugadorUpdate.isPresent()){
            JugadorEntity jugador = jugadorUpdate.get();
            jugador.setNombre(jugadorDTO.getNombre());
            jugador.setNivel(jugadorDTO.getNivel());
            jugador.setBatallas(jugadorDTO.getBatallas());
            jugador.setVictorias(jugadorDTO.getVictorias());
            jugador.setDerrotas(jugadorDTO.getDerrotas());
            jugadorService.save(jugador);
            return ResponseEntity.ok("Se actualizo correctamente");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        if (id != null){
            //SE TIENE QUE LLAMAR AL SERVICE
            jugadorService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
