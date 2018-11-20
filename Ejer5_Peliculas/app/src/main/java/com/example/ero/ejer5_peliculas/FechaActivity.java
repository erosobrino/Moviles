package com.example.ero.ejer5_peliculas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class FechaActivity extends AppCompatActivity {

    Date fecha = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fecha);

        final Calendar c=Calendar.getInstance();
        fecha=c.getTime();
        int anho=c.get(Calendar.YEAR);
        int mes=c.get(Calendar.MONTH);
        int dia=c.get(Calendar.DAY_OF_MONTH);
        final DatePicker dp=(DatePicker)findViewById(R.id.datepicker);
        dp.init(anho, mes, dia, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                c.set(year,monthOfYear,dayOfMonth);
                fecha=c.getTime();
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
            Intent itDevolverFecha = new Intent();
            itDevolverFecha.putExtra("fecha", fecha);
            setResult(RESULT_OK, itDevolverFecha);
            finish();
        }
        return true;
    }
}
