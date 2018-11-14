package com.example.ero.holapersonalizado;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt = findViewById(R.id.botonAceptar);
        final EditText textoIntroducido = findViewById(R.id.editTextNombre);
        final TextView mensaje = findViewById(R.id.textViewMensaje);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mensaje.setText(textoIntroducido.getText());
                Intent it = new Intent(getApplicationContext(), Main2Activity.class);
                EditText et = findViewById(R.id.editTextNombre);
                it.putExtra("dato", et.getText().toString());
                startActivityForResult(it, 1);
            }
        });

        final Button btnPosicion = (Button) findViewById(R.id.btnPosicion);
        btnPosicion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("geo:42.237109, -8.723474"));
                intent.setData(Uri.parse("geo:42,-8.8"));
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
            }

        });final Button btnLlamar = (Button) findViewById(R.id.btnLlamar);
        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:644459813"));
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            TextView tv = findViewById(R.id.textViewMensaje);
            tv.setText(data.getFloatExtra("valor", 0) + "");
        }

    }
}