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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class BuscarComerciosActivity extends AppCompatActivity {

    protected Intent intentLocal;
    protected Button Buscar;
    protected ListView listaDeComercios;
    protected AdaptadorComercios adapte;
    protected Datos datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_comercios);

        intentLocal = getIntent();
        datos = Datos.getInstance();

        boolean tutorial = intentLocal.getBooleanExtra("Tutorial",true);
        if(tutorial){
            mostrarAyuda();
        }

        Buscar = findViewById(R.id.buttonBuscarComercio);
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

        listaDeComercios = findViewById(R.id.listaBuscarComercioCrearOferta);
        adapte = new AdaptadorComercios(this, datos.getListaComercios());
        listaDeComercios.setAdapter(adapte);
        listaDeComercios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String IDProd = adapte.getItem(position).getID();
                Intent i = new Intent(getBaseContext(), DefinirOfertaActivity.class);
                i.putExtras(intentLocal.getExtras());
                i.putExtra("ComercioID", IDProd);
                startActivityForResult(i,1);
            }
        });

        botonFltante();

    }

    private void mostrarAyuda() {
        AlertDialog.Builder Mensaje = new AlertDialog.Builder(this);
        Mensaje.setMessage("En el cuadro de texto superior podras escribir una pablabra cable para filtrar y " +
                "en la lista de abajo podras elegir el comercio que buscas, si no lo encotras mas abajo" +
                " se encuentra el boton rojo para agregar tu comercio");
        Mensaje.setCancelable(false);
        Mensaje.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
            }
        });
        Mensaje.show();
    }

    protected void botonFltante(){
        FloatingActionButton fab = findViewById(R.id.botonFlotanteComercios);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //creamos el intent
                Intent i = new Intent(BuscarComerciosActivity.this , CrearComercioActivity.class);

                i.putExtras(intentLocal.getExtras());

                //iniciamos la nueva actividad; aca me voy a la actividad de Cargar una nueva Oferta
                startActivityForResult(i,1);
                //startActivity(i);
            }
        });
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
