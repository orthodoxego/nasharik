package ru.vgtrofimov.nasharik.stages;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Vector;

import ru.vgtrofimov.nasharik.Balls;
import ru.vgtrofimov.nasharik.actors.ActorShapeLine;
import ru.vgtrofimov.nasharik.actors.help.ActorHelpStaticTime;
import ru.vgtrofimov.nasharik.actors.menu.ActorTextureStatic;
import ru.vgtrofimov.nasharik.screens.GameScreen;
import ru.vgtrofimov.nasharik.services.Font;
import ru.vgtrofimov.nasharik.settings.Levels;
import ru.vgtrofimov.nasharik.settings.Setup;
import ru.vgtrofimov.nasharik.settings.Sound;
import ru.vgtrofimov.nasharik.textures.Textures;

public class GameHelpStage extends GameStage {

    ActorHelpStaticTime helpTexture;

    public GameHelpStage(GameScreen gameScreen, Setup setup, Font font, Viewport viewport, OrthographicCamera camera, Textures textures, Sound sound) {
        super(gameScreen, setup, font, viewport, camera, textures, sound);
    }

    @Override
    public void addShapes(Levels lev) {
        super.addShapes(lev);
        addHelp();
    }

    @Override
    public void softReset() {
        if (helpTexture != null) {
            helpTexture.remove();
            helpTexture = null;
        }
        super.softReset();
    }

    public void addHelp() {
        if (setup.isHelp()) {
            if (helpTexture == null) {
                helpTexture = new ActorHelpStaticTime(this, 0, 3, 0, 0, 512, 192, textures.getHelp01());
                helpTexture.correctY = -64;
                addActor(helpTexture);
            } else if (helpTexture.getNumHelp() == 0) {
                helpTexture = null;
                helpTexture = new ActorHelpStaticTime(this, 1, 3, 0, 0, 512, 256, textures.getHelp02());
                helpTexture.correctY = 196;
                addActor(helpTexture);
            } else if (helpTexture.getNumHelp() == 1) {
                helpTexture = null;
                helpTexture = new ActorHelpStaticTime(this, 2, 2, 0, 0, 512, 64, textures.getHelp03());
                helpTexture.correctY = 196;
                addActor(helpTexture);
            } else if (helpTexture.getNumHelp() == 2) {
                setup.setHelp(false);
            }
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (!pause && helpTexture != null) {
            if (helpTexture.getNumHelp() == 0 || helpTexture.getNumHelp() == 2 ) {
                helpTexture.setX(helpTexture.getX());
                helpTexture.setY((int) (camera.position.y - helpTexture.correctY));
            } else if (helpTexture.getNumHelp() == 1) {
                helpTexture.setX(helpTexture.getX());
                helpTexture.setY((int) (camera.position.y - getViewport().getWorldHeight() / 2));
            }

            if (helpTexture.isDeleted()) {
                helpTexture.remove();
                addHelp();
            }
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if (helpTexture != null) {
            helpTexture.setTouch(true);
        }

        return super.touchDown(screenX, screenY, pointer, button);
    }
}
