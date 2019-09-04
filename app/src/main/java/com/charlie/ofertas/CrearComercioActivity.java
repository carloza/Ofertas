package com.charlie.ofertas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class CrearComercioActivity extends AppCompatActivity {

    protected Intent intentLocal;
    protected TextInputEditText textNombre, textInfo, textDireccion, textLocalidad;
    protected Button buttomCrearComercio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_comercio);

        intentLocal = getIntent();

        textNombre = findViewById(R.id.textNombreComercio);
        textInfo = findViewById(R.id.textInfoComercio);
        textDireccion = findViewById(R.id.textDireccionComercio);
        textLocalidad = findViewById(R.id.textLocalidadComercio);

        buttomCrearComercio = findViewById(R.id.concretarComercio);
        buttomCrearComercio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!hayVacios()){
                    String nombre = textNombre.getText().toString();
                    String info = textInfo.getText().toString();
                    String direccion = textDireccion.getText().toString();
                    String localidad = textLocalidad.getText().toString();

                    Comercio c  = Datos.getInstance().crearComercio(nombre, info, direccion, localidad);

                    Intent i = new Intent(CrearComercioActivity.this, DefinirOfertaActivity.class);
                    i.putExtras(intentLocal.getExtras());
                    i.putExtra("ComercioID" , c.getID());
                    startActivityForResult(i,1);
                }
            }
        });

    }

    private boolean hayVacios() {
        boolean vacios = false;
        if(textNombre.getText().toString().equals("")){
            textNombre.setError("Dato requerido");
            vacios = true;
        }
        if(textDireccion.getText().toString().equals("")){
            textDireccion.setError("Dato requerido");
            vacios = true;
        }
        if(textLocalidad.getText().toString().equals("")){
            textLocalidad.setError("Dato requerido");
            vacios = true;
        }
        return vacios;
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
