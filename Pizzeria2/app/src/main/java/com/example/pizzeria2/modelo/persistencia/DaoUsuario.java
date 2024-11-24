package com.example.pizzeria2.modelo.persistencia;

import android.util.Log;

import com.example.pizzeria2.modelo.entidad.Usuario;

import java.util.ArrayList;
public class DaoUsuario {
    private static DaoUsuario instance;
    private ArrayList<Usuario> listaUsuarios;

    // Constructor privado
    private DaoUsuario() {
        listaUsuarios = new ArrayList<>();
    }

    // Método para obtener la instancia única
    public static DaoUsuario getInstance() {
        if (instance == null) {
            instance = new DaoUsuario();
        }
        return instance;
    }

    public void registraUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public boolean getUsuarioByName(Usuario u) {
        for (Usuario user : listaUsuarios) {
            if (user.getNombre().equals(u.getNombre()) &&
                    user.getPassword().equals(u.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
}

