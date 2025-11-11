package com.eventideCamp.eventideCamp.Repo;

import com.eventideCamp.eventideCamp.Models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventosRepository extends JpaRepository<Evento, Long> {
}
