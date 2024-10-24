package com.example.pizzeria2;

import android.content.Intent;
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

import com.example.pizzeria2.modelo.entidad.Ingrediente;
import com.example.pizzeria2.modelo.entidad.Pizza;
import com.example.pizzeria2.modelo.entidad.Tamanio;
import com.example.pizzeria2.modelo.negocio.GestorPizza;

public class PizzeriaActivity extends AppCompatActivity {
    private TextView nombreUsuario;
    private TextView direccionUsuario;
    int precioTamanio =0;
    int precioIngredientes =0;
    int precioTotal = 0;
    private CheckBox ingrediente1;
    private CheckBox ingrediente2;
    private CheckBox ingrediente3;
    private CheckBox ingrediente4;
    private CheckBox ingrediente5;
    private CheckBox ingrediente6;
    private CheckBox ingrediente7;
    private CheckBox ingrediente8;
    private CheckBox ingrediente9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        RadioGroup rg = findViewById(R.id.GrupoRadio);
         ingrediente1 = findViewById(R.id.JamonYork);
         ingrediente2 = findViewById(R.id.Bacon);
         ingrediente3 = findViewById(R.id.Carne);
         ingrediente4 = findViewById(R.id.Cebolla);
         ingrediente5 = findViewById(R.id.Pimiento);
         ingrediente6 = findViewById(R.id.Aceitunas);
         ingrediente7 = findViewById(R.id.Anchoas);
         ingrediente8 = findViewById(R.id.Maiz);
         ingrediente9 = findViewById(R.id.Pinia);

        Button pedirPizza = findViewById(R.id.hacerPedido);
        nombreUsuario = findViewById(R.id.Nombre);
        direccionUsuario = findViewById(R.id.direccion);
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String direccion = intent.getStringExtra("direccion");
        nombreUsuario.setText(nombre);
        direccionUsuario.setText(direccion);

        pedirPizza.setOnClickListener(view ->{
            Pizza pizza = new Pizza();
            pizza.setTamanioPizza(obtenerTamañoPizza(rg);
            agregarIngrediente(pizza);

        });


    }

    private void agregarIngrediente(Pizza pizza) {
        if (ingrediente1.isChecked()) pizza.agregarIngrediente(new Ingrediente("Jamón York", 1));
        if (ingrediente2.isChecked()) pizza.agregarIngrediente(new Ingrediente("Bacon", 1));
        if (ingrediente3.isChecked()) pizza.agregarIngrediente(new Ingrediente("Carne", 1));
        if (ingrediente4.isChecked()) pizza.agregarIngrediente(new Ingrediente("Cebolla", 2));
        if (ingrediente5.isChecked()) pizza.agregarIngrediente(new Ingrediente("Pimiento", 2));
        if (ingrediente6.isChecked()) pizza.agregarIngrediente(new Ingrediente("Aceitunas", 2));
        if (ingrediente7.isChecked()) pizza.agregarIngrediente(new Ingrediente("Anchoas", 3));
        if (ingrediente8.isChecked()) pizza.agregarIngrediente(new Ingrediente("Maíz", 3));
        if (ingrediente9.isChecked()) pizza.agregarIngrediente(new Ingrediente("Piña", 3));
    }

    private Tamanio obtenerTamañoPizza(RadioGroup rg) {

        int selectedId = rg.getCheckedRadioButtonId();
        switch (selectedId) {
            case R.id.radio1:
                return Tamanio.PEQUEÑO;
            case R.id.radio2:
                return Tamanio.MEDIANO;
            case R.id.radio3:
                return Tamanio.GRANDE;
            default:
                return null; // Sin selección, manejar el caso apropiadamente
        }
    }

}