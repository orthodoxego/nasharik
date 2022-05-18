package ru.vgtrofimov.nasharik.stages;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.nasharik.Balls;
import ru.vgtrofimov.nasharik.actors.ActorBackground;
import ru.vgtrofimov.nasharik.actors.menu.ActorTextKey;
import ru.vgtrofimov.nasharik.actors.menu.ActorTextureStatic;
import ru.vgtrofimov.nasharik.screens.GameScreen;
import ru.vgtrofimov.nasharik.services.Font;
import ru.vgtrofimov.nasharik.services.ReturnKey;
import ru.vgtrofimov.nasharik.settings.Setup;
import ru.vgtrofimov.nasharik.textures.Textures;

public class MenuStage extends StageParent implements ReturnKey, InputProcessor {

    Textures textures;

    ActorTextKey menuStart;
    ActorTextKey menuSkin;
    ActorTextKey menuVolume;

    public MenuStage(GameScreen gameScreen, Setup setup, Viewport viewport, OrthographicCamera camera, Textures textures) {
        super(gameScreen, setup, viewport, camera);
        this.textures = textures;

        resize((int) viewport.getWorldWidth(), (int) viewport.getWorldHeight());
        Balls.log(getClass().getName(), "" + viewport.getWorldWidth() + " " + viewport.getWorldHeight());

        ActorBackground actorBackground = new ActorBackground(textures.getBackground(), 3);
        addActor(actorBackground);

        int startX = 96;
        int startY = (int) (viewport.getWorldHeight() / 2 * 0.7f);
        int lineHeight = 75;

        addActor(new ActorTextureStatic(0, 50, 512, 256, textures.getNasharik()));

        menuStart = new ActorTextKey(this, Font.play_regular_14px, "Играть",
                textures.getMenuStartGame(),
                startX, startY,
                KEY_NAME.MENU_START_GAME);

        menuSkin = new ActorTextKey(this, Font.play_regular_14px, "Скин: базовый",
                textures.getMenuSkin(),
                startX, startY + lineHeight * 1,
                KEY_NAME.MENU_SELECT_SKIN);

        menuVolume = new ActorTextKey(this, Font.play_regular_14px, "Громкость: " + setup.getVolume(),
                textures.getMenuVolume(),
                startX, startY + lineHeight * 2,
                KEY_NAME.MENU_VOLUME);


        addActor(menuStart);
        addActor(menuSkin);
        addActor(menuVolume);

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
        switch (key_name) {
            case MENU_START_GAME:
                gameScreen.setGameStage();
                break;
            case MENU_SELECT_SKIN:
                break;
            case MENU_VOLUME:
                int vol = setup.getVolume();
                vol += 5;
                if (vol > 100) vol = 0;
                setup.setVolume(vol);
                menuVolume.setMsg("Громкость: " + setup.getVolume());
                break;
        }
    }
}
