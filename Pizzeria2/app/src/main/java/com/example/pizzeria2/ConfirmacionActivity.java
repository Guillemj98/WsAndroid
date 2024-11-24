package com.example.pizzeria2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzeria2.modelo.entidad.Ingrediente;
import com.example.pizzeria2.modelo.entidad.Pizza;
import com.example.pizzeria2.modelo.entidad.Usuario;

import java.util.ArrayList;

public class ConfirmacionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);
        TextView tvNombreUsuario = findViewById(R.id.tvNombreUsuario);
        TextView tvDireccionUsuario = findViewById(R.id.tvDireccionUsuario);
        TextView tvTamanioPizza = findViewById(R.id.tvTamanioPizza);
        TextView tvIngredientes = findViewById(R.id.tvIngredientes);
        TextView tvPrecioFinal = findViewById(R.id.tvPrecioFinal);
        Button btnPedidoProcesado = findViewById(R.id.btnPedidoProcesado);


        Intent intent = getIntent();
        Usuario usuario = (Usuario) intent.getSerializableExtra("usuario");
        Pizza pizza = (Pizza) intent.getSerializableExtra("pizza");
        if (usuario == null || pizza == null) {
            Toast.makeText(this, "Error: No se pudo cargar la información.", Toast.LENGTH_SHORT).show();
            return;
        }


        tvNombreUsuario.setText("Nombre: " + usuario.getNombre());
        tvDireccionUsuario.setText("Dirección: " + usuario.getDireccion());
        tvTamanioPizza.setText("Tamaño de la Pizza: " + pizza.getTamanioPizza());
        tvPrecioFinal.setText("Precio Final: " + pizza.getPrecio() + "€");


        StringBuilder ingredientesTexto = new StringBuilder();
        for (Ingrediente ingrediente : pizza.getListaIngrediente()) {
            ingredientesTexto.append(ingrediente.getNombre()).append("\n");
        }
        tvIngredientes.setText("Ingredientes:\n" + ingredientesTexto.toString());



        btnPedidoProcesado.setOnClickListener(view -> {
            Toast.makeText(ConfirmacionActivity.this, "Pedido procesado", Toast.LENGTH_SHORT).show();
        });
    }


}
