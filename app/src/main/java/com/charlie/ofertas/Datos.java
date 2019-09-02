package com.charlie.ofertas;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.UUID;

public class Datos {

    protected FirebaseDatabase database;
    protected DatabaseReference myRef;
    protected ArrayList<Comercio> listaComercios;
    protected ArrayList<Producto> listaProductos;
    protected ArrayList<Oferta> listaOfertas;
    protected static Datos misDatos;

    private Datos() {
        //FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        creaDatos();
        mandarDB();
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

    public static Datos getInstance(){
        if(misDatos==null){
            misDatos = new Datos();
        }
        return misDatos;
    }

    /**
     * Este metodo crea datos de prueba
     * va a volar cuando tenga firebase andando
     */
    private void creaDatos() {

        listaOfertas = new ArrayList<Oferta>();
        listaProductos = new ArrayList<Producto>();
        listaComercios = new ArrayList<Comercio>();


        Comercio c1, c2, c3, c4, c5;
        c1 = new Comercio(
                UUID.randomUUID().toString(),
                "La Pepa",
                "Chacabuco y Belgrano",
                "Punta Alta",
                "esta en la esquina en frente del locutorio");
        c2 = new Comercio(
                UUID.randomUUID().toString(),
                "Estela y Fabian",
                "Luiggi 630",
                "punta alta",
                "Frente al jardin");
        c3 = new Comercio(
                UUID.randomUUID().toString(),
                "Cooperativa Obrera",
                "Brown 128",
                "punta alta",
                "tiene mas de un comercio eca en punta");
        c4 = new Comercio(
                UUID.randomUUID().toString(),
                "Supermercado Corazon",
                "Saavedra 146",
                "punta alta",
                "super chino");
        c5 = new Comercio(
                UUID.randomUUID().toString(),
                "La tauriña",
                "saavedra 55",
                "punta alta",
                "panaderia al lado de la coope");
        listaComercios.add(c1);
        listaComercios.add(c2);
        listaComercios.add(c3);
        listaComercios.add(c4);
        listaComercios.add(c5);

        Producto p1, p2, p3, p4, p5, p6;
        p1 = new Producto(
                UUID.randomUUID().toString(),
                "Fernet",
                "branca",
                750,
                "ml",
                "Bebida",
                0);
        p2 = new Producto(
                UUID.randomUUID().toString(),
                "Pan",
                "",
                1,
                "kg",
                "Panificados",
                0);
        p3 = new Producto(
                UUID.randomUUID().toString(),
                "Asado",
                "",
                1,
                "kg",
                "Carniceria",
                0);
        p4 = new Producto(
                UUID.randomUUID().toString(),
                "Arroz",
                "3 Gallos",
                500,
                "g",
                "Almacen",
                518029);
        p5 = new Producto(
                UUID.randomUUID().toString(),
                "Gaseosa Cola",
                "Coca-Cola",
                2.25f,
                "ml",
                "Bebida",
                0);
        p6 = new Producto(
                UUID.randomUUID().toString(),
                "Fideos Spagetti",
                "Primer Precio",
                300,
                "g",
                "Almacen",
                0);
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        listaProductos.add(p4);
        listaProductos.add(p5);
        listaProductos.add(p6);

        Oferta o1, o2, o3, o4, o5, o6;
        o1 = new Oferta(
                UUID.randomUUID().toString(),
                p1.getID(),
                205.5f,
                c4.getID(),
                null);
        //p1.addOferta(o1);
        o2 = new Oferta(
                UUID.randomUUID().toString(),
                p2.getID(),
                29,
                c5.getID(),
                "hay que ir temprano");
        //p2.addOferta(o2);
        o3 = new Oferta(
                UUID.randomUUID().toString(),
                p3.getID(),
                290,
                c3.getID(),
                null);
        //p3.addOferta(o3);
        o4 = new Oferta(
                UUID.randomUUID().toString(),
                p4.getID(),
                79.9f,
                c1.getID(),
                "A veces el asado sale medio duro");
        //p4.addOferta(o4);
        o5 = new Oferta(
                UUID.randomUUID().toString(),
                p5.getID(),
                205.5f,
                c2.getID(),
                null);
        //p5.addOferta(o5);
        o6 = new Oferta(
                UUID.randomUUID().toString(),
                p6.getID(),
                11.5f,
                c2.getID(),
                null);
        //p6.addOferta(o6);

        listaOfertas.add(o1);
        listaOfertas.add(o2);
        listaOfertas.add(o3);
        listaOfertas.add(o4);
        listaOfertas.add(o5);
        listaOfertas.add(o6);
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

    public Oferta crearOferta(Producto producto, Comercio comercio, float precio, String info){
        Oferta salida = new Oferta(
                UUID.randomUUID().toString(),
                producto.getID(),
                precio,
                comercio.getID(),
                info);
        //producto.addOferta(salida);

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
