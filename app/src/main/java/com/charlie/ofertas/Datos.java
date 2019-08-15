package com.charlie.ofertas;

import java.util.ArrayList;

public class Datos {

    protected ArrayList<Comercio> listaComercios;
    protected ArrayList<Producto> listaProductos;
    protected ArrayList<Oferta> listaOfertas;

    public Datos() {

        listaOfertas = new ArrayList<Oferta>();
        listaProductos = new ArrayList<Producto>();
        listaComercios = new ArrayList<Comercio>();
        creaDatos();
    }

    private void creaDatos() {
        Comercio c1, c2, c3, c4, c5;
        c1 = new Comercio(
                "La Pepa",
                "Chacabuco y Belgrano",
                "Punta Alta",
                "esta en la esquina en frente del locutorio");
        c2 = new Comercio(
                "Estela y Fabian",
                "Luiggi 630",
                "punta alta",
                "Frente al jardin");
        c3 = new Comercio(
                "Cooperativa Obrera",
                "Brown 128",
                "punta alta",
                "tiene mas de un comercio eca en punta");
        c4 = new Comercio(
                "Supermercado Corazon",
                "Saavedra 146",
                "punta alta",
                "super chino");
        c5 = new Comercio(
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
                "Fernet",
                750,
                "ml",
                "branca",
                "Bebida",
                0);
        p2 = new Producto(
                "Pan",
                1,
                "kg",
                "",
                "Panificados",
                0);
        p3 = new Producto(
                "Asado",
                1,
                "kg",
                "",
                "Carniceria",
                0);
        p4 = new Producto(
                "Arroz",
                500,
                "g",
                "3 Gallos",
                "Almacen",
                518029);
        p5 = new Producto(
                "Gaseosa Cola",
                2.25f,
                "ml",
                "Coca-Cola",
                "Bebida",
                0);
        p6 = new Producto(
                "Fideos Spagetti",
                300,
                "g",
                "Primer Precio",
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
                p1,
                205.5f,
                c4,
                null);
        p1.addOferta(o1);
        o2 = new Oferta(
                p2,
                29,
                c5,
                "hay que ir temprano");
        p2.addOferta(o2);
        o3 = new Oferta(
                p3,
                290,
                c3,
                null);
        p3.addOferta(o3);
        o4 = new Oferta(
                p4,
                79.9f,
                c1,
                "A veces el asado sale medio duro");
        p4.addOferta(o4);
        o5 = new Oferta(
                p5,
                205.5f,
                c2,
                null);
        p5.addOferta(o5);
        o6 = new Oferta(
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
