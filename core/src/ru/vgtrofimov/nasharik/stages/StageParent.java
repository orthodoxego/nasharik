package ru.vgtrofimov.nasharik.stages;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.nasharik.screens.GameScreen;
import ru.vgtrofimov.nasharik.settings.Setup;
import ru.vgtrofimov.nasharik.settings.Sound;

public class StageParent extends Stage {
    Setup setup;
    Sound sound;
    GameScreen gameScreen;
    OrthographicCamera camera;
    boolean pause;

    public StageParent(GameScreen gameScreen, Setup setup, Sound sound, Viewport viewport, OrthographicCamera camera) {
        this.gameScreen = gameScreen;
        this.setup = setup;
        this.sound = sound;
        this.setViewport(viewport);
        this.camera = camera;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void end() {   }

    public void resize(int width, int height) {
    }

    public void setPause(boolean p) {
        this.pause = p;
    }

    public boolean isPause() {
        return pause;
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }
}