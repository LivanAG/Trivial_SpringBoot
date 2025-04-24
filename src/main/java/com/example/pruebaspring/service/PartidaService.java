package com.example.pruebaspring.service;

import com.example.pruebaspring.dto.RankingDTO;
import com.example.pruebaspring.model.Partida;
import com.example.pruebaspring.model.Usuario;
import com.example.pruebaspring.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidaService {

    @Autowired
    PartidaRepository partidaRepository;

    public List<RankingDTO> primerasCincoPosiciones() {
        return partidaRepository.findTop5Promedios();
    }

    public Partida crearPartida(int p, Usuario u){
        Partida partida = new Partida();
        partida.setJugador(1);
        partida.setPuntuacion(p);
        partida.setJugador(u.getId());

        return partidaRepository.save(partida);
    }
}
