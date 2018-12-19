package com.example.erosobrino.juegopersonajes;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class PantallaInicioView extends View {
    static long anchoPantalla, altoPantalla;

    public PantallaInicioView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
//        canvas.translate();ç
        canvas.restore();
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.anchoPantalla = w;
        this.altoPantalla = h;
    }
}
