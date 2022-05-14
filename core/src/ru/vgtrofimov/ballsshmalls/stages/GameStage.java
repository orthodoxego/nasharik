package ru.vgtrofimov.ballsshmalls.stages;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.ballsshmalls.screens.GameScreen;
import ru.vgtrofimov.ballsshmalls.textures.Textures;

public class GameStage extends StageParent {

    Textures textures;

    public GameStage(GameScreen gameScreen, Viewport viewport, OrthographicCamera camera, Textures textures) {
        super(gameScreen, viewport, camera);
        this.textures = textures;
    }
}
