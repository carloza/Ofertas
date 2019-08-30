package com.charlie.ofertas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorComercios extends BaseAdapter {

    protected Context context;
    protected ArrayList<Comercio> lista;
    protected LayoutInflater inflater = null;

    public AdaptadorComercios(Context context, ArrayList<Comercio> lista) {
        this.lista = lista;
        this.context = context;

    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Comercio getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Comercio item = (Comercio) this.getItem(position);

        if(convertView==null) convertView = LayoutInflater.from(context).inflate(R.layout.item_producto, null);

        //recupero punteros
        LinearLayout l = convertView.findViewById(R.id.itemListView);

        //convertView = LayoutInflater.from(context).inflate(R.layout.item_producto, parent);
        ImageView Rubro = convertView.findViewById(R.id.imageViewRubro);
        TextView comercio = convertView.findViewById(R.id.textViewTitulo);
        TextView direccion = convertView.findViewById(R.id.textViewSubtitulo);
        TextView localidad = convertView.findViewById(R.id.textViewSubtitulo2);

        //seteo atributos
        Rubro.setImageResource(R.mipmap.ic_launcher_round);
        comercio.setText(item.getNombre());
        direccion.setText(item.getDireccion());
        localidad.setText(item.getLocalidad());

        return convertView;
    }
}
