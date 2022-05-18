package ru.vgtrofimov.nasharik.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.nasharik.actors.ActorBackground;
import ru.vgtrofimov.nasharik.screens.GameScreen;
import ru.vgtrofimov.nasharik.settings.Setup;
import ru.vgtrofimov.nasharik.textures.Textures;

public class EndGameStage extends StageParent {

    Textures textures;

    public EndGameStage(GameScreen gameScreen, Setup setup, Viewport viewport, OrthographicCamera camera, Textures textures) {
        super(gameScreen, setup, viewport, camera);
        this.textures = textures;

        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        ActorBackground actorBackground = new ActorBackground(textures.getBackground(), 3);
        addActor(actorBackground);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

}
