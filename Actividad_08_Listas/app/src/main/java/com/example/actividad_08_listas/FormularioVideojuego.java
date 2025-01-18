package com.example.actividad_08_listas;

import static android.icu.text.DateTimePatternGenerator.PatternInfo.OK;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.actividad_08_listas.entidad.Videojuego;
import com.example.actividad_08_listas.singletone.VideojuegoSingletone;

import java.util.Random;


public class FormularioVideojuego extends AppCompatActivity {
    private EditText editTextNombre;
    private EditText editTextCompania;
    private EditText editTextNota;

    private Button btnColor;
    private Button btnGuardar;
    public static final String VIDEOJUEGO = "videojuego";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextCompania= findViewById(R.id.editTextCompania);
        editTextNota = findViewById(R.id.editTextNota);

        btnColor = findViewById(R.id.buttonColor);
        btnGuardar = findViewById(R.id.buttonGuardar);

        Intent intent = getIntent();
        int videojuegoId = intent.getIntExtra("id",-1);
        cargarDatosVideojuego(videojuegoId);

        btnGuardar.setOnClickListener(v-> guardarVideojuego());

    }

    private void cargarDatosVideojuego(int videojuegoId) {
        VideojuegoSingletone v = VideojuegoSingletone.getInstance();
        for(Videojuego videojuego: v.getListaVideojuegos()){
            if(videojuego.getId() == videojuegoId){
                editTextNombre.setText(videojuego.getNombre());
                editTextCompania.setText(videojuego.getCompania());
                editTextNota.setText(String.valueOf(videojuego.getNota()));

                // Aqui supongo quye habra que poner los botones para que
                // cambiar el color del fondo o algo asi
            }
        }
    }

    private void guardarVideojuego() {
        Intent intent = new Intent();
        String nombre = editTextNombre.getText().toString().trim();
        String compania = editTextCompania.getText().toString().trim();
        double nota = Double.parseDouble(editTextNota.getText().toString().trim());

        if(nombre.isEmpty()|| compania.isEmpty()  ){
            Toast.makeText(this, "Los campos de nombre y compania son obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }
        VideojuegoSingletone videojuegoSingletone = VideojuegoSingletone.getInstance();
        Videojuego videojuego = new Videojuego();
        videojuego.setNombre(nombre);
        videojuego.setCompania(compania);
        videojuego.setNota((int) nota);
        videojuego.setId(new Random().nextInt(1000000));

        videojuegoSingletone.actualizarLista(videojuego);
        intent.putExtra(VIDEOJUEGO, videojuego);
        setResult(1, intent);
        finish();

    }


}
