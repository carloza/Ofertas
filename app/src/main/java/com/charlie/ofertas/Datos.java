package com.charlie.ofertas;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Datos {

    protected FirebaseDatabase database;
    protected DatabaseReference myRef;
    protected ArrayList<Comercio> listaComercios;
    protected ArrayList<Producto> listaProductos;
    protected ArrayList<Oferta> listaOfertas;
    protected static Datos misDatos;
    protected ValueEventListener valueEventListenerC, valueEventListenerP, valueEventListenerO;

    public static Datos getInstance(){
        if(misDatos==null){
            misDatos = new Datos();
        }
        return misDatos;
    }

    private Datos() {
        //FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        database.setPersistenceEnabled(true);
        myRef = database.getReference();
        crearListas();
        //creaDatos();
        //mandarDB();
        actualiza();
    }

    private void crearListas() {
        listaOfertas = new ArrayList<Oferta>();
        listaProductos = new ArrayList<Producto>();
        listaComercios = new ArrayList<Comercio>();
    }

    private void actualiza() {
        //crearListas();

        myRef.child("Comercios").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaComercios.clear();
                for (DataSnapshot d: dataSnapshot.getChildren()) {
                    listaComercios.add(d.getValue(Comercio.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        myRef.child("Produtos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaProductos.clear();
                for (DataSnapshot d: dataSnapshot.getChildren()) {
                    listaProductos.add(d.getValue(Producto.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        myRef.child("Ofertas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaOfertas.clear();
                for (DataSnapshot d: dataSnapshot.getChildren()) {
                    listaOfertas.add(d.getValue(Oferta.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void mandarDB() {
        for (Comercio c: listaComercios) {
            myRef.child("Comercios").child(c.getID()).setValue(c);
        }

        for (Producto p: listaProductos) {
            myRef.child("Produtos").child(p.getID()).setValue(p);
        }

        for (Oferta o: listaOfertas) {
            myRef.child("Ofertas").child(o.getID()).setValue(o);
        }
    }

    public Producto getProductoByID(String ID){
        for (Producto a : listaProductos ) {
            if (a.getID().equals(ID)) return a;
        }
        return null;
    }

    public Comercio getComercioByID(String ID){
        for (Comercio a : listaComercios ) {
            if (a.getID().equals(ID)) return a;
        }
        return null;
    }

    public Oferta getOfertaByID(String ID){
        for (Oferta a : listaOfertas ) {
            if (a.getID().equals(ID)) return a;
        }
        return null;
    }

    public ArrayList<Oferta> getOfertasDeProductoID(String ID){
        ArrayList<Oferta> salida = new ArrayList<>();
        for (Oferta o: listaOfertas) {
            if (o.getProductoID().equals(ID)) salida.add(o);
        }
        return salida;
    }

    public Oferta getPrimerOfertaDeProductoID(String ID){
        for (Oferta o: listaOfertas) {
            if (o.getProductoID().equals(ID)) return o;
        }
        return null;
    }

    public Oferta crearOferta(String productoID, String comercioID, float precio, String info){
        Oferta salida = new Oferta();
        salida.setID(UUID.randomUUID().toString());
        salida.setProductoID(productoID);
        salida.setPrecio(precio);
        salida.setComercioID(comercioID);
        salida.setDescripcion(info);
        salida.setFechaCreacion(new Date().toString());
        //producto.addOferta(salida);
        myRef.child("Ofertas").child(salida.getID()).setValue(salida);
        actualiza();
        return salida;
    }

    public ArrayList<Oferta> getListaOfertas() {
        return listaOfertas;
    }

    public ArrayList<Comercio> getListaComercios() {
        return listaComercios;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }
}
