package com.example.imagenes;

public class Anime {
    private String nombre;
    private String especie;
    private String genero;
    private String estatus;

    public Anime(String nombre, String especie, String genero, String estatus){
        this.nombre = nombre;
        this.especie = nombre;
        this.genero = nombre;
        this.estatus = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
