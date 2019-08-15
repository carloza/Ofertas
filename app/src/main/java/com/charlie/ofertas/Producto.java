package com.charlie.ofertas;

import java.util.ArrayList;

/**
 * Esta clase es para representar cada Producto
 */
public class Producto {
    protected String ID;
    protected String nombre;
    protected float cant;
    protected String unidad;
    protected String marca;
    protected String rubro;
    protected long codigoBarra; //aca estaria piola implementar algo con la cam
    protected ArrayList<Oferta> OfertasDeEste; //esto deberia guardarse ordenado, ya vere

    public Producto(String ID, String nombreArticulo, float cant, String unidad,
                    String marca, String rubro, long codigoBarra) {
        this.ID = ID;
        this.nombre = nombreArticulo;
        this.cant = cant;
        this.unidad = unidad;
        this.marca = marca;
        this.rubro = rubro;
        this.codigoBarra = codigoBarra;
        this.OfertasDeEste = new ArrayList<Oferta>();
    }

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

    public boolean addOferta(Oferta o){
        try {
            OfertasDeEste.add(o);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public ArrayList<Oferta> getOfertasDeEste() {
        return OfertasDeEste;
    }

    public Oferta primerOferta(){
        return OfertasDeEste.get(0);
    }

}
