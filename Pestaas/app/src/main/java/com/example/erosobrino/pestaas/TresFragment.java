package com.example.erosobrino.pestaas;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TresFragment extends Fragment {
    String cad = null;

    public TresFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void setContenido(String cad) {
        this.cad = cad;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_tres, container, false);
        if (this.cad == null) return layout;
        else {
            TextView tv = (TextView) layout.findViewById(R.id.tvFragment3);
            tv.setText(this.cad);
            return layout;
        }
    }

}
