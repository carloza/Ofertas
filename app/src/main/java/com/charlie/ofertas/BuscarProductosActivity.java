package com.charlie.ofertas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class BuscarProductosActivity extends AppCompatActivity {

    protected Intent intentLocal;
    protected Button Buscar;
    protected ListView listaDeProductos;
    protected AdaptadorProductos adapte;
    protected Datos datos;
    protected boolean tutorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_productos);

        intentLocal = getIntent();

        preguntoTutorial();

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

    private void preguntoTutorial() {
        //creo mensaje de de alerta al inicio y un toast de bienvenida
        AlertDialog.Builder Tuto = new AlertDialog.Builder(this);
        Tuto.setTitle("Importante");
        Tuto.setMessage("Esta aplicacion provee una gia que acompaña en el proceso de creacion de esta. " +
                "Desea usar esta fucion?");
        Tuto.setCancelable(false);
        Tuto.setPositiveButton("Ayudame", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                tutorial = true;
                mostrarAyuda();
            }
        });
        Tuto.setNegativeButton("Puedo Solo", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                tutorial = false;
            }
        });
        Tuto.show();
    }

    private void mostrarAyuda() {
        AlertDialog.Builder Mensaje = new AlertDialog.Builder(this);
        Mensaje.setMessage("En el cuadro de texto podras escribir una pablabra cable para filtrar y " +
                "en la lista de abajo podras elegir el producto que buscas, si no lo encotras mas abajo" +
                " se encuentra el boton rojo para agregar tu producto");
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

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            intentLocal.putExtras(data.getExtras());
            setResult(resultCode,intentLocal);
            finish();
        }
    }
}
