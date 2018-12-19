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
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class PantallaInicioView extends View {
    int anchoPantalla, altoPantalla;
    float posXCirculo = 0, posYCirculo = 0;
    String texto;
    Paint paint;
    TextPaint tpaint;
    Rect cuadrado, cuadradoBorde, cuadradoConTexto;
    RectF cuadrado2;
    StaticLayout textLayout;
    boolean pulsado = false;
    double tamaño;
    int alpha;
    int cont;
    String text;

    public PantallaInicioView(Context context) {
        super(context);
        paint = new Paint();
        paint.setAlpha(240);
        paint.setTextSize(getPixels(11));
        paint.setAntiAlias(true);
        tpaint = new TextPaint();
        tpaint.setTextSize(getPixels(8));
        tpaint.setTextAlign(Paint.Align.CENTER);
        tpaint.setColor(Color.WHITE);
        tpaint.setShadowLayer(getPixels(4f), getPixels(4f), getPixels(4f), Color.RED);
        cuadrado = new Rect(getPixels(6.66f), getPixels(70), getPixels(115), getPixels(136.6f));
        cuadrado2 = new RectF(getPixels(110),getPixels(80),getPixels(200),getPixels(140));
        cuadradoBorde = new Rect(getPixels(185), getPixels(70), getPixels(270), getPixels(136));
        cuadradoConTexto = new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
        paint.setColor(Color.WHITE);
        canvas.drawText(" Prueba de texto"+text, getPixels(20), getPixels(10), paint);
        paint.setColor(Color.GREEN);
        canvas.drawRect(cuadrado, paint);
        paint.setColor(Color.RED);
        paint.setAlpha(170);
        canvas.drawRoundRect(cuadrado2, getPixels(10), getPixels(30), paint);
        paint.setColor(Color.GREEN);
        paint.setAlpha(240);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawRect(cuadradoBorde, paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.CYAN);
        canvas.drawCircle(anchoPantalla / 2, altoPantalla / 2, 100, paint);
        paint.setColor(Color.WHITE);
        if (pulsado && tamaño > 1) {
            if (tamaño > cont + 1) {
                cont++;
                tamaño -= cont;
            } else {
                tamaño = 1;
            }
            if (alpha > 5) {
                alpha -= 5;
            } else
                alpha = 1;
            paint.setAlpha(alpha);
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

    public int getPixels(float dp) {
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().
                getMetrics(metrics);
        return (int) (dp * metrics.density);
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
                tamaño = 400;
                alpha = 255;
                cont = 0;
                text=getPixels(x)+" ";
                text+=getPixels(y);
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