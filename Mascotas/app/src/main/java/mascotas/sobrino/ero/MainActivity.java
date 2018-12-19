package mascotas.sobrino.ero;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas = new ArrayList<>();
    ArrayList<String> nombres = new ArrayList<>();
    ArrayAdapter<String> adapter;
    private static final String TAG = "Volcado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mascotas.add(new Mascota("gato", 3, android.R.drawable.ic_media_next, "raza1", 5));
        mascotas.add(new Mascota("perro", 5, android.R.drawable.ic_media_next, "raza2", 4));
        mascotas.add(new Mascota("iguana", 2, android.R.drawable.ic_media_next, "raza3", 3));
        mascotas.add(new Mascota("tortuga", (float) 0.5, android.R.drawable.ic_media_next, "raza4", 2));
        mascotas.add(new Mascota("gallina", 6, android.R.drawable.ic_media_next, "raza5", 5));

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.lista_mascotas);
        actionBar.setSubtitle(mascotas.size() + "");

        final ListView lvMascotas = findViewById(R.id.lvMascotas);
        for (int i = 0; i < mascotas.size(); i++) {
            nombres.add(mascotas.get(i).getNombre() + "\n" + mascotas.get(i).getRaza());
        }
        lvMascotas.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, nombres);
        lvMascotas.setAdapter(adapter);

        FloatingActionButton btBorrar = findViewById(R.id.btBorrar);
        btBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int seleccionado = lvMascotas.getCheckedItemPosition();
                if (seleccionado != -1) {
                    lvMascotas.setItemChecked(seleccionado, false);
                    Toast.makeText(getApplicationContext(), mascotas.get(seleccionado).getNombre() + " " + mascotas.get(seleccionado).getRaza(), Toast.LENGTH_SHORT).show();
                    nombres.remove(seleccionado);
                    mascotas.remove(seleccionado);
                    adapter.notifyDataSetChanged();
                    actionBar.setSubtitle(mascotas.size() + "");
                }
            }
        });
        lvMascotas.setOnCreateContextMenuListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btVer:
                ListView lvMascotas = findViewById(R.id.lvMascotas);
                int seleccionado = lvMascotas.getCheckedItemPosition();
                if (seleccionado != -1) {
                    Intent idVer = new Intent(getApplicationContext(), VerMascota.class);
                    idVer.putExtra("mascota", mascotas.get(seleccionado));
                    startActivity(idVer);
                } else {
                    Toast.makeText(getApplicationContext(), R.string.Noselecionado, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btAñadir:
                Intent idAñadir = new Intent(getApplicationContext(), AddMascota.class);
                startActivityForResult(idAñadir, 1);
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btVolcar:
                Log.i(TAG, mascotas.toString());
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Mascota mascota = (Mascota) data.getExtras().get("mascota");
            mascotas.add(mascota);
            nombres.add(mascota.getNombre() + "\n" + mascota.getRaza());
            adapter.notifyDataSetChanged();
            ActionBar actionBar = getSupportActionBar();
            actionBar.setSubtitle(mascotas.size() + "");
        }
    }
}
