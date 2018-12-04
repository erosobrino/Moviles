package com.example.erosobrino.tiempo;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

//Ero Sobrino Dorado
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button bt = findViewById(R.id.button1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    Fragment fb = getSupportFragmentManager().findFragmentById(R.id.fragment3);
                    ((BFragment) fb).txtB.setText(bt.getText().toString());
                } else {
                    Intent it = new Intent(MainActivity.this, Secundario.class);
                    it.putExtra("valor", bt.getText().toString());
                    startActivityForResult(it, 1);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            final Button bt = findViewById(R.id.button1);
            Fragment fb = getSupportFragmentManager().findFragmentById(R.id.fragment3);
            ((BFragment) fb).txtB.setText(bt.getText().toString());
        }
    }
}
