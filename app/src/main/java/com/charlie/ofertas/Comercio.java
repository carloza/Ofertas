package com.charlie.ofertas;

public class Comercio {
    protected String nombre;
    protected String info;

    //protected GpsSatellite posicionGPS;//     <<==
    protected String direccion;  //estos dos (localidad y direccion) vere
    protected String localidad;  //si puedo usar algun servio de google.maps

    public Comercio(String nombre, String direccion, String localidad, String info) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.info = info;
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
