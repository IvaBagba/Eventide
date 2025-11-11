package com.eventideCamp.eventideCamp.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String event_name;
    private String event_desc;

    private LocalDate event_date;
    private LocalTime event_time;

    private String event_location;

    @Enumerated(EnumType.STRING)
    private EventStatus event_status;
}
