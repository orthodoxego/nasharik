package ru.vgtrofimov.ballsshmalls.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.ballsshmalls.Balls;
import ru.vgtrofimov.ballsshmalls.actors.ActorBackground;
import ru.vgtrofimov.ballsshmalls.screens.GameScreen;
import ru.vgtrofimov.ballsshmalls.textures.Textures;

public class GameStage extends StageParent {

    Textures textures;

    int z = 1;


    public GameStage(GameScreen gameScreen, Viewport viewport, OrthographicCamera camera, Textures textures) {
        super(gameScreen, viewport, camera);
        this.textures = textures;

        int w, h;
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        Balls.log(w + " " + h);

        getViewport().setWorldWidth(512);
        getViewport().setWorldHeight(512 * h / w);

        reset();
    }

    private void reset() {
        addActors();
    }

    private void addActors() {
        ActorBackground actorBackground = new ActorBackground(textures.getBackground());
        addActor(actorBackground);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        getCamera().position.set(256, 512 + z, 0);
        z += 1;
        camera.update();

    }
}
