package ru.vgtrofimov.nasharik.stages;

import com.badlogic.gdx.Input;
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
import ru.vgtrofimov.nasharik.settings.Sound;
import ru.vgtrofimov.nasharik.textures.Textures;

public class EndGameStage extends StageParent implements ReturnKey, InputProcessor {

    Textures textures;

    public EndGameStage(GameScreen gameScreen, Setup setup, Viewport viewport, OrthographicCamera camera, Textures textures, Sound sound) {
        super(gameScreen, setup, sound, viewport, camera);
        this.textures = textures;

        // resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        resize((int) viewport.getWorldWidth(), (int) viewport.getWorldHeight());
        Balls.log(getClass().getName(), "" + viewport.getWorldWidth() + " " + viewport.getWorldHeight());

        ActorBackground actorBackground = new ActorBackground(textures.getBackground(), 3);
        addActor(actorBackground);

        int startY = (int) (camera.viewportHeight * 0.15f);

        ActorText text01 = new ActorText(Font.play_bold_big, "" + setup.getScore(),
                ActorText.ADJUST.CENTER,
                (int) camera.viewportWidth);
        text01.setY(startY);

        ActorText text02 = new ActorText(Font.play_bold_14px, "Рекорд: " + setup.getRecordScore(),
                ActorText.ADJUST.CENTER,
                (int) camera.viewportWidth);
        startY += text01.getHeightText() * 1.2f;
        text02.setY(startY);

        ActorText text03 = new ActorText(Font.play_regular_14px, "ПРИМИТЕ ПОЗДРАВЛЕНИЯ!",
                ActorText.ADJUST.CENTER,
                (int) camera.viewportWidth);
        startY += text03.getHeightText() * 5.2f;
        text03.setY(startY);

        ActorText text04 = new ActorText(Font.play_regular_little, "Все уровни пройдены, игра сыграна. Надеюсь,",
                ActorText.ADJUST.CENTER,
                (int) camera.viewportWidth);
        startY += text04.getHeightText() * 5f;
        text04.setY(startY);

        ActorText text05 = new ActorText(Font.play_regular_little, "что время не потрачено зря. Если хотите новых",
                ActorText.ADJUST.CENTER,
                (int) camera.viewportWidth);
        startY += text05.getHeightText() * 2.2f;
        text05.setY(startY);

        ActorText text06 = new ActorText(Font.play_regular_little, "уровней, то, пожалуйста, поставьте хорошую",
                ActorText.ADJUST.CENTER,
                (int) camera.viewportWidth);
        startY += text06.getHeightText() * 2.2f;
        text06.setY(startY);

        ActorText text07 = new ActorText(Font.play_regular_little, "оценку в маркете и напишите, что понравилось",
                ActorText.ADJUST.CENTER,
                (int) camera.viewportWidth);
        startY += text07.getHeightText() * 2.2f;
        text07.setY(startY);

        ActorText text08 = new ActorText(Font.play_regular_little, "больше всего! Счастья Вам и Вашим близким!",
                ActorText.ADJUST.CENTER,
                (int) camera.viewportWidth);
        startY += text08.getHeightText() * 2.2f;
        text08.setY(startY);

        ActorText text09 = new ActorText(Font.play_regular_little, "Виктор Трофимов",
                ActorText.ADJUST.RIGHT,
                (int) camera.viewportWidth);
        startY += text09.getHeightText() * 4.2f;
        text09.setY(startY);

        addActor(text01);
        addActor(text02);
        addActor(text03);
        addActor(text04);
        addActor(text05);
        addActor(text06);
        addActor(text07);
        addActor(text08);
        addActor(text09);

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

        setup.setOpenAllLevel(true);
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
            case MENU:
                gameScreen.setMenuStage();
                break;
            case RESTART:
                setup.setLevel(setup.getLevel() - 1);
                gameScreen.setSelectLevelStage();
                break;
        }
        sound.play(Sound.SOUND.CLICK_MENU);
    }

    @Override
    public void pressKey(int key_number) {

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
