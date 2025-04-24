package com.example.pruebaspring.dto;

public interface RankingDTO {

    String getNombre();       // nombre completo del jugador (ej: "Juan Pérez")
    String getJugador();      // username (ej: "juan123")
    double getPuntuacion();   // promedio
    int getNoPartidas();      // cantidad de partidas jugadas
}
