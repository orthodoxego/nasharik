package ru.vgtrofimov.nasharik.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Timer;
import java.util.Vector;

import ru.vgtrofimov.nasharik.Balls;
import ru.vgtrofimov.nasharik.actors.ActorBackground;
import ru.vgtrofimov.nasharik.actors.endgame.ActorKey;
import ru.vgtrofimov.nasharik.actors.help.ActorHelpScreen;
import ru.vgtrofimov.nasharik.screens.GameScreen;
import ru.vgtrofimov.nasharik.services.Font;
import ru.vgtrofimov.nasharik.services.ReturnKey;
import ru.vgtrofimov.nasharik.settings.Setup;
import ru.vgtrofimov.nasharik.settings.Sound;
import ru.vgtrofimov.nasharik.textures.Textures;

public class HelpStage extends StageParent implements ReturnKey {

    Textures textures;
    int screen = 0;
    ActorHelpScreen actorHelpScreen;
    ActorKey keyNext;
    float timer;

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

        addActor(keyPrev);
        addActor(keyStop);

        setHelpScreen(screen);

    }

    private void addKeyNext() {
        int distance = (int) ((camera.viewportWidth + 96) / 4);
        keyNext = new ActorKey(this, KEY_NAME.KEY_NEXT,
                textures.getHelpKeyNext(),
                (int) (camera.viewportWidth - distance), (int) (camera.viewportHeight * 0.85f),
                96, 96);
        addActor(keyNext);
    }

    private void setHelpScreen(int num) {

        timer = 0;
        if (keyNext != null) {
            keyNext.remove();
            keyNext = null;
        }

        if (actorHelpScreen != null) {
            actorHelpScreen.remove();
            actorHelpScreen = null;
        }

        Vector<String> msg = new Vector<>();
        if (num == 0) {
            msg.add("Привет!");
            msg.add("");
            msg.add("В игре нужно управлять шариком");
            msg.add("и выбивать им фигуры в заданном порядке.");
            msg.add("");
            msg.add("Коснись краёв экрана, удержи и отпусти,");
            msg.add("чтобы корректировать движение шара.");
            msg.add("");
            msg.add("Площадка отбивает шар автоматически.");
        } else if (num == 1) {
            msg.add("Управляй шариком так, чтобы выбивать");
            msg.add("фигуры в указанном в верхнем левом");
            msg.add("углу экрана порядке!");
            msg.add("");
            msg.add("Ошибка может дорогого стоить:");
            msg.add("уровень начнётся заново.");
            msg.add("");
            msg.add("У тебя три попытки на прохождение игры.");
        } else if (num == 2) {
            msg.add("Также тебе встретятся пружина,");
            msg.add("которая инвертирует движение шара,");
            msg.add("\"телепорт\" и \"волшебная палочка\",");
            msg.add("меняюшая местами фигуры на поле!");
            msg.add("");
            msg.add("Удачи тебе и успехов!");
        } else if (num == 3) {
            setup.setViewHelp(true);
            setup.setHelp(false);
            setup.savePrefs();
            gameScreen.setGameStage();
        }

        if (num != 3) {
            actorHelpScreen = new ActorHelpScreen(msg, textures.getHelpScreens()[num], font.play_regular_little,
                    0, (int) (getViewport().getWorldHeight() * 0.02f), 512);
            addActor(actorHelpScreen);
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (keyNext == null) {
            timer += delta;
            if (timer > 3 || setup.isViewHelp()) {
                if (!setup.isViewHelp()) sound.play(Sound.SOUND.HAND);
                addKeyNext();
            }
        }
    }

    public void pressKey(KEY_NAME key_name) {
        sound.play(Sound.SOUND.CLICK_MENU);
        switch (key_name) {
            case KEY_PREVIOUS:
                if (screen == 0) {
                    gameScreen.setMenuStage();
                } else {
                    screen -= 1;
                    setHelpScreen(screen);
                }
                break;
            case KEY_STOP:
                gameScreen.setMenuStage();
                break;
            case KEY_NEXT:
                if (screen == 5) {
                    gameScreen.setMenuStage();
                } else {
                    screen += 1;
                    setHelpScreen(screen);
                }
                break;
        }
    }

    public void pressKey(int key_number) {

    }
}
