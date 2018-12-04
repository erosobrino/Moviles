package com.example.erosobrino.peliculas2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AdaptadorPrincipal extends BaseAdapter {

    ArrayList<Pelicula> peliculas;
    LayoutInflater inflador;

    public AdaptadorPrincipal(Context contexto, ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
        this.inflador = LayoutInflater.from(contexto);
    }

    @Override
    public int getCount() {
        return peliculas.size();
    }

    @Override
    public Object getItem(int position) {
        return peliculas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contenedor contenedor = null;
        if (convertView == null) {
            convertView = inflador.inflate(R.layout.fila_principal, null);
            contenedor = new Contenedor();
            contenedor.tvDirector = (TextView) convertView.findViewById(R.id.textView);
            contenedor.tvTitulo = (TextView) convertView.findViewById(R.id.tvTitulo);
            contenedor.caratula = (ImageView) convertView.findViewById(R.id.ivCaratula);
            contenedor.clasificacion = (ImageView) convertView.findViewById(R.id.ivClasificacion);
            convertView.setTag(contenedor);
        } else contenedor = (Contenedor) convertView.getTag();

        Pelicula pelicula = (Pelicula) getItem(position);
        contenedor.clasificacion.setImageResource(pelicula.clasi);
        contenedor.caratula.setImageResource(pelicula.portada);
        contenedor.tvTitulo.setText(pelicula.titulo);
        contenedor.tvDirector.setText(pelicula.director);

        return convertView;
    }

    class Contenedor {
        ImageView caratula;
        ImageView clasificacion;
        TextView tvDirector;
        TextView tvTitulo;
    }
}
