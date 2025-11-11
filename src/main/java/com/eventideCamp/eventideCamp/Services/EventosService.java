package com.eventideCamp.eventideCamp.Services;

import com.eventideCamp.eventideCamp.Dto.EventosDto;
import com.eventideCamp.eventideCamp.Models.Evento;
import com.eventideCamp.eventideCamp.Repo.EventosRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EventosService {

    private final EventosRepository eventosRepository;

    public EventosService(EventosRepository eventosRepository) {
        this.eventosRepository = eventosRepository;
    }

    public List<EventosDto> getAllEventos() {

        List<Evento> eventos = eventosRepository.findAll();
        List<EventosDto> eventosDtos = new ArrayList<>();

        for (Evento evento : eventos) {
            EventosDto eventosDto = new EventosDto();
            eventosDto.setEventName(evento.getEventName());
            eventosDto.setEventDesc(evento.getEventDesc());
            eventosDto.setEventDate(evento.getEventDate());
            eventosDto.setEventTime(evento.getEventTime());
            eventosDto.setEventLocation(evento.getEventLocation());
            eventosDto.setEventStatus(evento.getEventStatus());

            eventosDto.setCursosTags(evento.getCursosTags());

            eventosDtos.add(eventosDto);
        }

        return eventosDtos;
    }

    public Evento addEvento(Evento evento) {
        return eventosRepository.save(evento);
    }
}
