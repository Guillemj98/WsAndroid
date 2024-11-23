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
    private TextView mensaje;
    private Button botonLogin;
    private String mensajeUsuario;

    private GestorUsuario gestorUsuario;
    public static final String K_USUARIO = "usuario";
    private final static String CLAVE_MENSAJE = "CALVE_MENSAJE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Ciclo de vida","OnCreate Ejecutandose");

        setContentView(R.layout.activity_main);

        gestorUsuario = new GestorUsuario();
        nombre = findViewById(R.id.Nombre);
        password = findViewById((R.id.Password));
        botonLogin = findViewById(R.id.botonLogin);
        mensaje = findViewById(R.id.Mensaje);

        if(savedInstanceState!=null){
            mensajeUsuario = savedInstanceState.getString(CLAVE_MENSAJE);
        }else{
            mensajeUsuario="";
        }
        mensaje.setText(mensajeUsuario);




    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        Log.d("MainActivity", "onSaveInstanceState()");
        outState.putString(CLAVE_MENSAJE, mensajeUsuario);
    }

    @Override
    protected void onStart() {
        super.onStart();
        botonLogin.setOnClickListener(view -> {
            Usuario u = new Usuario();
            u.setNombre(nombre.getText().toString());
            u.setPassword(password.getText().toString());
            if(gestorUsuario.validarUsuario(u)==1){
                Intent intent = new Intent(MainActivity.this, PizzeriaActivity.class);
                intent.putExtra(K_USUARIO, u);
                startActivity(intent);

            }else{
                mensajeUsuario= "Usuario o contraseña incorrectos";
                mensaje.setText(mensajeUsuario);
            }


        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Ciclo de vida","OnStop Ejecutandose");
    }

    @Override
    protected void onResume() {
        Log.d("Ciclo de vida","OnResume Ejecutandose");
        super.onResume();
    }
}