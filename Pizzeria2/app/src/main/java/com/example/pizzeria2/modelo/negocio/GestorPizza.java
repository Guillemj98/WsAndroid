package com.example.pizzeria2.modelo.negocio;

import com.example.pizzeria2.modelo.entidad.Ingrediente;
import com.example.pizzeria2.modelo.entidad.Pizza;
import com.example.pizzeria2.modelo.entidad.Tamanio;

public class GestorPizza {
    public void calcularPizza(Pizza pizza){
        double precioBase =0;

        if (pizza.getTamanioPizza() == Tamanio.PEQUENO) {
            precioBase = 5.0;
        } else if (pizza.getTamanioPizza() == Tamanio.MEDIANO) {
            precioBase = 10.0;
        } else if (pizza.getTamanioPizza() == Tamanio.GRANDE) {
            precioBase = 15.0;
        }
        for(Ingrediente ingrediente : pizza.getListaIngrediente()){
            precioBase+= ingrediente.getPrecio();
        }

        pizza.setPrecio(precioBase);




    }
}
