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

    public Producto(String ID, String nombreArticulo, String marca, float cant, String unidad, String rubro, long codigoBarra) {
        this.ID = ID;
        this.nombre = nombreArticulo;
        this.marca = marca;
        this.cant = cant;
        this.unidad = unidad;
        this.rubro = rubro;
        this.codigoBarra = codigoBarra;
        //this.OfertasDeEste = new ArrayList<Oferta>();

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

    /*
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


     * Elimina la Oferta ingresada por parametro
     * @param o
     * @return
     *

    public boolean eliminarOferta(Oferta o){
        return OfertasDeEste.remove(o);
    }


     * elimina la oferta con el Id ingresado por parametro
     * @param ID
     * @return

    public boolean eliminarOferta(String ID){
        for (Oferta aux: OfertasDeEste) {
            if (aux.getID().equals(ID)){
                OfertasDeEste.remove(aux);
                return true;
            }
        }
        return false;
    }
    */
}
