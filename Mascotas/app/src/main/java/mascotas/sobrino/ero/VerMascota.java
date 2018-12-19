package mascotas.sobrino.ero;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class VerMascota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_mascota);

        Intent itDatos = getIntent();
        Mascota mascota = (Mascota) itDatos.getExtras().get("mascota");

        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvRaza = findViewById(R.id.tvRaza);
        TextView tvPeso = findViewById(R.id.tvPeso);
        RatingBar ratingBar = findViewById(R.id.rbValoracion);

        tvNombre.setText(mascota.getNombre());
        tvRaza.setText(mascota.getRaza());
        tvPeso.setText(mascota.getPeso()+"");
        ratingBar.setRating(mascota.getValoracion());

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) { // Horizontal
            ImageView ivFoto = findViewById(R.id.ivFoto);
            ivFoto.setImageResource(mascota.getFoto());
        }
    }
}
