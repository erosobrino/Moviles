package com.example.ero.ejer5_peliculas;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
//Ero Sobrino
    AdaptadorPeliculas adaptador;
    ArrayList<Pelicula> peliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peliculas = Pelicula.getPeliculas();

        final TextView tvTituloPrincipal = findViewById(R.id.tvTituloPrincipal);
        if (peliculas.size() > 0) {
            tvTituloPrincipal.setText(peliculas.get(0).titulo);
        }

        adaptador = new AdaptadorPeliculas(this, peliculas);
        ListView list = findViewById(R.id.list);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvTituloPrincipal.setText(peliculas.get(position).titulo);
            }
        });

        final FloatingActionButton btOcultar = findViewById(R.id.btFlotanteOcultar);
        btOcultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionBar actionBar = getSupportActionBar();
                if (actionBar.isShowing()) {
                    actionBar.hide();
                    tvTituloPrincipal.setVisibility(View.GONE);
                    btOcultar.setImageResource(R.drawable.ic_zoom2_blanco);
                } else {
                    actionBar.show();
                    tvTituloPrincipal.setVisibility(View.VISIBLE);
                    btOcultar.setImageResource(R.drawable.ic_zoom_blanco);
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btPeliculas:
                Intent itCompleto = new Intent(MainActivity.this, ListadoCompletoActivity.class);
                startActivity(itCompleto);
                break;
            case R.id.btFavoritos:
                Intent favoritas = new Intent(MainActivity.this, FavoritasActivity.class);
                startActivityForResult(favoritas, 1);
                break;
            case R.id.btAdd:
                Intent itNueva = new Intent(MainActivity.this, NuevaPeliculaActivity.class);
                startActivityForResult(itNueva, 2);
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            peliculas = Pelicula.getPeliculas();
            adaptador.notifyDataSetChanged();
        }
        if (requestCode == 2 && resultCode == RESULT_OK) {
            peliculas = Pelicula.getPeliculas();
            adaptador.notifyDataSetChanged();
        }
    }
}
