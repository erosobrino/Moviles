package com.example.ero.tema2_ejer1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent principal = getIntent();
        int num1 = principal.getIntExtra("num1", 0);
        int num2 = principal.getIntExtra("num2", 0);

        TextView tvSum = findViewById(R.id.tvSuma);
        TextView tvResta = findViewById(R.id.tvResta);
        TextView tvMultiplicacion = findViewById(R.id.tvMultiplicacion);
        TextView tvDivision = findViewById(R.id.tvDivision);

        tvSum.setText((num1 + num2) + "");
        tvResta.setText((num1 - num2) + "");
        tvMultiplicacion.setText((num1 * num2) + "");
        if (num2 != 0) {
            tvDivision.setText((num1 / num2)+"");
        }else{
            Toast alerta=Toast.makeText(getApplicationContext(),R.string.error0,Toast.LENGTH_SHORT);
            alerta.show();
        }
    }
}
