package com.charlie.ofertas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;

public class BuscarProductosActivity extends AppCompatActivity {

    protected Intent intentLocal;
    protected Button Buscar;
    protected ListView listaDeProductos;
    protected AdaptadorProductos adapte;
    protected Datos datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_productos);

        intentLocal = getIntent();

        final boolean tutorial = preguntoTutorial();
        if(tutorial){
            //show mini tutorial TODO
        }

        Buscar = findViewById(R.id.buttonBuscarProducto);
        Buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intentLocal.putExtra("Exito", "Exito: Salida de creacion");
                //setResult(Activity.RESULT_OK,intentLocal);
                //finish();

                Snackbar.make(v, "Esto aplicaria un filtro", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        datos = Datos.getInstance();

        listaDeProductos = findViewById(R.id.listaBuscarProductoCrearOferta);
        adapte = new AdaptadorProductos(this, datos.getListaProductos());
        listaDeProductos.setAdapter(adapte);
        listaDeProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String IDProd = adapte.getItem(position).getID();
                Intent i = new Intent(getBaseContext(), BuscarComerciosActivity.class);
                i.putExtras(intentLocal.getExtras());
                i.putExtra("IDProducto", IDProd);
                i.putExtra("Tutorial", tutorial);
                startActivityForResult(i,1);
            }
        });

    }

    private boolean preguntoTutorial() {
        boolean salida = false;
        return salida;
    }

    public void onBackPressed() {
        intentLocal.putExtra("Resultado", "Cancel: Oferta Descartada");
        setResult(Activity.RESULT_CANCELED,intentLocal);
        finish();
        //super.onBackPressed();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            intentLocal.putExtras(data.getExtras());
            setResult(resultCode,intentLocal);
            finish();
        }
    }
}
