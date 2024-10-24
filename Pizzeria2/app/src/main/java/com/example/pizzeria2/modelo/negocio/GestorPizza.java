package com.example.pizzeria2.modelo.negocio;

import com.example.pizzeria2.modelo.entidad.Ingrediente;
import com.example.pizzeria2.modelo.entidad.Pizza;

public class GestorPizza {
    public double calcularPizza(Pizza pizza){
        double precioBase =0;

        switch (pizza.getTamanioPizza()){
            case PEQUEÑO:
                precioBase =5;
                break;
            case MEDIANO:
                precioBase = 10;
                break;
            case GRANDE:
                precioBase =15;
                break;
        }
        for(Ingrediente ingrediente : pizza.getListaIngrediente()){
            precioBase+= ingrediente.getPrecio();
        }
        return precioBase;


    }
}
