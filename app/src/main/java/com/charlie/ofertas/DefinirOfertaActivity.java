package com.charlie.ofertas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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

        Producto producto = datos.getProductoByID(intentLocal.getStringExtra("IDProducto"));
        Comercio comercio = datos.getComercioByID(intentLocal.getStringExtra("IDComercio"));

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

            }
        });
    }


    public void onBackPressed() {
        intentLocal.putExtra("Cancel", "Cancel: Oferta Descartada");
        setResult(Activity.RESULT_CANCELED,intentLocal);
        finish();
        //super.onBackPressed();
    }
}