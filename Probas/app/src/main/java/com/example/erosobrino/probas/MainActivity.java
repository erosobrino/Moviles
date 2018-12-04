package com.example.erosobrino.probas;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spinner = findViewById(R.id.spinner);
        final TextView tvTexto = findViewById(R.id.textView);
        ArrayAdapter<String> nombres = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{"asdf", "asfdg", "dffgnhh"});
        spinner.setAdapter(nombres);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvTexto.setText(spinner.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final Button btn = (Button) findViewById(R.id.button);
        btn.setOnCreateContextMenuListener(this);

        Button btnPopup = findViewById(R.id.button2);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) { // Horizontal
        } else { // Vertical
        }
        SeekBar seekBar = findViewById(R.id.seekBar2);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        EditText etTexto = findViewById(R.id.editText);
        SeekBar seekBar = findViewById(R.id.seekBar2);
        outState.putString("texto", etTexto.getText().toString());
        outState.putInt("puntuacion", seekBar.getProgress());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        EditText etTexto = findViewById(R.id.editText);
        SeekBar seekBar = findViewById(R.id.seekBar2);
        etTexto.setText(savedInstanceState.getString("texto"));
        seekBar.setProgress(savedInstanceState.getInt("puntuacion"));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.editar:
                Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.copiar:
                Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.pegar:
                Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void menuEmergente(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.inflate(R.menu.menupopup);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.opc1:
                        Toast.makeText(getApplicationContext(), item.getTitle() + " -> opc1", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.opc2:
                        Toast.makeText(getApplicationContext(), item.getTitle() + " -> opc2", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.opc3:
                        Toast.makeText(getApplicationContext(), item.getTitle() + " -> opc3", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.opc4:
                        Toast.makeText(getApplicationContext(), item.getTitle() + " -> opc4", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                }
                return false;
            }
        });
        popup.show();
    }
}
