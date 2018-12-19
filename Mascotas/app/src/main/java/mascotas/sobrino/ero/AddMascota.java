package mascotas.sobrino.ero;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class AddMascota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mascota);

        Button btCancelar = findViewById(R.id.btCancelar);
        btCancelar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                finish();
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_anadir, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.btAñadirMenu) {
            EditText etNombre = findViewById(R.id.etNombre);
            String nombre = etNombre.getText().toString();
            EditText etRaza = findViewById(R.id.etRaza);
            String raza = etRaza.getText().toString();
            EditText etPeso = findViewById(R.id.etPeso);
            RatingBar ratingBar = findViewById(R.id.rbPuntuacion);
            float puntuacion = ratingBar.getRating();

            if (nombre.length() == 0 || raza.length() == 0 || etPeso.getText().toString().length() == 0) {
                Toast.makeText(getApplicationContext(), R.string.faltandatos, Toast.LENGTH_SHORT).show();
            } else {
                float peso = Float.parseFloat(etPeso.getText().toString());
                Mascota mascota = new Mascota(nombre, peso, android.R.drawable.ic_media_next, raza, puntuacion);
                Intent intentSec = new Intent();
                intentSec.putExtra("mascota", mascota);
                setResult(RESULT_OK, intentSec);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
