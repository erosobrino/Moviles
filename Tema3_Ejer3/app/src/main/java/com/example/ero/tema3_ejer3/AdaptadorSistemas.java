package com.example.ero.tema3_ejer3;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorSistemas extends BaseAdapter {
    ArrayList<SistemaOperativo> lista;
    LayoutInflater inflador;
    boolean inicio = true;

    public AdaptadorSistemas(Context contexto, ArrayList<SistemaOperativo> lista) {
        this.inflador = LayoutInflater.from(contexto);
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Contenedor contenedor = null; // Aquí se gestionan las filas
        if (view == null) {
            view = inflador.inflate(R.layout.fila, null);
            contenedor = new Contenedor();
            contenedor.logotipo = (ImageView) view.findViewById(R.id.logo);
            contenedor.txtSistema = (TextView) view.findViewById(R.id.txtSistema);
            contenedor.txtAno = (TextView) view.findViewById(R.id.txtFecha);
            view.setTag(contenedor);
        } else contenedor = (Contenedor) view.getTag(); // obtengo el contenedor
        SistemaOperativo so = (SistemaOperativo) getItem(position);
        contenedor.logotipo.setImageResource(so.getLogo());
        if (lista.get(position).getNombre().contains("Windows")) {
            contenedor.logotipo.setVisibility(View.INVISIBLE);
        }
        contenedor.txtSistema.setText(so.getNombre());
        contenedor.txtAno.setText(so.getAno());
        if (position % 2 == 0) {
            view.setBackgroundColor(Color.RED);
        }else{
            view.setBackgroundColor(Color.WHITE);
        }
        return view;
    }

    class Contenedor {
        ImageView logotipo;
        TextView txtSistema, txtAno;
    }
}