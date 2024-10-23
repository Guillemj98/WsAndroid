package com.example.a00_appkotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Para extender de las clases en Kotlin se pone :
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var user = Usuario();
        // realmente esta invocando al setter
        user.nombre = "Guillermo"
        user.password = "1234"

        // Para invocar el metodo get usamos user.nombre y no lo igualamos
        // a nada no como arriba
        Log.d("MainActivity", "Nombre" + user.nombre)
        val boton1 = findViewById<Button>(R.id.boton1);
        val boton2 : Button = findViewById(R.id.boton2);
        boton1.setOnClickListener({
            Log.d("MainActivity", "has pulsaado el boton 1")
        })
        boton2.setOnClickListener{v->
            Log.d("MainActivity", "Has pulsado el boton 2" + v.toString())
            Log.d("MainActivity", "Es otra linea")
        }
    }
}