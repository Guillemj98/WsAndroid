package com.example.pizzeria2.modelo.negocio;

import com.example.pizzeria2.modelo.entidad.Usuario;
import com.example.pizzeria2.modelo.persistencia.DaoUsuario;

public class GestorUsuario {
    private DaoUsuario daoUsuario ;

    public int validarUsuario(Usuario u){
        daoUsuario = new DaoUsuario();
        try {
            Usuario uPersistencia = daoUsuario.getUsuarioByName(u.getNombre());
            if(uPersistencia == null){
                return 0;
            }
            if(uPersistencia.equals(u)){
                return 1;
            }else{
                return 2;
            }
        }catch (Exception e){
            return 666;
        }
    }

}
