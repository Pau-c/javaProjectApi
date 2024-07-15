package com.example.demo.model;

import java.util.Date;

/**
 * Objeto que representa un fila de la tabla 
 */
public class Pelicula {
    private Integer id;
    private String titulo;
    private Date anio;
    private Double puntuacion;
    private String portada;
    private String review;
    
    public Pelicula(Integer id, String titulo, Date anio, Double puntuacion, String portada, String review) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.puntuacion = puntuacion;
        this.portada = portada;
        this.review = review;
    }
//for update method
    public Pelicula(Integer id, String titulo, Double puntuacion, String portada, String review) {
        this.id = id;
        this.titulo = titulo;
        this.puntuacion = puntuacion;
        this.portada = portada;
        this.review = review;
    }
    
    /**
     * Constructor que solo recibe 4 parámetros
     * @param titulo
     * @param puntuacion
     * @param portada
     * @param review
     */
    public Pelicula(String titulo, Double puntuacion, String portada, String review) {
        this.titulo = titulo;
        this.puntuacion = puntuacion;
        this.portada = portada;
        this.review = review;
    }



    public Pelicula(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String gettitulo() {
        return titulo;
    }

    public void settitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
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
