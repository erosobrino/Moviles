package com.example.erosobrino.peliculas2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CompletasActivity extends AppCompatActivity {
    ArrayList<Pelicula> peliculas;
    Inflater inflador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completas);

        peliculas = Pelicula.getPeliculas();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        AdaptadorCompleto adaptadorCompleto = new AdaptadorCompleto(this, peliculas);

        ListView lvCompleto = findViewById(R.id.lvCompleta);
        lvCompleto.setAdapter(adaptadorCompleto);
        lvCompleto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent itPelicula = new Intent(getApplicationContext(), PeliculaActivity.class);
                itPelicula.putExtra("pelicula", peliculas.get(position));
                startActivity(itPelicula);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }
}
