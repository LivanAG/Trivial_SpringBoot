package com.example.pruebaspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Partida {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPartida;
    private long jugador;

    private int puntuacion;
    private Date date;










    public Partida() {
        this.date = new Date();
    }

    public long getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(long idPartida) {
        this.idPartida = idPartida;
    }

    public long getJugador() {
        return jugador;
    }

    public void setJugador(long jugador) {
        this.jugador = jugador;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void sumarPunto(){
        this.puntuacion +=1;
    }

}
