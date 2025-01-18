package com.example.actividad_08_listas.singletone;

import com.example.actividad_08_listas.entidad.Videojuego;

import java.util.ArrayList;
import java.util.List;

public class VideojuegoSingletone {
    private static VideojuegoSingletone instace;
    private List<Videojuego>listaVideojuegos;

    private VideojuegoSingletone(){
        listaVideojuegos = new ArrayList<Videojuego>();
    }

    public static VideojuegoSingletone getInstance(){
        if(instace == null){
            instace = new VideojuegoSingletone();
        }
        return instace;
    }

    public List<Videojuego> getListaVideojuegos() {
        return listaVideojuegos;
    }

    public void agregarVideojuego(Videojuego videojuego){
        listaVideojuegos.add(videojuego);
    }

    public void eliminarVideojuego(int id){
        listaVideojuegos.removeIf(v -> v.getId() == id);

    }
    public void actualizarLista(Videojuego videojuego){
        for(int i =0; i<listaVideojuegos.size(); i++){
            if(listaVideojuegos.get(i).getId() == videojuego.getId()){
                listaVideojuegos.set(i, videojuego);
                return;
            }
        }
    }

}
