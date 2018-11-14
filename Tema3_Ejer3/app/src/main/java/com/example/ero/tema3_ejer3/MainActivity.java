package com.example.ero.tema3_ejer3;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
    AdaptadorSistemas adapter;
    ArrayList<SistemaOperativo> sistemas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// setContentView(R.layout.activity_main);
        sistemas = new ArrayList<SistemaOperativo>();
        sistemas.add(new SistemaOperativo("Ubuntu 14.04", "2014", R.drawable.tux));
        sistemas.add(new SistemaOperativo("MacOS X Tiger", "2004", R.drawable.apple));
        sistemas.add(new SistemaOperativo("Windows 95", "1995", R.drawable.windows));
        sistemas.add(new SistemaOperativo("Debian", "1993", R.drawable.tux));
        sistemas.add(new SistemaOperativo("Linux Mint 15", "2013", R.drawable.tux));
        sistemas.add(new SistemaOperativo("Windows 10", "2016", R.drawable.windows));
        sistemas.add(new SistemaOperativo("Android", "2006", R.drawable.android));
        sistemas.add(new SistemaOperativo("iOS 8", "2014", R.drawable.apple));
        sistemas.add(new SistemaOperativo("Windows XP", "2001", R.drawable.windows));
        sistemas.add(new SistemaOperativo("Elementary OS", "2014", R.drawable.tux));
        sistemas.add(new SistemaOperativo("MacOS 9", "1999", R.drawable.apple));
        adapter = new AdaptadorSistemas(this, sistemas);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        SistemaOperativo so=(SistemaOperativo)adapter.getItem(position);
        Toast.makeText(this, "Borrada posicion: "+position+" -> "+ so.getNombre(), Toast.LENGTH_SHORT).show();
        sistemas.remove(adapter.getItem(position));
        adapter.notifyDataSetChanged();
    }
}