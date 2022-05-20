package ru.vgtrofimov.nasharik.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.nasharik.Balls;
import ru.vgtrofimov.nasharik.settings.Setup;
import ru.vgtrofimov.nasharik.settings.Sound;
import ru.vgtrofimov.nasharik.stages.EndStage;
import ru.vgtrofimov.nasharik.stages.GameStage;
import ru.vgtrofimov.nasharik.stages.MenuStage;
import ru.vgtrofimov.nasharik.stages.SelectLevelStage;
import ru.vgtrofimov.nasharik.stages.StageParent;
import ru.vgtrofimov.nasharik.textures.Textures;

public class GameScreen implements Screen {

    Balls balls;
    Setup setup;
    Sound sound;
    Viewport viewport;
    OrthographicCamera camera;
    AssetManager manager;

    StageParent currentStage;
    Textures textures;

    int score = 0;

    public GameScreen(Balls balls, Setup setup, Sound sound, Viewport viewport, OrthographicCamera camera, AssetManager manager, Textures textures) {
        this.balls = balls;
        this.setup = setup;
        this.sound = sound;
        this.viewport = viewport;
        this.camera = camera;
        this.manager = manager;
        this.textures = textures;

        int game_world_width = 512;
        int game_world_height = textures.getBackground().getRegionHeight() * Setup.count_background;

        camera.viewportWidth = game_world_width;
        camera.viewportHeight = game_world_width * (float) Gdx.graphics.getHeight() / Gdx.graphics.getWidth();
        camera.position.set(camera.viewportWidth / 2,camera.viewportHeight / 2, 0);
        camera.update();

        setGameStage();
        // setEndStage();
        // setMenuStage();
    }

    public void setGameStage() {
        setup.setScore(0);
        setup.setLevel(14);
        currentStage = null;
        currentStage = new GameStage(this, setup, viewport, camera, textures, sound);
        Gdx.input.setInputProcessor(currentStage);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
    }

    public void setSelectLevelStage() {
        currentStage = null;
        currentStage = new SelectLevelStage(this, setup, viewport, camera, textures, sound);
        Gdx.input.setInputProcessor(currentStage);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
    }

    public void setMenuStage() {
        currentStage = null;
        currentStage = new MenuStage(this, setup, viewport, camera, textures, sound);
        Gdx.input.setInputProcessor(currentStage);
        Gdx.input.setCatchKey(Input.Keys.BACK, false);
    }

    public void setEndStage() {
        currentStage = null;
        currentStage = new EndStage(this, setup, viewport, camera, textures, sound);
        Gdx.input.setInputProcessor(currentStage);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
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
        currentStage.setPause(true);
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

    public Textures getTextures() {
        return textures;
    }

    public void newTextures() {
        textures = new Textures(setup);
    }
}
