package com.example.pizzeria2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pizzeria2.modelo.entidad.Usuario;
import com.example.pizzeria2.modelo.negocio.GestorUsuario;

public class MainActivity extends AppCompatActivity {
    private EditText nombre ;
    private EditText password;
    private EditText direccion;
    private Button botonLogin;
    private TextView error;
    private GestorUsuario gestorUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestorUsuario = new GestorUsuario();
        nombre = findViewById(R.id.Nombre);
        password = findViewById((R.id.Password));
        direccion =findViewById(R.id.DireccionUsuario);
        error = findViewById(R.id.Error);
        botonLogin = findViewById(R.id.botonLogin);


        botonLogin.setOnClickListener(view -> {


            String nombre1 = nombre.getText().toString();
            String password1 = password.getText().toString();
            String direccion1 = direccion.getText().toString();


            Usuario u1 = new Usuario(nombre1, password1,direccion1);
            int resultado = gestorUsuario.validarUsuario(u1);
            switch (resultado){
                case 0:
                    Log.i("Warning","Usuario no encontrado");
                    error.setText("Error");
                    break;
                case 1:
                    Log.i("","Usuario y Password encontrado");
                    Intent intent = new Intent(MainActivity.this, PizzeriaActivity.class);
                    intent.putExtra("nombre", u1.getNombre());
                    intent.putExtra("direccion",u1.getDireccion());
                    startActivity(intent);
                    break;
                case 2:
                    Log.i("","Password Incorrecta");
                    break;
                case 666:
                    Log.i("Warning", "Excepcion");
            }



        });


    }
}