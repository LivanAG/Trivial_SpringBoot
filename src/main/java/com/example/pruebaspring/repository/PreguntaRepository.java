package com.example.pruebaspring.repository;

import com.example.pruebaspring.model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
}
