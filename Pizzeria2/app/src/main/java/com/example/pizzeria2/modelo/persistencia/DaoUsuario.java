package com.example.pizzeria2.modelo.persistencia;

import android.util.Log;

import com.example.pizzeria2.modelo.entidad.Usuario;

import java.util.ArrayList;

public class DaoUsuario {
    ArrayList<Usuario>listaUsuarios = new ArrayList<Usuario>();

    public void registraUsuario(){
        Usuario usuario1 = new Usuario("Manolo","1234","Calle Perico");
        Usuario usuario2 = new Usuario("Pepe","12345","Calle Doha");
        Usuario usuario3 = new Usuario("Daniel","123456","Calle Lituania");
        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
        listaUsuarios.add(usuario3);

    }
    public Boolean getUsuarioByName(Usuario u){
        registraUsuario();
       for(Usuario user : listaUsuarios){
           if(user.equals(u)){
               return true;
           }
       }
        Log.i("Mensaje de error", "Error el usuario o la contraseña no esta");
       return false;
    }







}
