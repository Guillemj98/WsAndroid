package com.example.pizzeria2;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pizzeria2.modelo.entidad.Ingrediente;
import com.example.pizzeria2.modelo.entidad.Pizza;
import com.example.pizzeria2.modelo.entidad.Tamanio;
import com.example.pizzeria2.modelo.entidad.Usuario;
import com.example.pizzeria2.modelo.negocio.GestorPizza;

import java.util.ArrayList;

public class PizzeriaActivity extends AppCompatActivity {
    public final static String K_USUARIO = "usuario";
    private CheckBox ingrediente1;
    private CheckBox ingrediente2;
    private CheckBox ingrediente3;
    private CheckBox ingrediente4;
    private CheckBox ingrediente5;
    private CheckBox ingrediente6;
    private CheckBox ingrediente7;
    private CheckBox ingrediente8;
    private CheckBox ingrediente9;

    Pizza pizza;
    ArrayList<Ingrediente> listaIngrediente = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Usuario usuario = (Usuario)getIntent().getSerializableExtra(MainActivity.K_USUARIO);
        Log.d("PizzeriActivity", "usuario".toString());
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pizzeria);



         RadioGroup rg = findViewById(R.id.GrupoRadio);

         String tamanioPizza = null;
         ArrayList<Ingrediente>listaIngredientes = new ArrayList<>();
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

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String direccion = intent.getStringExtra("direccion");
        Log.d("PizzeriaActivity", "Nombre: " + nombre);
        Log.d("PizzeriaActivity", "Dirección: " + direccion);

        GestorPizza gp = new GestorPizza();

        pedirPizza.setOnClickListener(view ->{
            pizza = new Pizza();

            Log.i("pizzeriaActivity", String.valueOf(pizza));
            agregarIngrediente(pizza);
            int tamanioIndex = obtenerTamañoPizza(rg);
            if (tamanioIndex != -1) {
               Tamanio tamanioSeleccionado = Tamanio.values()[tamanioIndex];
               pizza.setTamanioPizza(tamanioSeleccionado);
               gp.calcularPizza(pizza);
               Log.d("pizza", String.valueOf(pizza.getPrecio()));
                Intent intent2 = new Intent(PizzeriaActivity.this, ConfirmacionActivity.class);
                intent2.putExtra("nombre", nombre);
                intent2.putExtra("direccion", direccion);
                intent2.putExtra("tamanio", tamanioSeleccionado.toString());
                intent2.putExtra("precio", pizza.getPrecio());


                ArrayList<String> nombresIngredientes = new ArrayList<>();
                for (Ingrediente ingrediente : pizza.getListaIngrediente()) {
                    nombresIngredientes.add(ingrediente.getNombre());
                }
                intent2.putStringArrayListExtra("ingredientes", nombresIngredientes);

                startActivity(intent2);

            }else{
                Toast.makeText(PizzeriaActivity.this, "Por favor, seleccione un tamaño de pizza", Toast.LENGTH_SHORT).show();
            }


            pizza.setListaIngrediente(listaIngrediente);

            Log.i("pizzeriaActivity", String.valueOf(pizza));




        });


    }

    private int obtenerTamañoPizza(RadioGroup rg) {

        int checkedId = rg.getCheckedRadioButtonId();


            if (checkedId == R.id.radio1) {
                return 0;

            }
            if (checkedId == R.id.radio2) {
                return 1;

            }
            if(checkedId == R.id.radio3) {
                return 2;
            }

        return -1;
    }


    public void agregarIngrediente(Pizza pizza) {
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

}