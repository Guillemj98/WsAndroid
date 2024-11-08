package com.example.pizzeria2.modelo.negocio;

import com.example.pizzeria2.modelo.entidad.Usuario;
import com.example.pizzeria2.modelo.persistencia.DaoUsuario;

public class GestorUsuario {
    private DaoUsuario daoUsuario ;

    public int validarUsuario(Usuario u){
        daoUsuario = new DaoUsuario();
        if(daoUsuario.getUsuarioByName(u)){
            return 1;
        }else{
            return 0;
        }

    }

}
