package com.example.a00_appjava2;

import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ListenerBoton implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        if(view instanceof Button){
            Button boton = (Button)view;
            String mensaje = boton.getText().toString();
            Log.i("ListenerBoton", "Boton pulsado con el texto: " + mensaje);
        }


    }
}
