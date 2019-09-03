package com.charlie.ofertas;

import java.util.ArrayList;

/**
 * Esta clase es para representar cada Producto
 */
public class Producto {

    private String ID;
    private String nombre;
    private String marca;
    private float cant;
    private String unidad;
    private String rubro;
    private long codigoBarra; //aca estaria piola implementar algo con la cam
    //private ArrayList<Oferta> OfertasDeEste; //esto deberia guardarse ordenado, ya vere

    public Producto(){

    }

    /*
    public Producto(String ID, String nombreArticulo, String marca, float cant, String unidad, String rubro, long codigoBarra) {
        this.ID = ID;
        this.nombre = nombreArticulo;
        this.marca = marca;
        this.cant = cant;
        this.unidad = unidad;
        this.rubro = rubro;
        this.codigoBarra = codigoBarra;
    }
    */

    public String getNombre() {
        return nombre;
    }

    public float getCant() {
        return cant;
    }

    public String getUnidad() {
        return unidad;
    }

    public String getMarca() {
        return marca;
    }

    public String getRubro() {
        return rubro;
    }

    public long getCodigoBarra() {
        return codigoBarra;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCant(float cant) {
        this.cant = cant;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public void setCodigoBarra(long codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
}
