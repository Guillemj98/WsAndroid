package com.example.a00_appjava2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton1 = findViewById(R.id.boton1);
        EditText editText1 = findViewById(R.id.editText1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // El objeto view que entra por aqui será
                // el objeto que ha desencadenado el evento
                Log.i("MainActivity", "Boton 1 pulsado");
            }
        });
        Button boton2 = findViewById(R.id.boton2);
        boton2.setOnClickListener(view -> Log.i("MainActivity", "Boton 2 pulsado"));
        Button boton3 = findViewById(R.id.boton3);
        ListenerBoton lb = new ListenerBoton();
        boton3.setOnClickListener(lb);

        Button boton5 = findViewById(R.id.boton5);
        TextView tx1 = findViewById(R.id.textView1);

        boton5.setOnClickListener(view -> {
            String mensaje = editText1.getText().toString();
            tx1.setText(mensaje);
        });
    }
}