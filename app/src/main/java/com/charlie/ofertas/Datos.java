package com.charlie.ofertas;

import java.util.ArrayList;

public class Datos {

    protected ArrayList<Comercio> listaComercios;
    protected ArrayList<Producto> listaProductos;
    protected ArrayList<Oferta> listaOfertas;
    protected static Datos misDatos;

    public Datos() {

        listaOfertas = new ArrayList<Oferta>();
        listaProductos = new ArrayList<Producto>();
        listaComercios = new ArrayList<Comercio>();
        creaDatos();
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
        Comercio c1, c2, c3, c4, c5;
        c1 = new Comercio(
                "1",
                "La Pepa",
                "Chacabuco y Belgrano",
                "Punta Alta",
                "esta en la esquina en frente del locutorio");
        c2 = new Comercio(
                "2",
                "Estela y Fabian",
                "Luiggi 630",
                "punta alta",
                "Frente al jardin");
        c3 = new Comercio(
                "3",
                "Cooperativa Obrera",
                "Brown 128",
                "punta alta",
                "tiene mas de un comercio eca en punta");
        c4 = new Comercio(
                "4",
                "Supermercado Corazon",
                "Saavedra 146",
                "punta alta",
                "super chino");
        c5 = new Comercio(
                "5",
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
                "1",
                "Fernet",
                "branca",
                750,
                "ml",
                "Bebida",
                0);
        p2 = new Producto(
                "2",
                "Pan",
                "",
                1,
                "kg",
                "Panificados",
                0);
        p3 = new Producto(
                "3",
                "Asado",
                "",
                1,
                "kg",
                "Carniceria",
                0);
        p4 = new Producto(
                "4",
                "Arroz",
                "3 Gallos",
                500,
                "g",
                "Almacen",
                518029);
        p5 = new Producto(
                "5",
                "Gaseosa Cola",
                "Coca-Cola",
                2.25f,
                "ml",
                "Bebida",
                0);
        p6 = new Producto(
                "6",
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
                "1",
                p1,
                205.5f,
                c4,
                null);
        p1.addOferta(o1);
        o2 = new Oferta(
                "2",
                p2,
                29,
                c5,
                "hay que ir temprano");
        p2.addOferta(o2);
        o3 = new Oferta(
                "3",
                p3,
                290,
                c3,
                null);
        p3.addOferta(o3);
        o4 = new Oferta(
                "4",
                p4,
                79.9f,
                c1,
                "A veces el asado sale medio duro");
        p4.addOferta(o4);
        o5 = new Oferta(
                "5",
                p5,
                205.5f,
                c2,
                null);
        p5.addOferta(o5);
        o6 = new Oferta(
                "6",
                p6,
                11.5f,
                c2,
                null);
        p6.addOferta(o6);

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
