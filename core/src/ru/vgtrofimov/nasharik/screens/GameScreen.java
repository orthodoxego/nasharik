package ru.vgtrofimov.nasharik.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.nasharik.Balls;
import ru.vgtrofimov.nasharik.settings.Setup;
import ru.vgtrofimov.nasharik.stages.EndGameStage;
import ru.vgtrofimov.nasharik.stages.GameStage;
import ru.vgtrofimov.nasharik.stages.StageParent;
import ru.vgtrofimov.nasharik.textures.Textures;

public class GameScreen implements Screen {

    Balls balls;
    Setup setup;
    Viewport viewport;
    OrthographicCamera camera;
    AssetManager manager;

    StageParent currentStage;
    Textures textures;

    int score = 0;

    public GameScreen(Balls balls, Setup setup, Viewport viewport, OrthographicCamera camera, AssetManager manager, Textures textures) {
        this.balls = balls;
        this.setup = setup;
        this.viewport = viewport;
        this.camera = camera;
        this.manager = manager;
        this.textures = textures;


        // setNewGameStage();
        setEndGameStage();
    }

    public void setNewGameStage() {
        currentStage = null;
        currentStage = new GameStage(this, setup, viewport, camera, textures);
        Gdx.input.setInputProcessor(currentStage);
    }

    public void setEndGameStage() {
        currentStage = null;
        currentStage = new EndGameStage(this, setup, viewport, camera, textures);
        Gdx.input.setInputProcessor(currentStage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        /* Отрисует текущую сцену Stage. */

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
        currentStage.setPause(true);
    }

    @Override
    public void resume() {
        currentStage.setPause(false);
    }


    @Override
    public void hide() {
    }

    @Override
    public void dispose() {

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setInputListener() {
        Gdx.input.setInputProcessor(currentStage);
    }
}
