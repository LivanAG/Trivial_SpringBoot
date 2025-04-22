package com.example.pruebaspring.service;

import com.example.pruebaspring.model.Opcion;
import com.example.pruebaspring.repository.OpcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpcionService {

    @Autowired
    OpcionRepository opcionRepository;

    public Opcion getOpcionConId(long id){
        return opcionRepository.getReferenceById(id);
    }
}
