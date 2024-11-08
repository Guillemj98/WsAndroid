package com.example.calculadoraandroid.modelo.negocio;

import androidx.appcompat.app.AppCompatActivity;

public class GestorLogin extends AppCompatActivity {

    private static GestorLogin instance;


    private GestorLogin() {
    }


    public static GestorLogin getInstance() {
        if (instance == null) {
            instance = new GestorLogin();
        }
        return instance;
    }

    public boolean validarCredenciales(String username) {
        return username != null && !username.trim().isEmpty();
    }
}
