package com.codo.series.model;

import java.util.Date;


 //Objeto que representa un fila de la tabla 
 
public class Serie {
    private Integer id;
    private String titulo;
    private Date anio;
    private Double puntuacion;
    private String portada;
    private String review;
    
    public Serie(Integer id, String titulo, Date anio, Double puntuacion, String portada, String review) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.puntuacion = puntuacion;
        this.portada = portada;
        this.review = review;
    }
//for update method
    public Serie(Integer id, String titulo, Double puntuacion, String portada, String review) {
        this.id = id;
        this.titulo = titulo;
        this.puntuacion = puntuacion;
        this.portada = portada;
        this.review = review;
    }
    
    /**
     * Constructor 4 parámetros
     * @param titulo
     * @param puntuacion
     * @param portada
     * @param review
     */
    public Serie(String titulo, Double puntuacion, String portada, String review) {
        this.titulo = titulo;
        this.puntuacion = puntuacion;
        this.portada = portada;
        this.review = review;
    }



    public Serie(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
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
