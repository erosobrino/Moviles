package com.example.ero.ejer5_peliculas;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

public class SinopsisPeliculaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinopsis_pelicula);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ImageView ivCaratula = findViewById(R.id.ivCaratulaSinopsis);
        TextView tvSinopsis = findViewById(R.id.tvSinopsis);
        Intent itDatos = getIntent();
        final Pelicula peli = (Pelicula) itDatos.getExtras().get("pelicula");
        ivCaratula.setImageResource(peli.portada);
        tvSinopsis.setText(peli.sinopsis);

        ivCaratula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                watchYoutubeVideo(peli.getIdYoutube());
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

    public void watchYoutubeVideo(String id) {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }
}
