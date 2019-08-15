package com.charlie.ofertas;

public class Comercio {

    protected String ID;
    protected String nombre;
    protected String info;

    //protected GpsSatellite posicionGPS;//     <<==
    protected String direccion;  //estos dos (localidad y direccion) estaria bueno
    protected String localidad;  //si se puediera usar algun servio de google.maps

    public Comercio(String ID, String nombre, String direccion, String localidad, String info) {
        this.ID = ID;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.info = info;
    }

    public String getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getInfo() {
        return info;
    }
}
