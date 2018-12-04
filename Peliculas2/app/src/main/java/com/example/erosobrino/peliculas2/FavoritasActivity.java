package com.example.erosobrino.peliculas2;

import android.database.DataSetObserver;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FavoritasActivity extends AppCompatActivity {
    ArrayList<Pelicula> peliculas;
    ListView lvFavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        setTitle("Favoritas");
        peliculas = Pelicula.getPeliculas();

        lvFavoritas = findViewById(R.id.lvFavoritas);
        lvFavoritas.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayList<String> nombresPeliculas = new ArrayList<>();
        for (int i = 0; i < peliculas.size(); i++) {
            nombresPeliculas.add(peliculas.get(i).titulo);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, nombresPeliculas);
        lvFavoritas.setAdapter(adapter);

        for (int i = 0; i < lvFavoritas.getCount(); i++) {
            lvFavoritas.setItemChecked(i, peliculas.get(i).favorita);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_favoritas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.btGuardaFav) {
            for (int i = 0; i < lvFavoritas.getCount(); i++) {
                peliculas.get(i).setFavorita(lvFavoritas.isItemChecked(i));
            }
            Pelicula.setPeliculas(peliculas);
            onBackPressed();
        }
        return true;
    }
}
