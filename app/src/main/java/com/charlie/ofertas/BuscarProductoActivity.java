package com.charlie.ofertas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.Toast;

public class BuscarProductoActivity extends AppCompatActivity {

    protected Intent intentLocal;
    protected Button Buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_producto);

        intentLocal = getIntent();

        Buscar = findViewById(R.id.buttonBuscar);
        Buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentLocal.putExtra("Exito", "Exito: Salida de creacion");
                setResult(Activity.RESULT_OK,intentLocal);
                finish();
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
