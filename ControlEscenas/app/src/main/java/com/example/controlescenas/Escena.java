package com.example.controlescenas;

import android.content.Context;
import android.graphics.Bitmap;

public class Escena {
    Context contexto;
    int idEscena;
    int anchoPantalla, altoPantalla;
    Bitmap fondo;

    public Escena(Context context,int altoPantalla,int anchoPantalla){
        this.contexto=context;
        this.altoPantalla=altoPantalla;
        this.anchoPantalla=anchoPantalla;
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public int getIdEscena() {
        return idEscena;
    }

    public void setIdEscena(int idEscena) {
        this.idEscena = idEscena;
    }

    public int getAnchoPantalla() {
        return anchoPantalla;
    }

    public void setAnchoPantalla(int anchoPantalla) {
        this.anchoPantalla = anchoPantalla;
    }

    public int getAltoPantalla() {
        return altoPantalla;
    }

    public void setAltoPantalla(int altoPantalla) {
        this.altoPantalla = altoPantalla;
    }

    public Bitmap getFondo() {
        return fondo;
    }

    public void setFondo(Bitmap fondo) {
        this.fondo = fondo;
    }

}
