package ru.vgtrofimov.ballsshmalls.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.ballsshmalls.screens.GameScreen;
import ru.vgtrofimov.ballsshmalls.settings.Setup;

public class EndGameStage extends StageParent {

    public EndGameStage(GameScreen gameScreen, Setup setup, Viewport viewport, OrthographicCamera camera) {
        super(gameScreen, setup, viewport, camera);

        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

}
