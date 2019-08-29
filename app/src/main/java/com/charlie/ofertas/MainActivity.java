package com.charlie.ofertas;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected long backPressedTime;
    protected Toast backToast;
    protected ListView listaVista;
    protected AdaptadorProductos adaptadorProductos;
    protected final String TAG = "firestore";
    protected final static boolean DEBUG = false;
    protected int request_Code;


    /**
     * Este metodo es el que se ejecuta cuando se crea este frame
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //creacion de la actividad
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mensaje de bienvenida
        bienvenida();

        //menu de tres puntos
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // boton flotante
        botonFltante();

        //list view de productos ( podria tirarlo dentro de un metodo tambien :P )
        if(DEBUG)Toast.makeText(MainActivity.this,"paso1", Toast.LENGTH_SHORT).show();
        listaVista = findViewById(R.id.listaProductos);
        adaptadorProductos = new AdaptadorProductos(this, GetLista());
        listaVista.setAdapter(adaptadorProductos);
        if(DEBUG)Toast.makeText(MainActivity.this,"paso2", Toast.LENGTH_SHORT).show();
        listaVista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //acá tengo que saltar a la actividad donde muestro el producto
                Producto a = adaptadorProductos.getItem(position);
                //Toast.makeText(MainActivity.this, ""+ a.getNombre(), Toast.LENGTH_SHORT).show();
                Intent nuevoIntent = new Intent(MainActivity.this, MostrarProductoActivity.class);
                nuevoIntent.putExtra("Producto", a.getID());
                startActivity(nuevoIntent);
            }
        });

    }

    /**
     * Metodo que crea lo visual a en la bienvenida
     */
    private void bienvenida() {
        //creo mensaje de de alerta al inicio y un toast de bienvenida
        AlertDialog.Builder Bienvenida = new AlertDialog.Builder(this);
        Bienvenida.setTitle("Importante");
        Bienvenida.setMessage("Esta app actualmente se encuentra en desarrollo");
        Bienvenida.setCancelable(false);
        Bienvenida.setPositiveButton("Mandale mechaaa!!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                Toast.makeText(MainActivity.this,"Bienvenido", Toast.LENGTH_SHORT).show();;
            }
        });
        Bienvenida.show();
    }

    /**
     * este metodo crea el menu de los 3 puntitos en el bar superior
     * @param menu lista del menu para inflar la vista
     * @return true o false de como salió
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * aca atrapo el item seleccionado en los 3 puntitos
     * @param item item que fue selecionado
     * @return truo o false de como resulto la seleccion
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.buscarOferta) {
            return true;
        }
        if (id == R.id.about) {
            //Toast.makeText(MainActivity.this,"Desarrollado por\nCarlos Loza\nVersión 1.0", Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, R.string.stringAbout, Toast.LENGTH_SHORT).show();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    /**
     * metodo auxiliar para crear la lista que infla el ListView
     * antes creaba una lista a mano, ahora tengo una clase para crear datos de prueba
     * @return lista de productos
     */
    protected ArrayList<Producto> GetLista(){
        //ArrayList<Oferta> lsi = new ArrayList<>();
        Datos d = new Datos();
        /*
        for(int i = 0; i<15; i++){
            lsi.add(new Ofertas(i, "Oferta"+i, "Aca va el contenido: contenido "+i));
        }
        return lsi;
         */


        return d.getListaProductos();
    }

    /**
     * Gracias a "Coding in Flow" por esta funcionalidad
     * enlace al video: https://youtu.be/1Nmy88n7CZ8
     */
    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Preciona de nuevo para salir", Toast.LENGTH_LONG);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    /**
     * Metodo auxiliar para crear el el boton flotante
     * aca tambien le asigno el oyente
     */

    protected void botonFltante(){
        FloatingActionButton fab = findViewById(R.id.botonFlotante);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creamos el intent
                Intent i = new Intent(MainActivity.this , CargarNuevoActivity.class);

                i.putExtra("Main", "Manito");

                //iniciamos la nueva actividad; aca me voy a la actividad de Cargar una nueva Oferta
                request_Code = 1;
                startActivityForResult(i,request_Code);
                //startActivity(i);


            }
        });
    }

    /**
     * Aca entra cuando vuelve de otro Frame,
     * para entrar aca el intent de debe lanzar con "startActivityForResult"
     * @param requestCode aca identifico de que frame vengo
     * @param resultCode aca veo como salio, si ok o con problema
     * @param data de aca obtengo los resultados que vuelven (mapeo)
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(DEBUG)Toast.makeText(getBaseContext(), "Entre al onActivityResult", Toast.LENGTH_LONG).show();
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //String returnedResult = data.getStringExtra("Extito");
                // OR
                // String returnedResult = data.getDataString();
                Toast.makeText(getBaseContext(), data.getStringExtra("Exito"), Toast.LENGTH_LONG).show();
            }
            else if(resultCode == RESULT_CANCELED){
                Toast.makeText(getBaseContext(), data.getStringExtra("Cancel"), Toast.LENGTH_LONG).show();

            }
        }else if(requestCode == 2){

        }
    }

    /*
    Codigo de Ejemplo (en su mayoria creado por mi)

    //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
    //        .setAction("Action", null).show();

    //Toast.makeText(getBaseContext(), "Luego de iniciar el nuevo intent", Toast.LENGTH_LONG).show();

    startActivityForResult(i,request_Code);
    //startActivity(i);

            acá quise ponerle un oyente al listView y no le gusto, ni arrancó la app
            lo que voy a hacer es ponerle un oyente a cada componenete del listView
            ya veré como lo hago
            listaVista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "EN DESARROLLO", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // Access a Cloud Firestore instance from your Activity
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);

        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
         */
}
