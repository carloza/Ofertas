package com.charlie.ofertas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    protected Context context;
    protected ArrayList<Producto> lista;
    protected LayoutInflater inflater = null;

    public Adaptador( Context context, ArrayList<Producto> lista) {
        this.lista = lista;
        this.context = context;

    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Producto getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Toast.makeText(context,"paso1", Toast.LENGTH_SHORT).show();
        Producto item = (Producto) this.getItem(position);

        if(convertView==null) convertView = LayoutInflater.from(context).inflate(R.layout.itemoferta, null);

        //recupero punteros
        LinearLayout l = convertView.findViewById(R.id.itemoferta);

        //convertView = LayoutInflater.from(context).inflate(R.layout.itemoferta, parent);
        ImageView iRubro = convertView.findViewById(R.id.imageViewRubro);
        TextView tProducto = convertView.findViewById(R.id.textViewNombreProducto);
        TextView lComercio = convertView.findViewById(R.id.textViewComercioDeOferta);

        //seteo atributos
        iRubro.setImageResource(R.mipmap.ic_launcher_round);
        tProducto.setText(item.getNombre());
        Oferta oferta = item.primerOferta();
        String nombreComercio = (oferta==null? "no hay oferta" : oferta.getComercio().getNombre());
        lComercio.setText(nombreComercio);

        //aca pondria el oyente pero no, el oyente se setean donde se llama
        /*
        ListView lv = getListView();
        setContentView(lv);
        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Toast.makeText(SuggestionActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
        */

        return convertView;
    }
}
