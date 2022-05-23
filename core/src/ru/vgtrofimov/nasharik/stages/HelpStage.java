package ru.vgtrofimov.nasharik.stages;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.nasharik.Balls;
import ru.vgtrofimov.nasharik.actors.ActorBackground;
import ru.vgtrofimov.nasharik.actors.endgame.ActorKey;
import ru.vgtrofimov.nasharik.screens.GameScreen;
import ru.vgtrofimov.nasharik.services.Font;
import ru.vgtrofimov.nasharik.services.ReturnKey;
import ru.vgtrofimov.nasharik.settings.Setup;
import ru.vgtrofimov.nasharik.settings.Sound;
import ru.vgtrofimov.nasharik.textures.Textures;

public class HelpStage extends StageParent implements ReturnKey {

    Textures textures;
    int screen = 0;

    public HelpStage(GameScreen gameScreen, Setup setup, Font font, Viewport viewport, OrthographicCamera camera, Textures textures, Sound sound) {
        super(gameScreen, setup, font, sound, viewport, camera);
        this.textures = textures;

        ActorBackground actorBackground = new ActorBackground(textures.getBackground(), 3);
        addActor(actorBackground);

        int startY = (int) (camera.viewportHeight * 0.15f);

        int distance = (int) ((camera.viewportWidth + 96) / 4);

        ActorKey keyPrev = new ActorKey(this, KEY_NAME.KEY_PREVIOUS,
                textures.getHelpKeyPrevious(),
                (int) (camera.viewportWidth - distance * 3), (int) (camera.viewportHeight * 0.85f),
                96, 96);

        ActorKey keyStop = new ActorKey(this, KEY_NAME.KEY_STOP,
                textures.getHelpKeyStop(),
                (int) (camera.viewportWidth - distance * 2), (int) (camera.viewportHeight * 0.85f),
                96, 96);

        ActorKey keyNext = new ActorKey(this, KEY_NAME.KEY_NEXT,
                textures.getHelpKeyNext(),
                (int) (camera.viewportWidth - distance * 1), (int) (camera.viewportHeight * 0.85f),
                96, 96);

        addActor(keyPrev);
        addActor(keyStop);
        addActor(keyNext);

        setHelpScreen(screen);

    }

    private void setHelpScreen(int num) {

    }


    public void pressKey(KEY_NAME key_name) {
        sound.play(Sound.SOUND.CLICK_MENU);
        switch (key_name) {
            case KEY_PREVIOUS:
                break;
            case KEY_STOP:
                break;
            case KEY_NEXT:
                break;
        }
    }

    public void pressKey(int key_number) {

    }
}
