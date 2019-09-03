package com.charlie.ofertas;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MostrarProductoActivity extends AppCompatActivity {

    protected Datos datos;
    protected Producto prod;
    protected TextInputEditText producto, marca, contenido, rubro;
    protected ListView listaDeOfertas;
    protected AdaptadorOfertas adapte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_producto);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        datos = Datos.getInstance();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String ID = getIntent().getStringExtra("Producto");
        prod = Datos.getInstance().getProductoByID(ID);

        producto = findViewById(R.id.mostrarNombreProducto);
        marca = findViewById(R.id.mostrarMarcaProducto);
        contenido = findViewById(R.id.mostrarContenidoProducto);
        rubro = findViewById(R.id.mostrarRubroProducto);

        producto.setText(prod.getNombre());
        marca.setText(prod.getMarca());
        contenido.setText(prod.getCant()+ prod.getUnidad());
        rubro.setText(prod.getRubro());

        listaDeOfertas = findViewById(R.id.listaOfertas);
        adapte = new AdaptadorOfertas(this, datos.getOfertasDeProductoID(prod.getID()));
        listaDeOfertas.setAdapter(adapte);
        //aca podria agregar un oyente a cada item que dirija al comercio

    }

}
