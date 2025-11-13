package com.eventideCamp.eventideCamp.Controllers;

import com.eventideCamp.eventideCamp.Dto.EventosDto;
import com.eventideCamp.eventideCamp.Models.Evento;
import com.eventideCamp.eventideCamp.Services.EventosService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")

public class EventosController {

    private final EventosService eventosService;

    public EventosController(EventosService eventosService) {
        this.eventosService = eventosService;
    }

    @GetMapping("/allEventos")
    public ResponseEntity<List<EventosDto>> getAllEventos() {
        return ResponseEntity.ok(eventosService.getAllEventos());
    }

    @PostMapping("/addEvento")
    public Evento addEvento(@RequestBody @Valid EventosDto eventoDto) {
        return eventosService.addEvento(eventoDto);
    }

    @PutMapping("/modEvento/{id}")
    public Evento updateEvento(
            //Variable en la ruta web {id}
            @PathVariable Long id ,
            //Body de los cambios del evento (Debe de ser valido)
            @RequestBody @Valid EventosDto eventoDto) {
        return eventosService.modEvento(id, eventoDto);
    }
}
