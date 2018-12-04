package com.example.erosobrino.peliculas2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AdaptadorCompleto extends BaseAdapter {
    ArrayList<Pelicula> peliculas;
    LayoutInflater inflador;

    public AdaptadorCompleto(Context contexto, ArrayList<Pelicula> peliculas) {
        this.inflador = LayoutInflater.from(contexto);
        this.peliculas = peliculas;
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
            //añadir elementos
            convertView = inflador.inflate(R.layout.fila_completa, null);
            contenedor = new Contenedor();
            contenedor.tvTitulo = (TextView) convertView.findViewById(R.id.tvTitulo);
            contenedor.tvDirector = (TextView) convertView.findViewById(R.id.tvDirector);
            contenedor.tvDuracion = (TextView) convertView.findViewById(R.id.tvDuracion);
            contenedor.tvFecha = (TextView) convertView.findViewById(R.id.tvFecha);
            contenedor.tvSala = (TextView) convertView.findViewById(R.id.tvSala);

            contenedor.ivCaratula = (ImageView) convertView.findViewById(R.id.ivCaratula);
            contenedor.ivClasificacion = (ImageView) convertView.findViewById(R.id.ivClasificacion);
            contenedor.ivFavorito = (ImageView) convertView.findViewById(R.id.ivFavorito);
            convertView.setTag(contenedor);
        } else contenedor = (Contenedor) convertView.getTag();

        Pelicula pelicula = peliculas.get(position);
        contenedor.ivCaratula.setImageResource(pelicula.portada);
        contenedor.ivClasificacion.setImageResource(pelicula.clasi);
        if (pelicula.favorita) {
            contenedor.ivFavorito.setImageResource(R.drawable.ic_favorite_red);
        } else {
            contenedor.ivFavorito.setImageResource(R.drawable.ic_favorite);
        }
        contenedor.tvTitulo.setText(pelicula.titulo);
        contenedor.tvDirector.setText(pelicula.director);
        contenedor.tvFecha.setText(pelicula.getFecha());
        contenedor.tvDuracion.setText(pelicula.duracion + " min");
        contenedor.tvSala.setText(pelicula.sala);

        return convertView;
    }

    class Contenedor {
        //añadir
        ImageView ivCaratula, ivFavorito, ivClasificacion;
        TextView tvTitulo, tvDirector, tvDuracion, tvFecha, tvSala;
    }
}
