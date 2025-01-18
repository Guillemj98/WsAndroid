package com.example.actividad_08_listas.adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actividad_08_listas.FormularioVideojuego;
import com.example.actividad_08_listas.R;
import com.example.actividad_08_listas.entidad.Videojuego;
import com.example.actividad_08_listas.singletone.VideojuegoSingletone;

import java.util.List;

public class VideojuegoAdaptador extends RecyclerView.Adapter<VideojuegoAdaptador.ViewHolder> {

    private List<Videojuego>listaVideojuegos;

    public VideojuegoAdaptador(List<Videojuego> listaVideojuegos){
        this.listaVideojuegos = listaVideojuegos;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView id;
        private TextView nombre;
        private TextView compania;
        private TextView nota;
        private Button botonEditar;
        private Button botonEliminar;

        public ViewHolder( View v) {
            super(v);
            id = v.findViewById(R.id.idVideojuego);
            nombre = v.findViewById(R.id.nombreVideojuego);
            compania = v.findViewById(R.id.companiaVideojuego);
            nota = v.findViewById(R.id.notaVideojuego);

            botonEditar = v.findViewById(R.id.btnEditarVideojuego);
            botonEliminar = v.findViewById(R.id.btnEliminarUsuario);

        }
    }

    // Este sera el que devuelve el ViewHolder con el layout seteado que previamente definimos
    @NonNull
    @Override
    public VideojuegoAdaptador.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.videojuego_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    // Este se encarga de establecer los objetos en el ViewHolder
    @Override
    public void onBindViewHolder( VideojuegoAdaptador.ViewHolder holder, int position) {
        Videojuego videojuego = listaVideojuegos.get(position);
        String sId = String.valueOf(listaVideojuegos.get(position).getId());
        holder.id.setText(sId);
        holder.nombre.setText(listaVideojuegos.get(position).getNombre());
        holder.compania.setText(listaVideojuegos.get(position).getCompania());
        String sNota = String.valueOf(listaVideojuegos.get(position).getNota());
        holder.nota.setText(sNota);

        // Ahora tendremos que establecer las funcionalidades de los botones que en este caso son
        // Editar un videojuego y Eliminar un videojuego

        // Dentro del boton de editar tendremos que abrir otra actividad para editarlo
        // Dentro del boton de eliminar podemos invocar el metodo que tenemos de eliminar

        holder.botonEliminar.setOnClickListener(view -> {
            Toast.makeText(holder.id.getContext(), "Editar videojuego"+ sId, Toast.LENGTH_LONG).show();
            VideojuegoSingletone.getInstance().eliminarVideojuego(videojuego.getId());
            notifyItemRemoved(position);
        });

        holder.botonEditar.setOnClickListener(view -> {
            Context context = view.getContext();
            Intent intent = new Intent(context, FormularioVideojuego.class);
            intent.putExtra("id", videojuego.getId());
            context.startActivity(intent);
        });

    }

    // Sera quien se encargue de devolver la cantidad de items que se encuentran en la lista
    @Override
    public int getItemCount() {
        return listaVideojuegos.size();
    }
}
