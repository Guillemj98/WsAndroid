package com.example.calculadoraandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculadoraandroid.modelo.negocio.GestorCalculadora;

public class CalculadoraActivity extends AppCompatActivity {

    private GestorCalculadora gestorCalculadora;
    private TextView pantallaCalculadora;
    private TextView nombreUsuario;
    private String input = "";
    private double operando = 0;
    private String operador = "";
    private boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora);

        pantallaCalculadora = findViewById(R.id.resultTextView);
        nombreUsuario = findViewById(R.id.Usuario);
        gestorCalculadora = GestorCalculadora.getInstance();

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        if (nombre != null) {
            nombreUsuario.setText("Bienvenido: " + nombre);
        } else {
            nombreUsuario.setText("Bienvenido");
        }


        findViewById(R.id.button0).setOnClickListener(v -> agregarNumero("0"));
        findViewById(R.id.button1).setOnClickListener(v -> agregarNumero("1"));
        findViewById(R.id.button2).setOnClickListener(v -> agregarNumero("2"));
        findViewById(R.id.button3).setOnClickListener(v -> agregarNumero("3"));
        findViewById(R.id.button4).setOnClickListener(v -> agregarNumero("4"));
        findViewById(R.id.button5).setOnClickListener(v -> agregarNumero("5"));
        findViewById(R.id.button6).setOnClickListener(v -> agregarNumero("6"));
        findViewById(R.id.button7).setOnClickListener(v -> agregarNumero("7"));
        findViewById(R.id.button8).setOnClickListener(v -> agregarNumero("8"));
        findViewById(R.id.button9).setOnClickListener(v -> agregarNumero("9"));


        findViewById(R.id.buttonSumar).setOnClickListener(view -> agregarSimbolo("+"));
        findViewById(R.id.buttonMultiplicar).setOnClickListener(view -> agregarSimbolo("*"));
        findViewById(R.id.buttonDivision).setOnClickListener(view -> agregarSimbolo("/"));
        findViewById(R.id.buttonRestar).setOnClickListener(view -> agregarSimbolo("-"));


        findViewById(R.id.buttonClear).setOnClickListener(view -> limpiarPantalla());


        findViewById(R.id.buttonIgual).setOnClickListener(view -> calcularResultado());
    }

    private void limpiarPantalla() {
        input = "";
        operador = "";
        operando = 0;
        isNewOperation = true;
        pantallaCalculadora.setText("");
    }

    private void agregarSimbolo(String simbolo) {
        if (!input.isEmpty()) {
            operando = Double.parseDouble(input);
            operador = simbolo;
            input = "";
            isNewOperation = false;
            pantallaCalculadora.setText("");
        }
    }

    private void agregarNumero(String number) {
        if (isNewOperation) {
            input = "";
            isNewOperation = false;
        }
        input += number;
        pantallaCalculadora.setText(input);
    }

    private void calcularResultado() {
        if (operador.isEmpty() || input.isEmpty()) {
            return;
        }
        double segundoOperando = Double.parseDouble(input);
        double resultado = 0;

        try {
            switch (operador) {
                case "+":
                    resultado = gestorCalculadora.sumar(operando, segundoOperando);
                    break;
                case "-":
                    resultado = gestorCalculadora.restar(operando, segundoOperando);
                    break;
                case "*":
                    resultado = gestorCalculadora.multiplicar(operando, segundoOperando);
                    break;
                case "/":
                    resultado = gestorCalculadora.dividir(operando, segundoOperando);
                    break;
            }
            pantallaCalculadora.setText(String.valueOf(resultado));
            operando = resultado;
            input = String.valueOf(resultado);
            operador = "";
            isNewOperation = true;
        } catch (ArithmeticException e) {
            pantallaCalculadora.setText("Error");
            input = "";
            operador = "";
            isNewOperation = true;
        }
    }
}
