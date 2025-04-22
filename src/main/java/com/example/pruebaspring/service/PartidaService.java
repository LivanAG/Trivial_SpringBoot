package com.example.pruebaspring.service;

import com.example.pruebaspring.model.Partida;
import com.example.pruebaspring.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidaService {

    @Autowired
    PartidaRepository partidaRepository;

    public Partida crearPartida(int p){
        Partida partida = new Partida();
        partida.setJugador("Livan");
        partida.setPuntuacion(p);

        return partidaRepository.save(partida);
    }
}
