package com.example.erosobrino.juegopersonajes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;


public class PantallaInicioView extends View {
    static int anchoPantalla, altoPantalla;
    Context context;
    Utils utils;
    ArrayList<Personaje> personajes = new ArrayList<>();
    Bitmap bg;

    public PantallaInicioView(Context context) {
        super(context);
        this.context = context;
        utils = new Utils(context);
        bg = utils.getBitmapFromAssets("bg.png");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bg, 0, 0, null);
        for (Personaje p : personajes) {
            p.move();
            p.cambiaFrame();
            p.dibuja(canvas);
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX(), y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                for (Personaje p : personajes) {
                    p.isPulsado(x, y);
                }
                break;
        }
        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.anchoPantalla = w;
        this.altoPantalla = h;
        if (w > h) {
            bg = Bitmap.createScaledBitmap(bg, anchoPantalla, altoPantalla, true);

            Bitmap[] auxc, auxp;

            auxc = utils.getFrames(10, "caba", "Run", utils.getDpH(250));
            auxp = utils.getFrames(10, "caba", "Idle", utils.getDpH(250));
            Personaje caballero = new Personaje(auxc, auxp, utils.getDpW(640), utils.getDpH(50), utils.getDpW(10));
            caballero.setTiempoFrame(100);
            caballero.setTiempoMove(150);
            personajes.add(caballero);

            auxc = utils.getFrames(10, "santa", "Run", utils.getDpH(200));
            auxp = utils.getFrames(10, "santa", "Idle", utils.getDpH(200));
            Personaje santa = new Personaje(auxc, auxp, utils.getDpH(900), utils.getDpH(350), utils.getDpW(5));
            santa.setTiempoMove(100);
            santa.setTiempoFrame(120);
            personajes.add(santa);

            auxc = utils.getFrames(10, "cat", "Walk", utils.getDpH(300));
            auxp = utils.getFrames(10, "cat", "Idle", utils.getDpH(300));
            Personaje cat = new Personaje(auxc, auxp, utils.getDpH(320), altoPantalla - auxc[0].getHeight(), utils.getDpW(15));
            cat.setTiempoMove(125);
            cat.setTiempoFrame(150);
            personajes.add(cat);

            auxc = utils.getFrames(10, "dog", "Walk", utils.getDpH(300));
            auxp = utils.getFrames(10, "dog", "Idle", utils.getDpH(300));
            Personaje perro = new Personaje(auxc, auxp, utils.getDpH(150), (altoPantalla - auxc[0].getHeight())/3, utils.getDpW(15));
            perro.setTiempoMove(125);
            perro.setTiempoFrame(120);
            personajes.add(perro);

            auxc = utils.getFrames(10, "dino", "Walk", utils.getDpH(300));
            auxp = utils.getFrames(10, "dino", "Idle", utils.getDpH(300));
            Personaje dino = new Personaje(auxc, auxp, utils.getDpH(100), (altoPantalla - auxc[0].getHeight())/3*2, utils.getDpW(15));
            dino.setTiempoMove(125);
            dino.setTiempoFrame(100);
            personajes.add(dino);
        }
    }
}