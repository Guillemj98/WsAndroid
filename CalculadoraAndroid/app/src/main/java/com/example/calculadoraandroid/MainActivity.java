package com.example.calculadoraandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculadoraandroid.modelo.negocio.GestorLogin;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        EditText etNombre = findViewById(R.id.nombreUsuario);
        Button botonLogin = findViewById(R.id.iniciar);
        // Hemos hecho el gestorLogin de manera singletone, esto quiere
        // decir que queremos que solo haya una sola instancia de esta clase
        // en toda la aplicacion
        GestorLogin gestorLogin = GestorLogin.getInstance();

        botonLogin.setOnClickListener(view -> {
            String usuario = etNombre.getText().toString().trim();

            if(gestorLogin.validarCredenciales(usuario)){
                Intent intent = new Intent(MainActivity.this,CalculadoraActivity.class);
                intent.putExtra("nombre",usuario);
                startActivity(intent);

            }else{
                Toast.makeText(MainActivity.this,"Usuario"+
                        " incorrecto",Toast.LENGTH_LONG).show();;
            }
        });

    }
}