package com.example.pizzeria2.modelo.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Pizza implements Serializable {
    private Tamanio tamanioPizza;
    private double precio;
    private ArrayList<Ingrediente> listaIngrediente;

    public Pizza() {

    }

    public Tamanio getTamanioPizza() {
        return tamanioPizza;
    }

    public void setTamanioPizza(Tamanio tamanioPizza) {
        this.tamanioPizza = tamanioPizza;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {

        this.precio = precio;
    }

    public ArrayList<Ingrediente> getListaIngrediente() {
        return listaIngrediente;
    }

    public void setListaIngrediente(ArrayList<Ingrediente> listaIngrediente) {
        this.listaIngrediente = listaIngrediente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Double.compare(precio, pizza.precio) == 0 && tamanioPizza == pizza.tamanioPizza && Objects.equals(listaIngrediente, pizza.listaIngrediente);
    }



    public Pizza(Tamanio tamanioPizza, double precio, ArrayList<Ingrediente> listaIngrediente) {
        this.tamanioPizza = tamanioPizza;
        this.precio = precio;
        this.listaIngrediente = listaIngrediente;
    }
    public void agregarIngrediente(Ingrediente ingrediente) {
        listaIngrediente.add(ingrediente);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "tamanioPizza=" + tamanioPizza +
                ", precio=" + precio +
                ", listaIngrediente=" + listaIngrediente +
                '}';
    }
}
