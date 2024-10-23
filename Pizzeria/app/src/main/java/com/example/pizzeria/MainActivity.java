package com.example.pizzeria;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int precioTamanio =0;
    int precioIngredientes =0;
    int precioTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView tx = findViewById(R.id.Precio);
        RadioGroup rg = findViewById(R.id.GrupoRadio);
        final CheckBox ingrediente1 = findViewById(R.id.JamonYork);
        final CheckBox ingrediente2 = findViewById(R.id.Bacon);
        final CheckBox ingrediente3 = findViewById(R.id.Carne);
        final CheckBox ingrediente4 = findViewById(R.id.Cebolla);
        final CheckBox ingrediente5 = findViewById(R.id.Pimiento);
        final CheckBox ingrediente6 = findViewById(R.id.Aceitunas);
        final CheckBox ingrediente7 = findViewById(R.id.Anchoas);
        final CheckBox ingrediente8 = findViewById(R.id.Maiz);
        final CheckBox ingrediente9 = findViewById(R.id.Pinia);

        Button botonCalcularPrecio = findViewById(R.id.botonCalcularPrecio);



        botonCalcularPrecio.setOnClickListener(view ->{
             precioIngredientes = 0;
             precioTamanio =0;

            int checkedId = rg.getCheckedRadioButtonId();
            if (checkedId == R.id.radio1) {
                precioTamanio = 5;
            }
            if (checkedId == R.id.radio2) {
                precioTamanio = 10;
            }
            if (checkedId == R.id.radio3) {
                precioTamanio = 15;
            }

            if(ingrediente1.isChecked())precioIngredientes +=1;
            if(ingrediente2.isChecked())precioIngredientes +=1;
            if(ingrediente3.isChecked())precioIngredientes +=1;
            if(ingrediente4.isChecked())precioIngredientes +=2;
            if(ingrediente5.isChecked())precioIngredientes +=2;
            if(ingrediente6.isChecked())precioIngredientes +=2;
            if(ingrediente7.isChecked())precioIngredientes +=3;
            if(ingrediente8.isChecked())precioIngredientes +=3;
            if(ingrediente9.isChecked())precioIngredientes +=3;
            precioTotal = precioIngredientes + precioTamanio;
            tx.setText("El precio es: " + precioTotal);

                });












    }
}