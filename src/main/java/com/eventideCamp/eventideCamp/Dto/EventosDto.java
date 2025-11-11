package com.eventideCamp.eventideCamp.Dto;

import com.eventideCamp.eventideCamp.Models.CursosTags;
import com.eventideCamp.eventideCamp.Models.EventStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class EventosDto {

    private String eventName;
    private String eventDesc;

    private LocalDate eventDate;
    private LocalTime eventTime;

    private String eventLocation;

    private EventStatus eventStatus;
    private List<CursosTags> cursosTags;
}
