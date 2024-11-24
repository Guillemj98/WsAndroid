package com.example.pizzeria2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pizzeria2.modelo.entidad.Usuario;
import com.example.pizzeria2.modelo.negocio.GestorUsuario;

public class CrearseCuentaActivity extends AppCompatActivity {
    private Button botonVolver;
    private EditText nombre;
    private EditText password;
    private EditText direccion;

    public static final int OK = 0;
    public static final int KO = 1;
    public static final String USUARIO = "usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crearse_cuenta);

        botonVolver= findViewById(R.id.btnVueltaLogin);
        nombre = findViewById(R.id.NombreNuevo);
        password = findViewById(R.id.ContraseñaNueva);
        direccion = findViewById(R.id.DireccionNueva);

        botonVolver.setOnClickListener(view -> {
            Intent intent = new Intent();
            String nombreNuevo = nombre.getText().toString();
            String passwordNueva = password.getText().toString();
            String direccionNueva = direccion.getText().toString();

            if (nombreNuevo.matches("")||passwordNueva.matches("")||direccionNueva.matches("")){
                Log.v("CrearseCuentaActivity","Usuario, contraseña o direccion mal introducidos");
                setResult(KO);
            }else{
                Log.v("CrearseCuentaActivity", nombre.getText().toString());
                Log.v("CrearseCuentaActivity", password.getText().toString());
                Log.v("CrearseCuentaActivity", direccion.getText().toString());
                Usuario usuario = new Usuario();
                usuario.setNombre(nombreNuevo);
                usuario.setPassword(passwordNueva);
                usuario.setDireccion(direccionNueva);
                GestorUsuario gs = new GestorUsuario();
                gs.guardarUsuario(usuario);
                intent.putExtra(USUARIO, usuario);
                setResult(OK,intent);
            }
            finish();

        });

    }
}