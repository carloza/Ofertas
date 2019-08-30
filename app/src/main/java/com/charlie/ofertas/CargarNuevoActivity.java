package com.charlie.ofertas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
//import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class CargarNuevoActivity extends AppCompatActivity {

    protected TextInputEditText urlImagen;
    protected TextInputEditText titulo ;
    protected TextInputEditText descripcion;
    protected Button botonCrear;
    protected Toast backToast;
    protected Intent intentLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar_nuevo);
        titulo = findViewById(R.id.textImputTitulo);
        intentLocal = getIntent();
        pressBotonCrear();
    }

    private void pressBotonCrear() {
        botonCrear =findViewById(R.id.botonCrear);
        botonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aca estamos probando lo de renornar resultados
                //Intent returnIntent = new Intent();
                intentLocal = getIntent();
                //String resultText = titulo.getText().toString();
                //intentLocal.putExtra("result",resultText);

                Intent i2 = new Intent(getBaseContext(), BuscarProductosActivity.class);
                i2.putExtras(intentLocal.getExtras());
                startActivityForResult(i2,8);

            }
        });
    }

    public void onBackPressed() {
        intentLocal.putExtra("Cancel", "Cancel: Oferta Descartada");
        setResult(Activity.RESULT_CANCELED,intentLocal);
        finish();
        //super.onBackPressed();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 8) {
            intentLocal.putExtras(data.getExtras());

            if (resultCode == RESULT_OK) {

                setResult(Activity.RESULT_OK,intentLocal);

                //String returnedResult = data.getStringExtra("result");
                // OR
                // String returnedResult = data.getDataString();
                //Toast.makeText(getBaseContext(), "Guardaremos tu oferta de "+returnedResult, Toast.LENGTH_LONG).show();
            }
            else if(resultCode == RESULT_CANCELED){
                setResult(Activity.RESULT_CANCELED,intentLocal);
            }
            finish();
        }
    }
}
