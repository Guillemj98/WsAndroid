package com.example.pizzeria2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
        String nombre = intent.getStringExtra("nombre");
        String direccion = intent.getStringExtra("direccion");
        String tamanio = intent.getStringExtra("tamanio");
        double precio = intent.getDoubleExtra("precio", 0.0);
        ArrayList<String> ingredientes = intent.getStringArrayListExtra("ingredientes");


        tvNombreUsuario.setText("Nombre: " + nombre);
        tvDireccionUsuario.setText("Dirección: " + direccion);
        tvTamanioPizza.setText("Tamaño de la Pizza: " + tamanio);
        tvPrecioFinal.setText("Precio Final: " + precio + "€");


        StringBuilder ingredientesTexto = new StringBuilder();
        for (String ingrediente : ingredientes) {
            ingredientesTexto.append(ingrediente).append("\n");
        }
        tvIngredientes.setText("Ingredientes:\n" + ingredientesTexto.toString());


        btnPedidoProcesado.setOnClickListener(view -> {
            Toast.makeText(ConfirmacionActivity.this, "Pedido procesado", Toast.LENGTH_SHORT).show();
        });
    }


}
