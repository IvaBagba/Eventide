package com.eventideCamp.eventideCamp.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Nombre y descripción del evento
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
    //Etiquetas Ocultas

}
