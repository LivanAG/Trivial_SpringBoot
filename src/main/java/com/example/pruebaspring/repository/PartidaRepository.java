package com.example.pruebaspring.repository;


import com.example.pruebaspring.dto.RankingDTO;
import com.example.pruebaspring.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartidaRepository extends JpaRepository<Partida, Long>{

    @Query(value = """
    SELECT u.username AS jugador, AVG(p.puntuacion) AS puntuacion, COUNT(p.id_partida) AS noPartidas
    FROM partida p
    JOIN usuario u ON p.jugador = u.id
    GROUP BY u.id, u.nombre, u.username
    ORDER BY puntuacion DESC
    LIMIT 5
""", nativeQuery = true)
    List<RankingDTO> findTop5Promedios();

}
