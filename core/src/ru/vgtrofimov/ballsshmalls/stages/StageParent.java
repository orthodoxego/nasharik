package ru.vgtrofimov.ballsshmalls.stages;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.ballsshmalls.screens.GameScreen;

public class StageParent extends Stage {

    GameScreen gameScreen;
    OrthographicCamera camera;

    public StageParent(GameScreen gameScreen, Viewport viewport, OrthographicCamera camera) {
        this.gameScreen = gameScreen;
        this.setViewport(viewport);
        this.camera = camera;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void end() {   }

    public void resize(int width, int height) { }


}