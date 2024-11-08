package com.example.calculadoraandroid.modelo.negocio;

public class GestorCalculadora {
    private static GestorCalculadora instance;


    private GestorCalculadora() {
    }


    public static GestorCalculadora getInstance() {
        if (instance == null) {
            instance = new GestorCalculadora();
        }
        return instance;
    }

    public Double sumar(double a , double b){

        return a + b;
    }
    public Double restar(double a , double b){

        return a - b;
    }
    public Double dividir(double a , double b){
        if(b ==0){
            throw new ArithmeticException("División entre cero no permitida");
    }
        return a / b;
    }
    public Double multiplicar(double a , double b){

        return a * b;
    }

}
