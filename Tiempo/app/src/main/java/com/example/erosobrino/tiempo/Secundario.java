package com.example.erosobrino.tiempo;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.xml.transform.Result;

public class Secundario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundario);
        final TextView txtB = findViewById(R.id.textView1);
        String texto = getIntent().getStringExtra("valor");
        txtB.setText(texto);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setResult(RESULT_OK);
            onBackPressed();
        }
    }

}
