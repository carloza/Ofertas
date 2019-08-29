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

public class AdaptadorOfertas extends BaseAdapter {

    protected Context context;
    protected ArrayList<Oferta> lista;
    protected LayoutInflater inflater = null;

    public AdaptadorOfertas(Context context, ArrayList<Oferta> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Oferta getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Oferta item = this.getItem(position);

        if(convertView==null) convertView = LayoutInflater.from(context).inflate(R.layout.item_producto, null);

        //recupero punteros
        LinearLayout l = convertView.findViewById(R.id.itemproducto);

        ImageView iRubro = convertView.findViewById(R.id.imageViewRubro);
        TextView Precio = convertView.findViewById(R.id.textViewTitulo);
        TextView Comercio = convertView.findViewById(R.id.textViewSubtitulo);
        TextView direccion = convertView.findViewById(R.id.textViewSubtitulo2);

        //seteo atributos
        iRubro.setImageResource(R.mipmap.ic_launcher_round);
        Precio.setText("$ "+item.getPrecio());
        Comercio comercio = item.getComercio();
        Comercio.setText(comercio.getNombre());
        direccion.setText(comercio.getDireccion());

        return convertView;
    }
}
