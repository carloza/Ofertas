package com.charlie.ofertas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.math.MathUtils;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class DefinirOfertaActivity extends AppCompatActivity {

    protected Intent intentLocal;
    protected Datos datos;
    protected TextInputEditText textProducto, textComercio, textPrecio, textInfo;
    protected Button concretar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definir_oferta);

        intentLocal = getIntent();
        datos = Datos.getInstance();

        boolean tutorial = intentLocal.getBooleanExtra("Tutorial",true);
        if(tutorial){
            mostrarAyuda();
        }

        final Producto producto = datos.getProductoByID(intentLocal.getStringExtra("ProductoID"));
        final Comercio comercio = datos.getComercioByID(intentLocal.getStringExtra("ComercioID"));

        textProducto = findViewById(R.id.productoEnOferta);
        textComercio = findViewById(R.id.comercioEnOferta);
        textPrecio = findViewById(R.id.precioEnOferta);
        textInfo = findViewById(R.id.infoEnOferta);
        concretar = findViewById(R.id.concretarOferta);

        textProducto.setText(producto.getNombre());
        textComercio.setText(comercio.getNombre());

        concretar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textPrecio.getText().toString().equals("")){
                    textPrecio.setError("Dato requerido");
                }else{
                    //aca no atrapo la posible excepcion xq la vista controla que solo inresen numeros
                    //int precio = Integer.parseInt(textPrecio.getText().toString());
                    float precio = Float.parseFloat(textPrecio.getText().toString());
                    String info = textInfo.getText().toString();

                    Datos.getInstance().crearOferta(producto.getID(), comercio.getID(), precio, info);

                    intentLocal.putExtra("Resultado", producto.getNombre());
                    setResult(Activity.RESULT_OK,intentLocal);
                    finish();
                }

            }
        });
    }

    private void mostrarAyuda() {
        AlertDialog.Builder Mensaje = new AlertDialog.Builder(this);
        Mensaje.setMessage("Ya has seleccionado el producto y el comercio para definir tu oferta," +
                " solo resta establecer el precio del producto en ese comercio, opcional podras " +
                "dejar una pequeña info para quien vea esta oferta (Ej: Quedaba poca mercaderia)");
        Mensaje.setCancelable(false);
        Mensaje.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
            }
        });
        Mensaje.show();
    }


    public void onBackPressed() {
        intentLocal.putExtra("Resultado", "Cancel: Oferta Descartada");
        setResult(Activity.RESULT_CANCELED,intentLocal);
        finish();
        //super.onBackPressed();
    }
}