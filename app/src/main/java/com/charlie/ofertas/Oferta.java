package com.charlie.ofertas;

import java.util.Date;

public class Oferta {

    private String ID;
    private String productoID;
    private float precio;
    private String comercioID;
    private String descripcion;
    private String fechaCreacion;

    public Oferta(){

    }

    /*
    public Oferta(String ID, String productoID, float precio, String comercioID, String descripcion) {
        this.ID = ID;
        this.productoID = productoID;
        this.precio = precio;
        this.comercioID = comercioID;
        this.descripcion = (descripcion != null ? descripcion : "");
        this.fechaCreacion = (new Date()).toString();
    }
    */

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getProductoID() {
        return productoID;
    }

    public void setProductoID(String producto) {
        this.productoID = producto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getComercioID() {
        return comercioID;
    }

    public void setComercioID(String comercioID) {
        this.comercioID = comercioID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
