package com.charlie.ofertas;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
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

        String ID = getIntent().getStringExtra("ProductoID");
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
        //lo que voy a hacer es mostrar la info de cada oferta
        listaDeOfertas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Oferta o = adapte.getItem(position);
                String info = o.getDescripcion().equals("") ? "No hay info para esta oferta": o.getDescripcion();
                String mensaje = "info:\n" +
                        info +
                        "\n \n"+
                        "Fecha de Oferta:\n"+
                        o.getFechaCreacion();
                Toast.makeText(MostrarProductoActivity.this, mensaje, Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), BuscarComerciosActivity.class);
                i.putExtras(getIntent().getExtras());
                i.putExtra("Tutorial", false);
                startActivityForResult(i,1);
            }
        });

    }

    public void onBackPressed() {
        getIntent().putExtra("Resultado", "Cancel: Oferta Descartada");
        setResult(5,getIntent());
        finish();
        //super.onBackPressed();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            getIntent().putExtras(data.getExtras());
            setResult(resultCode,getIntent());
            finish();
        }
    }

}
