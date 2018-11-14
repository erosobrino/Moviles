package com.example.ero.holapersonalizado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent it=getIntent();
        TextView tv=findViewById(R.id.tv2);
        tv.setText(it.getStringExtra("dato"));

        Button atras=findViewById(R.id.btnAtras);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


       Button bu=findViewById(R.id.button3);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RatingBar rt=findViewById(R.id.ratingBar);
                Intent datos=new Intent();
                datos.putExtra("valor",rt.getRating());
                setResult(RESULT_OK,datos);
                finish();
            }
        });
    }
}
