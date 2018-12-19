package com.example.erosobrino.juegoandar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.io.IOException;
import java.io.InputStream;

public class PantallaInicioView extends View {
    Bitmap frame, btnAvz, btnRetrocede;
    int posX = 0;
    int vel = 0;
    boolean avanza = true;
    Paint paint;
    int anchoPantalla, altoPantalla, cont = 1;
    long tiempo = System.currentTimeMillis();
    boolean pulsado = false;

    public PantallaInicioView(Context context) {
        super(context);
        paint = new Paint();
        this.frame = getBitmapFromAssets("run_00.png");
        this.btnAvz = getBitmapFromAssets("avanza.png");
        this.btnRetrocede = getBitmapFromAssets("retrocede.png");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
        if (System.currentTimeMillis() - tiempo > 75) {
            cont++;
            tiempo = System.currentTimeMillis();
        }
        this.frame = getBitmapFromAssets("run_0" + (cont % 10) + ".png");
        if (!avanza && pulsado && posX <= anchoPantalla - frame.getWidth()) {
            posX += getPixels(3f);
        }
        if (avanza && pulsado && posX >= 0) {
            posX -= getPixels(3f);
        }
        canvas.drawBitmap(frame, posX, 0, null);
        if (avanza) {
            canvas.drawBitmap(btnAvz, anchoPantalla / 2 - btnAvz.getWidth() / 2, altoPantalla - btnAvz.getHeight(), null);
        } else {
            canvas.drawBitmap(btnRetrocede, anchoPantalla / 2 - btnRetrocede.getWidth() / 2, altoPantalla - btnRetrocede.getHeight(), null);
        }
        canvas.save();
        canvas.translate(anchoPantalla / 2, 500);
        canvas.restore();
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int accion = event.getAction();
        float x = event.getX(), y = event.getY();
        switch (accion) {
            case MotionEvent.ACTION_DOWN:
                if (x > (anchoPantalla / 2 - btnRetrocede.getWidth() / 2) && x < (anchoPantalla / 2 + btnRetrocede.getWidth() / 2) &&
                        y > altoPantalla - btnRetrocede.getHeight()) {
                    avanza = !avanza;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        pulsado = true;
        invalidate();
        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.anchoPantalla = w;
        this.altoPantalla = h;
    }

    public Bitmap getBitmapFromAssets(String fichero) {
        try {
            Context context = getContext();
            InputStream is = context.getAssets().open(fichero);
            return BitmapFactory.decodeStream(is);
        } catch (IOException e) {
            return null;
        }
    }

    int getPixels(float dp) {
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().
                getMetrics(metrics);
        return (int) (dp * metrics.density);
    }
}
