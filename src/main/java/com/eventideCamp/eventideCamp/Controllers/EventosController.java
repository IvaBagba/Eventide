package com.eventideCamp.eventideCamp.Controllers;

import com.eventideCamp.eventideCamp.Dto.EventosDto;
import com.eventideCamp.eventideCamp.Models.Evento;
import com.eventideCamp.eventideCamp.Services.EventosService;
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
    public Evento addEvento(@RequestBody Evento evento) {
        return eventosService.addEvento(evento);
    }
}
