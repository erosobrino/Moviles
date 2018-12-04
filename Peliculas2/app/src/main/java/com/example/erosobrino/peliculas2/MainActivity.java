package com.example.erosobrino.peliculas2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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

import java.util.ArrayList;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    AdaptadorPrincipal adaptadorPrincipal;
    ArrayList<Pelicula> peliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peliculas = Pelicula.getPeliculas();
        final TextView tvTituloSeleccionado = findViewById(R.id.tvSeleccionado);
        tvTituloSeleccionado.setText(peliculas.get(0).titulo);

        adaptadorPrincipal = new AdaptadorPrincipal(this, peliculas);
        ListView listView = findViewById(R.id.lvPeliculas);
        listView.setAdapter(adaptadorPrincipal);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvTituloSeleccionado.setText(peliculas.get(position).titulo);
            }
        });

        final FloatingActionButton floatingActionButton = findViewById(R.id.btExpandir);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionBar actionBar = getSupportActionBar();
                if (actionBar.isShowing()) {
                    actionBar.hide();
                    tvTituloSeleccionado.setVisibility(View.GONE);
                    floatingActionButton.setImageResource(R.drawable.ic_zoom2_blanco);
                } else {
                    actionBar.show();
                    tvTituloSeleccionado.setVisibility(View.VISIBLE);
                    floatingActionButton.setImageResource(R.drawable.ic_zoom_blanco);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.btAñadir) {
//            Intent itAñadir = new Intent();
//            startActivityForResult(itAñadir, 1);
        }
        if (item.getItemId() == R.id.btFavoritas) {
            Intent itFavoritas = new Intent(getApplicationContext(),FavoritasActivity.class);
            startActivityForResult(itFavoritas, 1);
        }
        if (item.getItemId() == R.id.btCompleta) {
            Intent itCompleta=new Intent(getApplicationContext(),CompletasActivity.class);
            startActivity(itCompleta);
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            peliculas = Pelicula.getPeliculas();
            adaptadorPrincipal.notifyDataSetChanged();
        }
    }
}
