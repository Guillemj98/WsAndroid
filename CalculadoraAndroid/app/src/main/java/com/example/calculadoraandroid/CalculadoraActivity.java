package com.example.calculadoraandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculadoraandroid.modelo.negocio.GestorCalculadora;

public class CalculadoraActivity extends AppCompatActivity {

    private GestorCalculadora gestorCalculadora;
    private TextView pantallaCalculadora;
    private TextView nombreUsuario;
    private String input="";
    private double operando= 0;
    private String operador = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora);
        pantallaCalculadora = findViewById(R.id.resultTextView);
        nombreUsuario = findViewById(R.id.Usuario);



        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        if (nombre != null) {
            nombreUsuario.setText( "Bienvenido: " + nombre);
        } else {
            nombreUsuario.setText("Bienvenido");
        }



        //Botones de los numeros
        findViewById(R.id.button0).setOnClickListener(v -> agreggarNumero("0"));
        findViewById(R.id.button1).setOnClickListener(v -> agreggarNumero("1"));
        findViewById(R.id.button2).setOnClickListener(v -> agreggarNumero("2"));
        findViewById(R.id.button3).setOnClickListener(v -> agreggarNumero("3"));
        findViewById(R.id.button4).setOnClickListener(v -> agreggarNumero("4"));
        findViewById(R.id.button5).setOnClickListener(v -> agreggarNumero("5"));
        findViewById(R.id.button6).setOnClickListener(v -> agreggarNumero("6"));
        findViewById(R.id.button7).setOnClickListener(v -> agreggarNumero("7"));
        findViewById(R.id.button8).setOnClickListener(v -> agreggarNumero("8"));
        findViewById(R.id.button9).setOnClickListener(v -> agreggarNumero("9"));

        findViewById(R.id.buttonSumar).setOnClickListener(view -> {});
        findViewById(R.id.buttonMultiplicar).setOnClickListener(view -> {});
        findViewById(R.id.buttonDivision).setOnClickListener(view -> {});
        findViewById(R.id.buttonRestar).setOnClickListener(view -> {});
        findViewById(R.id.buttonClear).setOnClickListener(view -> {});

    }

    private void agreggarNumero(String number) {
        input+=number;
        pantallaCalculadora.setText(input);
    }
}