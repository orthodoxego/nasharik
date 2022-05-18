package ru.vgtrofimov.nasharik.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.nasharik.Balls;
import ru.vgtrofimov.nasharik.actors.ActorBackground;
import ru.vgtrofimov.nasharik.actors.endgame.ActorKey;
import ru.vgtrofimov.nasharik.actors.endgame.ActorText;
import ru.vgtrofimov.nasharik.screens.GameScreen;
import ru.vgtrofimov.nasharik.services.Font;
import ru.vgtrofimov.nasharik.services.ReturnKey;
import ru.vgtrofimov.nasharik.settings.Setup;
import ru.vgtrofimov.nasharik.textures.Textures;

public class EndStage extends StageParent implements ReturnKey, InputProcessor {

    Textures textures;

    public EndStage(GameScreen gameScreen, Setup setup, Viewport viewport, OrthographicCamera camera, Textures textures) {
        super(gameScreen, setup, viewport, camera);
        this.textures = textures;

        // resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        resize((int) viewport.getWorldWidth(), (int) viewport.getWorldHeight());
        Balls.log(getClass().getName(), "" + viewport.getWorldWidth() + " " + viewport.getWorldHeight());

        ActorBackground actorBackground = new ActorBackground(textures.getBackground(), 3);
        addActor(actorBackground);

        int startY = (int) (camera.viewportHeight * 0.75f / 2);

        ActorText text01 = new ActorText(Font.play_bold_big, "" + setup.getScore(),
                ActorText.ADJUST.CENTER,
                (int) camera.viewportWidth);
        text01.setY(startY);

        ActorText text02 = new ActorText(Font.play_bold_14px, "Рекорд: " + setup.getRecordScore(),
                ActorText.ADJUST.CENTER,
                (int) camera.viewportWidth);
        startY += text01.getHeightText() * 1.2f;
        text02.setY(startY);

        addActor(text01);
        addActor(text02);

        startY += text02.getHeightText() * 4;

        ActorKey keyRestart = new ActorKey(this, KEY_NAME.RESTART,
                textures.getKeyRestart(),
                150, startY,
                96, 96);

        ActorKey keyMenu = new ActorKey(this, KEY_NAME.MENU,
                textures.getKeyMenu(),
                (int) camera.viewportWidth - 246, startY,
                96, 96);

        addActor(keyRestart);
        addActor(keyMenu);
    }

    @Override
    public void resize(int width, int height) {
        // ОБЯЗАТЕЛЬНО В КАЖДЫЙ РЕСАЙЦ!

        // Balls.log("RESIZE EndGS " + width + " " + height);

        int game_world_width = 512;
        int game_world_height = textures.getBackground().getRegionHeight() * Setup.count_background;

        /*
        getViewport().setScreenWidth(game_world_width);
        getViewport().setScreenHeight((int) (game_world_width * (float) height / width));
        getViewport().update(game_world_width, game_world_width * height / width);

         */

        camera.viewportWidth = game_world_width;
        camera.viewportHeight = game_world_width * (float) height / width;
        camera.position.set(camera.viewportWidth / 2,camera.viewportHeight / 2, 0);
        camera.update();

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void pressKey(KEY_NAME key_name) {
        switch (key_name) {
            case MENU:
                gameScreen.setMenuStage();
                break;
            case RESTART:
                gameScreen.setGameStage();
                break;
        }
    }


}
