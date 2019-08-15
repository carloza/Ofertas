package com.charlie.ofertas;

import java.util.Date;

public class Oferta {

    protected String ID;
    protected Producto producto;
    protected float precio;
    protected Comercio comercio;
    protected String descripcion;
    protected String fechaCreacion;

    public Oferta(String ID, Producto producto, float precio, Comercio comercio, String descripcion) {
        this.ID = ID;
        this.producto = producto;
        this.precio = precio;
        this.comercio = comercio;
        this.descripcion = (descripcion != null ? descripcion : "");
        this.fechaCreacion = (new Date()).toString();
    }

    public String getID() {
        return ID;
    }

    public Producto getProducto() {
        return producto;
    }

    public float getPrecio() {
        return precio;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }
}
