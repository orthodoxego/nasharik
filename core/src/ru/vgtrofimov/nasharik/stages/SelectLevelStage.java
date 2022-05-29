package ru.vgtrofimov.nasharik.stages;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Vector;

import ru.vgtrofimov.nasharik.Balls;
import ru.vgtrofimov.nasharik.actors.ActorBackground;
import ru.vgtrofimov.nasharik.actors.menu.ActorLittleText;
import ru.vgtrofimov.nasharik.actors.menu.ActorTextKey;
import ru.vgtrofimov.nasharik.actors.menu.ActorTextureStatic;
import ru.vgtrofimov.nasharik.actors.selectlevel.ActorSelectLevel;
import ru.vgtrofimov.nasharik.screens.GameScreen;
import ru.vgtrofimov.nasharik.services.Font;
import ru.vgtrofimov.nasharik.services.ReturnKey;
import ru.vgtrofimov.nasharik.settings.Setup;
import ru.vgtrofimov.nasharik.settings.Sound;
import ru.vgtrofimov.nasharik.textures.Textures;

public class SelectLevelStage extends StageParent implements ReturnKey, InputProcessor {

    Textures textures;
    ActorBackground actorBackground;

    Vector<ActorSelectLevel> actorSelectLevels;


    public SelectLevelStage(GameScreen gameScreen, Setup setup, Font font, Viewport viewport, OrthographicCamera camera, Textures textures, Sound sound) {
        super(gameScreen, setup, font, sound, viewport, camera);
        this.textures = textures;

        resize((int) viewport.getWorldWidth(), (int) viewport.getWorldHeight());

        actorBackground = new ActorBackground(textures.getBackground(), 3);
        addActor(actorBackground);

        actorSelectLevels = new Vector<>();
        int count_in_line = 5;
        int startY = (int) ((viewport.getWorldHeight() - 140 * Setup.level_in_game / count_in_line) / 2);

        for (int i = 0; i < Setup.level_in_game / count_in_line; i++) {
            for (int j = 0; j < count_in_line; j++) {
                actorSelectLevels.add(new ActorSelectLevel(this, setup, sound,
                        font.play_regular_little,
                        font.play_bold_14px,
                        "Уровень",
                        textures.getBall(),
                        28 + j * 96, startY + i * 150,
                        i * count_in_line + j + 1));
                addActor(actorSelectLevels.lastElement());
            }
        }

    }


    @Override
    public void resize(int width, int height) {
        // ОБЯЗАТЕЛЬНО В КАЖДЫЙ РЕСАЙЦ!
        int game_world_width = 512;
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
    }



    @Override
    public void pressKey(int key_number) {
        setup.setLevel(key_number - 1);
        gameScreen.setGameStage();
    }

    @Override
    public boolean keyDown(int keyCode) {
        if (keyCode == Input.Keys.BACK || keyCode == Input.Keys.ESCAPE) {
            sound.play(Sound.SOUND.CLICK_MENU);
            gameScreen.setMenuStage();
        }
        return true;
    }

}
