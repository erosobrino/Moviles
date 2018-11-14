package com.example.ero.tema2_ejer1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcular = findViewById(R.id.btnCalculo);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), R.string.presionarMas, Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        calcular.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                TextView tv1 = findViewById(R.id.num1);
                TextView tv2 = findViewById(R.id.num2);
                if (tv1.getText().toString().length()==0||tv2.getText().toString().length()==0) {
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.errorIntroducir, Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Intent pantallaResult = new Intent(getApplicationContext(), Main2Activity.class);
                    pantallaResult.putExtra("num1", Integer.parseInt(tv1.getText().toString()));
                    pantallaResult.putExtra("num2", Integer.parseInt(tv2.getText().toString()));
                    startActivity(pantallaResult);
                }
                return true;
            }
        });
    }
}
