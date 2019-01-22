package com.peleadegallos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PantallaInicio extends PlantillaPantalla {
    public PantallaInicio(JuegoPrincipal juego) {
        super(juego);

    }

    private Stage escenario;

    @Override
    public void show() {
        escenario=new Stage();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 0);//Color fondo
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);//reinicia color de la grafica
    }

    @Override
    public void hide() {
        escenario.dispose();
    }
}
