package com.example.pizzeria2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pizzeria2.modelo.entidad.Usuario;
import com.example.pizzeria2.modelo.negocio.GestorUsuario;
import com.example.pizzeria2.modelo.persistencia.DaoUsuario;

public class MainActivity extends AppCompatActivity {

    private EditText nombre ;
    private EditText password;

    private Button botonLogin;

    private GestorUsuario gestorUsuario;
    public static final String K_USUARIO = "usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        gestorUsuario = new GestorUsuario();
        nombre = findViewById(R.id.Nombre);
        password = findViewById((R.id.Password));

        botonLogin = findViewById(R.id.botonLogin);

        botonLogin.setOnClickListener(view -> {
            Usuario u = new Usuario();
            u.setNombre(nombre.getText().toString());
            u.setPassword(password.getText().toString());
            if(gestorUsuario.validarUsuario(u)==1){
                Intent intent = new Intent(MainActivity.this, PizzeriaActivity.class);
                intent.putExtra(K_USUARIO, u);
                startActivity(intent);

            }else{
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }


        });


    }
}