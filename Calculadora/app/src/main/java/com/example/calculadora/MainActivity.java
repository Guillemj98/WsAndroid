package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public EditText number1;
    public EditText number2;
    public TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1 = findViewById(R.id.Number1);
        number2 = findViewById(R.id.Number2);
        resultado = findViewById(R.id.resultado);



        //Listener del boton de sumar
        Button sumar = findViewById(R.id.Suma);
        sumar.setOnClickListener(view -> {
            sumar();
        });

        //Listener del boton de restar
        Button restar = findViewById(R.id.Resta);
        restar.setOnClickListener(view -> {
            restar();
        });

        //Listener del boton de dividir
        Button dividir = findViewById(R.id.Division);
        dividir.setOnClickListener(view -> {
            dividir();
        });

        //Listener del boton de multiplicar
        Button multiplicar = findViewById(R.id.Mutiplicacion);
        multiplicar.setOnClickListener(view -> {
           multiplicar();
        });

        //Listener del boton de potencia
        Button potencia = findViewById(R.id.Potencia);
        potencia.setOnClickListener(view -> {
            potencia();
        });

        //Listener del boton de borrar las cosas
        Button borrar = findViewById(R.id.Borrar);
        borrar.setOnClickListener(view -> {
            number1.setText("");
            number2.setText("");
            resultado.setText("");
        });


    }
    public Double sumar(){
        String numero1 = number1.getText().toString();
        String numero2 = number2.getText().toString();
        double resultadoSumar =0;
        if(numero2.isEmpty() || numero1.isEmpty()){
            Toast.makeText(this, "Por favor ingrese ambos números", Toast.LENGTH_SHORT).show();
        }else{
            double num1 = Double.parseDouble(numero1);
            double num2 = Double.parseDouble(numero2);
            resultadoSumar = num1 + num2;
            resultado.setText("El resultado es: " + resultadoSumar);
        }
        return resultadoSumar;

    }
    public Double restar(){
        String numero1 = number1.getText().toString();
        String numero2 = number2.getText().toString();
        double resultadoResta =0;
        if(numero1.isEmpty() || numero2.isEmpty()){
            Toast.makeText(this, "Por favor ingrese ambos números", Toast.LENGTH_SHORT).show();
        }else{
            double num1 = Double.parseDouble(numero1);
            double num2 = Double.parseDouble(numero2);
            resultadoResta = num1 - num2;
            resultado.setText("El resultado es: " + resultadoResta);
        }
        return resultadoResta;
    }
    public Double dividir(){
        String numero1 = number1.getText().toString();
        String numero2 = number2.getText().toString();
        double resultadoDivision =0;
        if(numero1.isEmpty() || numero2.isEmpty()){
            Toast.makeText(this, "Por favor ingrese ambos números", Toast.LENGTH_SHORT).show();
        }else{
            double num1 = Double.parseDouble(numero1);
            double num2 = Double.parseDouble(numero2);
            resultadoDivision = num1 / num2;
            resultado.setText("El resultado es: " + resultadoDivision);
        }
        return resultadoDivision;
    }
    public Double multiplicar(){
        String numero1 = number1.getText().toString();
        String numero2 = number2.getText().toString();
        double resultadoMultiplicacion =0;
        if(numero1.isEmpty() || numero2.isEmpty()){
            Toast.makeText(this, "Por favor ingrese ambos números", Toast.LENGTH_SHORT).show();
        }else{
            double num1 = Double.parseDouble(numero1);
            double num2 = Double.parseDouble(numero2);
            resultadoMultiplicacion = num1 - num2;
            resultado.setText("El resultado es: " + resultadoMultiplicacion);
        }
        return resultadoMultiplicacion;
    }
    public Double potencia(){
        String numero1 = number1.getText().toString();
        String numero2 = number2.getText().toString();
        double resultadoPotencia =0;
        if(numero1.isEmpty() || numero2.isEmpty()){
            Toast.makeText(this, "Por favor ingrese ambos números", Toast.LENGTH_SHORT).show();
        }else{
            double num1 = Double.parseDouble(numero1);
            double num2 = Double.parseDouble(numero2);
            resultadoPotencia = num1 - num2;
            resultado.setText("El resultado es: " + resultadoPotencia);
        }
        return resultadoPotencia;
    }
}