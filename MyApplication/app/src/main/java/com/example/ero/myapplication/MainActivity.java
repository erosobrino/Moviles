package com.example.ero.myapplication;

import android.graphics.Color;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "logEro";
    int cont=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "En Create");

        final Button bt = findViewById(R.id.button);
        TextView tv = findViewById(R.id.textView);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont++;
                if (cont%2!=0){
                    Log.i(TAG, "Pulsa Cambio Color y cambia a Color Dos");
                    bt.setText(R.string.restauraColor);
                    bt.setBackgroundColor(getResources().getColor(R.color.colorDos));
                }else{
                    Log.i(TAG, "Pulsa Restaura Color y cambia a a Color Uno");
                    bt.setText(R.string.cambiaColor);
                    bt.setBackgroundColor(getResources().getColor(R.color.colorUno));
                }
            }
        });

        bt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                cont=0;
                Log.i(TAG, "Pulsacion larga");
                bt.setText("Reiniciado");
                bt.setBackgroundColor(Color.WHITE);
                return true;
            }
        });

//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        bt.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                return false;
//            }
//        });
    }
//    int cont=0;
//    public void boton1(View v) {
//        cont++;
//        String mensage="Llevas"+cont;
//        Toast.makeText(getApplicationContext(), mensage, Toast.LENGTH_SHORT).show();
//        Log.i(TAG, "Pulsa cambia color");
//        if (cont%2!=0){
//
//        }
//    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "En Resumen");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "En Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "En Stop");
    }
}
