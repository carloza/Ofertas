package com.charlie.ofertas;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ListView;

public class MostrarProductoActivity extends AppCompatActivity {

    protected Producto actual;
    protected TextInputEditText producto, marca, contenido, rubro;
    protected ListView listaDeOfertas;
    protected AdaptadorOfertas adapte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_producto);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String ID = getIntent().getStringExtra("Producto");
        actual = Datos.getInstance().getProductoByID(ID);

        producto = findViewById(R.id.mostrarNombreProducto);
        marca = findViewById(R.id.mostrarMarcaProducto);
        contenido = findViewById(R.id.mostrarContenidoProducto);
        rubro = findViewById(R.id.mostrarRubroProducto);

        producto.setText(actual.getNombre());
        marca.setText(actual.getMarca());
        contenido.setText(actual.getCant()+actual.getUnidad());
        rubro.setText(actual.getRubro());

        listaDeOfertas = findViewById(R.id.listaOfertas);
        adapte = new AdaptadorOfertas(this, actual.getOfertasDeEste());
        listaDeOfertas.setAdapter(adapte);

    }

}
