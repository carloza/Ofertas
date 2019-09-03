package com.charlie.ofertas;

public class Comercio {

    private String ID;
    private String nombre;
    private String info;
    private String direccion;  //estos dos (localidad y direccion) estaria bueno
    private String localidad;  //si se puediera usar algun servio de google.maps

    public Comercio(){

    }

    /*
    public Comercio(String ID, String nombre, String direccion, String localidad, String info) {
        this.ID = ID;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.info = info;
    }
    */

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
