package com.eventideCamp.eventideCamp.Dto;

import com.eventideCamp.eventideCamp.Models.CursosTags;
import com.eventideCamp.eventideCamp.Models.EventStatus;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class EventosDto {

    //Nombre y Descripción
    @NotBlank(message = "El nombre no puede estar vacio")
    private String eventName;
    private String eventDesc;

    //Fecha y hora del evento
    @NotNull(message = "El campo Fecha no puede estar vacio")
    private LocalDate eventDate;
    @NotNull(message = "El campo Hora no puede estar vacio")
    private LocalTime eventTime;

    //Lugar del evento
    private String eventLocation;

    //Estados del evento
    @NotNull(message = "El estado del evento es OBLIGATORIO")
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

    //Crea una tabla secundaria que guarda las tags de cada 1 de los eventos
    // (ej: evento con id 1 tiene el campo cursosTags que es referenciado por otra tabla que contiene las tags que
    // tiene evento 1 ej: eso , bach)
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<CursosTags> cursosTags;
}
