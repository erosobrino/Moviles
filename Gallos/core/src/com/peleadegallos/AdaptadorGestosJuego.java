package com.peleadegallos;

import com.badlogic.gdx.InputAdapter;

public class AdaptadorGestosJuego extends InputAdapter {

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        System.out.println("deslizar dedo");
        return true;
    }
}
