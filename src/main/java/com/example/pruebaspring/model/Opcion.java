package com.example.pruebaspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //anotacion para indicar que es una tabla
public class Opcion {
    @Id //anotación para indicar que el siguiente atributo es una clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOpcion;
    private String enunciado;
    private boolean esCorrecta;
    private Long idPregunta;

    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Long getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Long idOpcion) {
        this.idOpcion = idOpcion;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public boolean isEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }
}
