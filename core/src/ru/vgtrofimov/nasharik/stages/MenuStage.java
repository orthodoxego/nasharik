package ru.vgtrofimov.nasharik.stages;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.nasharik.Balls;
import ru.vgtrofimov.nasharik.actors.ActorBackground;
import ru.vgtrofimov.nasharik.actors.menu.ActorLittleText;
import ru.vgtrofimov.nasharik.actors.menu.ActorTextKey;
import ru.vgtrofimov.nasharik.actors.menu.ActorTextureStatic;
import ru.vgtrofimov.nasharik.screens.GameScreen;
import ru.vgtrofimov.nasharik.services.Font;
import ru.vgtrofimov.nasharik.services.ReturnKey;
import ru.vgtrofimov.nasharik.settings.Setup;
import ru.vgtrofimov.nasharik.settings.Sound;
import ru.vgtrofimov.nasharik.textures.Textures;

public class MenuStage extends StageParent implements ReturnKey, InputProcessor {

    Textures textures;

    ActorBackground actorBackground;

    ActorTextKey menuStart;
    ActorTextKey menuSkin;
    ActorTextKey menuVolume;
    ActorTextKey menuHelp;
    ActorTextKey menuShadow;

    ActorLittleText actorLittleText;
    ActorTextureStatic actorTextureStatic;

    public MenuStage(GameScreen gameScreen, Setup setup, Font font, Viewport viewport, OrthographicCamera camera, Textures textures, Sound sound) {
        super(gameScreen, setup, font, sound, viewport, camera);
        this.textures = textures;

        resize((int) viewport.getWorldWidth(), (int) viewport.getWorldHeight());
        Balls.log(getClass().getName(), "" + viewport.getWorldWidth() + " " + viewport.getWorldHeight());

        actorBackground = new ActorBackground(textures.getBackground(), 3);
        addActor(actorBackground);

        int startX = 64;
        int startY = (int) (viewport.getWorldHeight() / 2 * 0.7f);
        int lineHeight = 75;

        actorTextureStatic = new ActorTextureStatic(0, 50, 512, 256, textures.getNasharik());
        addActor(actorTextureStatic);

        menuStart = new ActorTextKey(this, sound, font.play_regular_14px, "Играть",
                textures.getMenuStartGame(), textures.getBlackHole(),
                startX, startY,
                KEY_NAME.MENU_START_GAME,
                Math.max(0, setup.getMax_level()) >= setup.getSkin() * 2 || setup.isOpenAllLevel());

        menuSkin = new ActorTextKey(this, sound, font.play_regular_14px, setup.getSkinStr(),
                textures.getMenuSkin(), textures.getWinHole(),
                startX, startY + lineHeight,
                KEY_NAME.MENU_SELECT_SKIN,
                true);

        menuVolume = new ActorTextKey(this, sound, font.play_regular_14px, "Громкость: " + setup.getVolume(),
                textures.getMenuVolume(), textures.getWinHole(),
                startX, startY + lineHeight * 2,
                KEY_NAME.MENU_VOLUME,
                true);

        menuShadow = new ActorTextKey(this, sound, font.play_regular_14px, setup.getShadowStr(),
                textures.getMenuShadow(), textures.getWinHole(),
                startX, startY + lineHeight * 3,
                KEY_NAME.MENU_SHADOW,
                true);

        if (setup.isViewHelp()) {
            menuHelp = new ActorTextKey(this, sound, font.play_regular_14px, setup.getHelpStr(),
                    textures.getMenuHelp(), textures.getWinHole(),
                    startX, startY + lineHeight * 4,
                    KEY_NAME.MENU_HELP,
                    true);
        }

        actorLittleText = new ActorLittleText(sound,
                font.play_regular_little,
                textures.getBlackHole(),
                setup.getMessageSkin(),
                setup.getHref(),
                startX,
                (int) (viewport.getWorldHeight() - 200));


        addActor(menuStart);
        addActor(menuSkin);
        addActor(menuVolume);
        addActor(menuShadow);
        if (setup.isViewHelp()) addActor(menuHelp);
        addActor(actorLittleText);

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
                gameScreen.setSelectLevelStage();
                break;
            case MENU_SELECT_SKIN:
                setup.incSkin();
                actorLittleText.setMsg(setup.getMessageSkin());
                actorLittleText.setHref(setup.getHref());
                menuSkin.setMsg(setup.getSkinStr());
                gameScreen.newTextures();
                textures = gameScreen.getTextures();
                refreshTexture();
                break;
            case MENU_VOLUME:
                int vol = setup.getVolume();
                vol += 5;
                if (vol > 100) vol = 0;
                setup.setVolume(vol);
                menuVolume.setMsg("Громкость: " + setup.getVolume());
                break;
            case MENU_SHADOW:
                setup.shadowOnOff();
                menuShadow.setMsg(setup.getShadowStr());
                break;
            case MENU_HELP:
                setup.helpOnOff();
                menuHelp.setMsg(setup.getHelpStr());
                break;
        }
        sound.play(Sound.SOUND.CLICK_MENU);
    }

    @Override
    public void pressKey(int key_number) {

    }

    private void refreshTexture() {

        font = new Font(setup.getSkin());
        gameScreen.setFont(font);

        actorBackground.setSkin(textures.getBackground());
        actorTextureStatic.setRegion(textures.getNasharik());
        menuStart.setIco(textures.getMenuStartGame());
        menuShadow.setIco(textures.getMenuShadow());

        if (menuHelp != null) menuHelp.setIco(textures.getMenuHelp());
        menuSkin.setIco(textures.getMenuSkin());

        menuStart.setMsg("Играть");
        menuVolume.setIco(textures.getMenuVolume());
        menuVolume.setMsg("Громкость: " + setup.getVolume());

        menuStart.setBitmapFont(font.play_regular_14px);
        menuShadow.setBitmapFont(font.play_regular_14px);
        if (menuHelp != null) menuHelp.setBitmapFont(font.play_regular_14px);
        menuSkin.setBitmapFont(font.play_regular_14px);
        menuVolume.setBitmapFont(font.play_regular_14px);

        actorLittleText.setBitmapFont(font.play_regular_little);
        actorLittleText.setBackground(textures.getBlackHole());

        menuStart.setEnabled(Math.max(0, setup.getMax_level()) >= setup.getSkin() * 2 || setup.isOpenAllLevel());
        menuStart.setLineShrink(textures.getBlackHole());

    }
}
