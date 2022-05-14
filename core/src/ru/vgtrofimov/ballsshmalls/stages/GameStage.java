package ru.vgtrofimov.ballsshmalls.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.ballsshmalls.Balls;
import ru.vgtrofimov.ballsshmalls.actors.ActorBackground;
import ru.vgtrofimov.ballsshmalls.actors.ActorBall;
import ru.vgtrofimov.ballsshmalls.actors.ActorRacquet;
import ru.vgtrofimov.ballsshmalls.screens.GameScreen;
import ru.vgtrofimov.ballsshmalls.settings.Setup;
import ru.vgtrofimov.ballsshmalls.textures.Textures;

public class GameStage extends StageParent {

    Textures textures;
    int game_world_width, game_world_height;

    ActorBall actorBall;
    ActorRacquet actorRacquet;

    public GameStage(GameScreen gameScreen, Viewport viewport, OrthographicCamera camera, Textures textures) {
        super(gameScreen, viewport, camera);
        this.textures = textures;

        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        reset();
    }

    private void reset() {
        addActors();
    }

    private void addActors() {
        ActorBackground actorBackground = new ActorBackground(textures.getBackground());
        actorBall = new ActorBall(textures.getBall(), textures.getBall_shadow(),
                game_world_width / 2,
                game_world_height / 2,
                (int) (100 + Math.random() * 200),
                50,
                game_world_width,
                game_world_height);

        actorRacquet = new ActorRacquet(textures.getRacquet(), actorBall, game_world_width, game_world_height);
        actorBall.setActorRacquet(actorRacquet);

        addActor(actorBackground);
        addActor(actorRacquet);
        addActor(actorBall);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        int cam_pos_x = (int) (game_world_width / 2);
        int cam_pos_y = (int) (actorBall.getY());

        if (cam_pos_y > game_world_height - camera.viewportHeight / 2) {
            cam_pos_y = (int) (game_world_height - camera.viewportHeight / 2);
        } else if (cam_pos_y < camera.viewportHeight / 2) {
            cam_pos_y = (int) (camera.viewportHeight / 2);
        }

        camera.position.set(cam_pos_x, cam_pos_y, 0);
        camera.update();

    }

    @Override
    public void resize(int width, int height) {

        game_world_width = 512;
        game_world_height = textures.getBackground().getRegionHeight() * Setup.count_background;

        getViewport().setWorldWidth(game_world_width);
        getViewport().setWorldHeight(game_world_width * height / width);
        getViewport().update(game_world_width, game_world_width * height / width);
    }

    @Override
    public void draw() {
        super.draw();
    }
}
