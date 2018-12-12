package com.example.erosobrino.juegos;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;

public class PantallaInicioView extends View {
    int anchoPantalla, altoPantalla, cont = 1;
    float posXCirculo = 50, posYCirculo = 50;
    String texto;
    Paint paint;
    TextPaint tpaint;
    Rect cuadrado, cuadradoBorde, cuadradoConTexto;
    RectF cuadrado2;
    StaticLayout textLayout;
    boolean pulsado = false;
    double tamaño;
    double velocidad;

    public PantallaInicioView(Context context) {
        super(context);
        paint = new Paint();
        paint.setAlpha(240);
        paint.setTextSize(110);
        paint.setAntiAlias(true);
        tpaint = new TextPaint();
        tpaint.setTextSize(80);
        tpaint.setTextAlign(Paint.Align.CENTER);
        tpaint.setColor(Color.WHITE);
        tpaint.setShadowLayer(4f, 4f, 4f, Color.RED);
        cuadrado = new Rect(20, 210, 350, 410);
        cuadrado2 = new RectF(320, 240, 640, 440);
        cuadradoBorde = new Rect(620, 210, 920, 410);
        cuadradoConTexto = new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
        paint.setColor(Color.WHITE);
        canvas.drawText(cont + " Prueba de texto", 20, 100, paint);
        paint.setColor(Color.GREEN);
        canvas.drawRect(cuadrado, paint);
        paint.setAlpha(170);
        paint.setColor(Color.RED);
        canvas.drawRoundRect(cuadrado2, 40, 30, paint);
        paint.setAlpha(240);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawRect(cuadradoBorde, paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.CYAN);
        canvas.drawCircle(anchoPantalla / 2, altoPantalla / 2, 100, paint);
        paint.setColor(Color.WHITE);
        if (pulsado && tamaño > 1) {
            if (velocidad <= 0) {
                velocidad = 0.5;
            } else {
                velocidad -= 2;
            }
            tamaño -= velocidad;
            if (tamaño < 0) {
                tamaño = 1;
            }
            canvas.drawCircle(posXCirculo, posYCirculo, (float) tamaño, paint);
        }
        textLayout = new StaticLayout(texto, tpaint, anchoPantalla / 2, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        int textHeight = textLayout.getHeight();
        canvas.save();
        canvas.translate(anchoPantalla / 2, 500);
        textLayout.draw(canvas);
        canvas.restore();
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        cont++;
        int accion = event.getAction();
        float x = event.getX(), y = event.getY();
        switch (accion) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                posXCirculo = x;
                posYCirculo = y;
                pulsado = true;
                tamaño = 200;
                velocidad = 40;
                break;
        }

        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.anchoPantalla = w;
        this.altoPantalla = h;
        this.texto = "El ancho de la pantalla es " + w + " y el alto " + h;
    }
}