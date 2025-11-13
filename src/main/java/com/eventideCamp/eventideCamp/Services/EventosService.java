package com.eventideCamp.eventideCamp.Services;

import com.eventideCamp.eventideCamp.Dto.EventosDto;
import com.eventideCamp.eventideCamp.Models.Evento;
import com.eventideCamp.eventideCamp.Repo.EventosRepository;
import jakarta.validation.Valid;
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

    public Evento addEvento(@Valid EventosDto eventoDto) {
        Evento evento = new Evento();
        evento.setEventName(eventoDto.getEventName());
        evento.setEventDesc(eventoDto.getEventDesc());
        evento.setEventDate(eventoDto.getEventDate());
        evento.setEventTime(eventoDto.getEventTime());
        evento.setEventLocation(eventoDto.getEventLocation());
        evento.setEventStatus(eventoDto.getEventStatus());
        evento.setCursosTags(eventoDto.getCursosTags());
        return eventosRepository.save(evento);
    }

    public Evento modEvento(Long id ,@Valid EventosDto eventoDto) {
        Evento eventoBase = eventosRepository.findById(id).get();
        eventoBase.setEventName(eventoDto.getEventName());
        eventoBase.setEventDesc(eventoDto.getEventDesc());
        eventoBase.setEventDate(eventoDto.getEventDate());
        eventoBase.setEventTime(eventoDto.getEventTime());
        eventoBase.setEventLocation(eventoDto.getEventLocation());
        eventoBase.setEventStatus(eventoDto.getEventStatus());
        eventoBase.setCursosTags(eventoDto.getCursosTags());
        return eventosRepository.save(eventoBase);
    }
}
