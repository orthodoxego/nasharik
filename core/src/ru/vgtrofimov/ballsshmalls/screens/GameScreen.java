package ru.vgtrofimov.ballsshmalls.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.ballsshmalls.Balls;

public class GameScreen implements Screen {

    Balls balls;
    Viewport viewport;
    OrthographicCamera camera;
    AssetManager manager;
    Stage currentStage;

    public GameScreen(Balls balls, Viewport viewport, OrthographicCamera camera, AssetManager manager) {
        this.balls = balls;
        this.viewport = viewport;
        this.camera = camera;
        this.manager = manager;

        setCurrentStage();
    }

    private void setCurrentStage() {
        currentStage = null;


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        /** Отрисует текущую сцену Stage. **/

        camera.update();
        ScreenUtils.clear(0, 0, 0, 1);

        currentStage.act(delta);
        currentStage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
