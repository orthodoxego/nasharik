package ru.vgtrofimov.ballsshmalls.stages;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.ballsshmalls.screens.GameScreen;

public class GameStage extends StageParent {
    public GameStage(GameScreen gameScreen, Viewport viewport, OrthographicCamera camera) {
        super(gameScreen, viewport, camera);
    }
}
