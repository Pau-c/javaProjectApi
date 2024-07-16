package com.codo.series.model;

public class SerieRequest {
    private String titulo;
    private Double puntuacion;
    private String portada;
    private String review;

    // Getters and Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    } 
}
