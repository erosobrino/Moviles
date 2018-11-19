package com.example.ero.ejer5_peliculas;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Date;

public class NuevaPeliculaActivity extends AppCompatActivity {

    int clasificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_pelicula);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                clasificacion = checkedId;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_favoritas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.btVolver) {
            EditText etTitulo = findViewById(R.id.etTitulo);
            EditText etDirector = findViewById(R.id.etTitulo);
            EditText etDuracion = findViewById(R.id.etTitulo);
//            Date fecha =findViewById();
            Date fecha=new Date(222222);
            int duracion = Integer.parseInt(etDuracion.getText().toString());

            Pelicula pelicula = new Pelicula(etTitulo.getText().toString(), etDirector.getText().toString(), duracion, fecha, "", clasificacion, R.drawable.sincara);
            Intent itDevolverPeli = new Intent();
            itDevolverPeli.putExtra("peliculas", pelicula);
            setResult(RESULT_OK, itDevolverPeli);
            finish();
        }
        return true;
    }


}
