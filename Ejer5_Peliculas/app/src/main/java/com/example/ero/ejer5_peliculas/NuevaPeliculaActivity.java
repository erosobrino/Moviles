package com.example.ero.ejer5_peliculas;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

public class NuevaPeliculaActivity extends AppCompatActivity {

    int clasificacion;
    Date fecha = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_pelicula);

        String[] salas = new String[]{"Gran Vía", "Travesía", "Plaza Elíptica"};
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, salas);
        spinner.setAdapter(adaptador);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.check(R.id.rbG);
        clasificacion = R.drawable.g;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                switch (radioButton.getId()) {
                    case R.id.rbG:
                        clasificacion = R.drawable.g;
                        break;
                    case R.id.rbPG:
                        clasificacion = R.drawable.pg;
                        break;
                    case R.id.rbR:
                        clasificacion = R.drawable.r;
                        break;
                    case R.id.rbPG13:
                        clasificacion = R.drawable.pg13;
                        break;
                    case R.id.rbNC17:
                        clasificacion = R.drawable.nc17;
                }
            }
        });

        Button btFecha = findViewById(R.id.btFecha);
        btFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itFecha = new Intent(getApplicationContext(), FechaActivity.class);
                startActivityForResult(itFecha, 1);
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
            EditText etDirector = findViewById(R.id.etDirector);
            EditText etDuracion = findViewById(R.id.etDuracion);
            Spinner spiner = findViewById(R.id.spinner);

            String titulo = etTitulo.getText().toString();
            String director = etDirector.getText().toString();
            int duracion = 0;
            String sala = spiner.getSelectedItem().toString();

            if (etDuracion.getText().toString().length() > 0) {
                duracion = Integer.parseInt(etDuracion.getText().toString());
            }
            if (fecha == null) {
                Toast.makeText(getApplicationContext(), R.string.nullDate, Toast.LENGTH_SHORT).show();
            } else {
                if (titulo.length() > 0 && director.length() > 0 && duracion > 0) {
                    Pelicula pelicula = new Pelicula(titulo, director, duracion, fecha, sala, clasificacion, R.drawable.sincara);
                    Pelicula.peliculas.add(pelicula);
                    Intent itDevolverPeli = new Intent();
                    setResult(RESULT_OK, itDevolverPeli);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), R.string.rellenarDatos, Toast.LENGTH_SHORT).show();
                }
            }
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            fecha = (Date) data.getExtras().get("fecha");
        }
    }
}
