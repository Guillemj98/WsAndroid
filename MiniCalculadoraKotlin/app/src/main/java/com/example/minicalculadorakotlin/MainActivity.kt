package com.example.minicalculadorakotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bSuma = findViewById<Button>(R.id.Suma);
        var bResta = findViewById<Button>(R.id.Resta);
        var bDividir = findViewById<Button>(R.id.Division);
        var bMultiplicar = findViewById<Button>(R.id.Mutiplicacion);
        var bPotencia = findViewById<Button>(R.id.Borrar)
        var bDelete = findViewById<Button>(R.id.Borrar);
        var numero1 = findViewById<EditText>(R.id.Number1)
        var numero2 = findViewById<EditText>(R.id.Number2)
        var resultado = findViewById<TextView>(R.id.resultado)

        bSuma.setOnClickListener( {
            var n1 = numero1.text.toString();
            var n2 = numero2.text.toString();
            var numeroInt1 = n1.toDouble();
            var numeroInt2 = n2.toDouble();

            var suma = numeroInt1 + numeroInt2;
            resultado.text = "El resultado de la suma es: $suma"
        })

        bResta.setOnClickListener({
            var n1 = numero1.text.toString();
            var n2 = numero2.text.toString();
            var numeroInt1 = n1.toDouble();
            var numeroInt2 = n2.toDouble();

            var resta = numeroInt1 - numeroInt2;
            resultado.text = "El resultado de la suma es: $resta"

        })

        bDividir.setOnClickListener({
            var n1 = numero1.text.toString();
            var n2 = numero2.text.toString();
            var numeroInt1 = n1.toDouble();
            var numeroInt2 = n2.toDouble();

            var dividir = numeroInt1 / numeroInt2;
            resultado.text = "El resultado de la suma es: $dividir"

        })

        bMultiplicar.setOnClickListener({
            var n1 = numero1.text.toString();
            var n2 = numero2.text.toString();
            var numeroInt1 = n1.toDouble();
            var numeroInt2 = n2.toDouble();

            var multiplicar = numeroInt1 * numeroInt2;
            resultado.text = "El resultado de la suma es: $multiplicar"

        })
        bPotencia.setOnClickListener({
            var n1 = numero1.text.toString();
            var n2 = numero2.text.toString();
            var numeroInt1 = n1.toDouble();
            var numeroInt2 = n2.toDouble();

            var potencia = Math.pow(numeroInt1, numeroInt2);
            resultado.text = "El resultado de la suma es: $potencia"
        })

        bDelete.setOnClickListener({
            numero1.setText("")
            numero2.setText("")
            resultado.setText("")

        })






























    }
}