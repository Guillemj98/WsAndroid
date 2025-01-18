package com.example.actividad_08_listas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actividad_08_listas.adaptador.VideojuegoAdaptador;
import com.example.actividad_08_listas.entidad.Videojuego;
import com.example.actividad_08_listas.singletone.VideojuegoSingletone;

public class MainActivity extends AppCompatActivity {

    public static final String VIDEOJUEGO = "videojuego";
    private RecyclerView recyclerView;
    private VideojuegoAdaptador videojuegoAdaptador;
    private Button botonSegunda;

    private final ActivityResultLauncher<Intent> startForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {

                if (result.getResultCode() == 1) {
                    Intent intent = result.getData();
                    if(intent !=null){
                        Videojuego videojuego = (Videojuego)intent.getSerializableExtra(FormularioVideojuego.VIDEOJUEGO);
                        if(videojuego !=null){
                            VideojuegoSingletone.getInstance().agregarVideojuego(videojuego);
                            videojuegoAdaptador.notifyDataSetChanged();
                        }else{
                            Toast.makeText(MainActivity.this, "Error al recibir los datos del videojuego", Toast.LENGTH_SHORT).show();

                        }

                    }

                }
            }
    );



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerViewVideojuegos);
        botonSegunda = findViewById(R.id.buttonAgregar);

        // Añadimos esta linea que lo que hace es mejorar el rendiemiento
        // si sabemos que no va a afectar el tamaño del RecyclerView
        recyclerView.setHasFixedSize(true);

        //Nuestro RecyclerView usará unn linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        videojuegoAdaptador = new VideojuegoAdaptador(VideojuegoSingletone.getInstance().getListaVideojuegos());
        recyclerView.setAdapter(videojuegoAdaptador);

        botonSegunda.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, FormularioVideojuego.class);
            startForResult.launch(intent);
        });


    }
    @Override
    protected void onResume() {
        super.onResume();
        //Este método notifica que el conjunto de datos de la lista ha cambiado y que hay
        //que refrescarla
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}