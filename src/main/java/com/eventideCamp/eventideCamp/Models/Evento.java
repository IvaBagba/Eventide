package com.eventideCamp.eventideCamp.Models;

import jakarta.persistence.*;
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

    //Valores Visibles
    private String eventName;
    private String eventDesc;

    private LocalDate eventDate;
    private LocalTime eventTime;

    private String eventLocation;

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
