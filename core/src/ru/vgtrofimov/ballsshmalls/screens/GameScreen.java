package ru.vgtrofimov.ballsshmalls.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.ballsshmalls.Balls;
import ru.vgtrofimov.ballsshmalls.settings.Setup;
import ru.vgtrofimov.ballsshmalls.stages.GameStage;
import ru.vgtrofimov.ballsshmalls.stages.StageParent;
import ru.vgtrofimov.ballsshmalls.textures.Textures;

public class GameScreen implements Screen {

    Balls balls;
    Setup setup;
    Viewport viewport;
    OrthographicCamera camera;
    AssetManager manager;
    StageParent currentStage;
    Textures textures;

    public GameScreen(Balls balls, Setup setup, Viewport viewport, OrthographicCamera camera, AssetManager manager, Textures textures) {
        this.balls = balls;
        this.setup = setup;
        this.viewport = viewport;
        this.camera = camera;
        this.manager = manager;
        this.textures = textures;

        setCurrentStage();
    }

    private void setCurrentStage() {
        currentStage = null;
        currentStage = new GameStage(this, setup, viewport, camera, textures);

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
        currentStage.resize(width, height);
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
