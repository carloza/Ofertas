package com.charlie.ofertas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class CrearProductoActivity extends AppCompatActivity {

    protected Intent intentLocal;
    protected TextInputEditText textNombre, textMarca, textCantidad, textUnidad, textRubro;
    protected Button buttomCrearComercio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_producto);

        intentLocal = getIntent();

        textNombre = findViewById(R.id.textNombreProducto);
        textMarca = findViewById(R.id.textMarcaProducto);
        textCantidad = findViewById(R.id.textCantidadProducto);
        textUnidad = findViewById(R.id.textUnidadProducto);
        textRubro = findViewById(R.id.textRubroProducto);

        buttomCrearComercio = findViewById(R.id.concretarProducto);
        buttomCrearComercio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!hayVacios()){
                    String nombre = textNombre.getText().toString();
                    String marca = textMarca.getText().toString();
                    float cantidad = Float.parseFloat(textCantidad.getText().toString());
                    String unidad = textUnidad.getText().toString();
                    String rubro = textRubro.getText().toString();

                    Producto c  = Datos.getInstance().crearProducto(nombre, marca, cantidad, unidad, rubro);

                    Intent i = new Intent(CrearProductoActivity.this, BuscarComerciosActivity.class);
                    //i.putExtras(intentLocal.getExtras());
                    i.putExtra("ProductoID" , c.getID());
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
        if(textMarca.getText().toString().equals("")){
            textMarca.setError("Dato requerido");
            vacios = true;
        }
        if(textCantidad.getText().toString().equals("")){
            textCantidad.setError("Dato requerido");
            vacios = true;
        }
        if(textUnidad.getText().toString().equals("")){
            textUnidad.setError("Dato requerido");
            vacios = true;
        }
        if(textRubro.getText().toString().equals("")){
            textRubro.setError("Dato requerido");
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
