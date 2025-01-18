package com.example.actividad_08_listas.entidad;

import java.io.Serializable;

public class Videojuego implements Serializable {
    private int id;
    private String nombre;
    private String compania;
    private int colorFondo;
    private int nota;

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public int getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(int colorFondo) {
        this.colorFondo = colorFondo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "colorFondo=" + colorFondo +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", compania='" + compania + '\'' +
                ", nota=" + nota +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
