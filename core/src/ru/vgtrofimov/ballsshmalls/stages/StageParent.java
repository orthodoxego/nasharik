package ru.vgtrofimov.ballsshmalls.stages;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.ballsshmalls.screens.GameScreen;
import ru.vgtrofimov.ballsshmalls.settings.Setup;

public class StageParent extends Stage {
    Setup setup;
    GameScreen gameScreen;
    OrthographicCamera camera;
    boolean pause;

    public StageParent(GameScreen gameScreen, Setup setup, Viewport viewport, OrthographicCamera camera) {
        this.gameScreen = gameScreen;
        this.setup = setup;
        this.setViewport(viewport);
        this.camera = camera;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void end() {   }

    public void resize(int width, int height) { }

    public void setPause(boolean p) {
        this.pause = p;
    }

    public boolean isPause() {
        return pause;
    }
}