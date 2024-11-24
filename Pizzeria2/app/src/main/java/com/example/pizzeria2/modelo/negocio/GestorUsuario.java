package com.example.pizzeria2.modelo.negocio;

import com.example.pizzeria2.modelo.entidad.Usuario;
import com.example.pizzeria2.modelo.persistencia.DaoUsuario;

public class GestorUsuario {
    private DaoUsuario daoUsuario;

    public GestorUsuario() {
        daoUsuario = DaoUsuario.getInstance(); // Accede a la instancia única
    }

    public int validarUsuario(Usuario u) {
        if (daoUsuario.getUsuarioByName(u)) {
            return 1;
        } else {
            return 0;
        }
    }

    public void guardarUsuario(Usuario u) {
        daoUsuario.registraUsuario(u);
    }
}
