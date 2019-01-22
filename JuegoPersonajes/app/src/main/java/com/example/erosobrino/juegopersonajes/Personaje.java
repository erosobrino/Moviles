package com.example.erosobrino.juegopersonajes;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.Log;

public class Personaje {
    private Bitmap[] frameParadoAv;//avanza
    private Bitmap[] frameMovimientoAv;//avanza
    private Bitmap[] frameParadoRe;//retrocede
    private Bitmap[] frameMovimientoRe;//retrocede
    private Bitmap frame;
    private int x, y;
    private int velocidad;
    private int indice = 0;
    private boolean avanza = true;
    private boolean pulsado = false;
    private boolean seMueve = false;
    private long tiempoF = System.currentTimeMillis();
    private long tiempoM = System.currentTimeMillis();
    private int tiempoFrame;
    private int tiempoMove;
    private int cantidadFrames;

    public Personaje(Bitmap[] frameMovimientoAV, Bitmap[] frameParadoAv, int x, int y, int velocidad) {
        this.frameParadoAv = frameParadoAv;
        this.frameMovimientoAv = frameMovimientoAV;
        this.frameParadoRe = new Bitmap[frameParadoAv.length];
        for (int i = 0; i < frameParadoAv.length; i++) {//lo invierte
            frameParadoRe[i] = espejo(frameParadoAv[i], true);
        }
        this.frameMovimientoRe = new Bitmap[frameMovimientoAv.length];
        for (int i = 0; i < frameParadoAv.length; i++) {//lo invierte
            frameMovimientoRe[i] = espejo(frameMovimientoAv[i], true);
        }
        this.frame = frameParadoAv[0];
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
        cantidadFrames = frameParadoAv.length;
        if (cantidadFrames > frameMovimientoAV.length) {
            cantidadFrames = frameMovimientoAV.length;
        }
        if (cantidadFrames > frameParadoRe.length) {
            cantidadFrames = frameParadoRe.length;
        }
        if (cantidadFrames > frameMovimientoRe.length) {
            cantidadFrames = frameMovimientoRe.length;
        }
    }

    public void setTiempoFrame(int tiempo) {
        tiempoFrame = tiempo;
    }

    public void setTiempoMove(int tiempo) {
        tiempoMove = tiempo;
    }

    public void cambiaFrame() {
        if ((System.currentTimeMillis() - tiempoF) > tiempoFrame) {
            if (indice >= cantidadFrames) {
                indice = 0;
            }
            if (avanza) {
                if (seMueve) {
                    frame = frameMovimientoAv[indice];
                } else {
                    frame = frameParadoAv[indice];
                }
            } else {
                if (seMueve) {
                    frame = frameMovimientoRe[indice];
                } else {
                    frame = frameParadoRe[indice];
                }
            }
            indice++;
            tiempoF = System.currentTimeMillis();
        }
    }

    public void move() {
        if ((System.currentTimeMillis() - tiempoM) > tiempoMove) {
            if (avanza) {
                if (seMueve) {
                    x += velocidad;
                    if (x>PantallaInicioView.anchoPantalla-frameParadoAv[0].getWidth()){
                        x=PantallaInicioView.anchoPantalla-frameParadoAv[0].getWidth();
                        seMueve=false;
                    }
                }
            } else {
                if (seMueve) {
                    x -= velocidad;
                    if (x<0){
                        x=0;
                        seMueve=false;
                    }
                }
            }
            tiempoM = System.currentTimeMillis();
        }
    }

    public void dibuja(Canvas canvas) {
        canvas.drawBitmap(frame, x, y, null);
    }

    public void isPulsado(float posX, float posY) {
        if (posX >= x && posX <= (x + frame.getWidth())
                && posY >= y && posY <= (y + frame.getHeight())) {
            if (!seMueve && pulsado) {
                avanza = !avanza;
                pulsado = false;
            } else if (!seMueve && !pulsado) {
                pulsado = true;
                seMueve = true;
            } else {
                seMueve = false;
                pulsado = true;
            }
        } else pulsado = false;
    }

    private Bitmap espejo(Bitmap imagen, Boolean horizontal) {
        Matrix matrix = new Matrix();
        if (horizontal) matrix.preScale(-1, 1);
        else matrix.preScale(1, -1);
        return Bitmap.createBitmap(imagen, 0, 0, imagen.getWidth(), imagen.getHeight(), matrix, false);
    }

    public Bitmap[] getFrameParadoAv() {
        return frameParadoAv;
    }

    public void setFrameParadoAv(Bitmap[] frameParadoAv) {
        this.frameParadoAv = frameParadoAv;
    }

    public Bitmap[] getFrameMovimientoAv() {
        return frameMovimientoAv;
    }

    public void setFrameMovimientoAv(Bitmap[] frameMovimientoAv) {
        this.frameMovimientoAv = frameMovimientoAv;
    }

    public Bitmap[] getFrameParadoRe() {
        return frameParadoRe;
    }

    public void setFrameParadoRe(Bitmap[] frameParadoRe) {
        this.frameParadoRe = frameParadoRe;
    }

    public Bitmap[] getFrameMovimientoRe() {
        return frameMovimientoRe;
    }

    public void setFrameMovimientoRe(Bitmap[] frameMovimientoRe) {
        this.frameMovimientoRe = frameMovimientoRe;
    }


    public Bitmap getFrame() {
        return frame;
    }

    public void setFrame(Bitmap frame) {
        this.frame = frame;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public boolean isAvanza() {
        return avanza;
    }

    public void setAvanza(boolean avanza) {
        this.avanza = avanza;
    }

    public boolean isPulsado() {
        return pulsado;
    }

    public void setPulsado(boolean pulsado) {
        this.pulsado = pulsado;
    }

    public boolean isSeMueve() {
        return seMueve;
    }

    public void setSeMueve(boolean seMueve) {
        this.seMueve = seMueve;
    }

    public long getTiempoF() {
        return tiempoF;
    }

    public void setTiempoF(long tiempoF) {
        this.tiempoF = tiempoF;
    }

    public long getTiempoM() {
        return tiempoM;
    }

    public void setTiempoM(long tiempoM) {
        this.tiempoM = tiempoM;
    }

    public int getTiempoFrame() {
        return tiempoFrame;
    }

    public int getTiempoMove() {
        return tiempoMove;
    }
}