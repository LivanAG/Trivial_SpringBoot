package com.example.pruebaspring.service;

import com.example.pruebaspring.model.Pregunta;
import com.example.pruebaspring.repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PreguntaService {


    @Autowired
    PreguntaRepository preguntaRepository;
    public List<Pregunta> verTodas(){

        return preguntaRepository.findAll();
    }

    public Pregunta getPreguntaConId(long id){
        return preguntaRepository.getReferenceById(id);
    }

    public List<Pregunta> obtenerPreguntasAleatorias(){

        // obtenemos todas las preguntas
        List <Pregunta> preguntas = preguntaRepository.findAll();

        // las desordenamos buscando aleatoriedad
        Collections.shuffle(preguntas);

        preguntas = preguntas.stream().limit(5).toList();

        for(Pregunta p : preguntas){
            if(p.getOpciones() != null){
                Collections.shuffle(p.getOpciones());
            }
        }


        return preguntas;
    }
}
