package ru.vgtrofimov.nasharik.settings;

import com.badlogic.gdx.Gdx;

public class Sound {

    public enum SOUND { CLICK_MENU,
        HAND,
        GRAB_FIGURE,
        BAD_RESULT,
        GOOD_RESULT,
        SPRING,
        RACQUET_SPRING,
        TELEPORT,
        START_LEVEL
    };


    Setup setup;
    boolean isSound;
    int maxSound = 10;
    public com.badlogic.gdx.audio.Sound[] soundMelody;

    // Music music;

    int currentPlay;

    public Sound(Setup setup) {
        this.setup = setup;
        currentPlay = 0;

        soundMelody = new com.badlogic.gdx.audio.Sound[maxSound];
        soundMelody[0] = Gdx.audio.newSound(Gdx.files.internal("sound/click_menu.ogg"));
        soundMelody[1] = Gdx.audio.newSound(Gdx.files.internal("sound/hand.ogg"));
        soundMelody[2] = Gdx.audio.newSound(Gdx.files.internal("sound/grab_figure.ogg"));
        soundMelody[3] = Gdx.audio.newSound(Gdx.files.internal("sound/bad_result.ogg"));
        soundMelody[4] = Gdx.audio.newSound(Gdx.files.internal("sound/good_result.ogg"));
        soundMelody[5] = Gdx.audio.newSound(Gdx.files.internal("sound/spring.ogg"));
        soundMelody[6] = Gdx.audio.newSound(Gdx.files.internal("sound/racquet_spring.ogg"));
        soundMelody[7] = Gdx.audio.newSound(Gdx.files.internal("sound/teleport.ogg"));
        soundMelody[8] = Gdx.audio.newSound(Gdx.files.internal("sound/startlevel.ogg"));

    }

    public boolean play(SOUND sound) {
        isSound = setup.getVolume() > 0;
        if (!isSound) return false;

        switch (sound) {
            case CLICK_MENU:
                soundMelody[0].stop();
                soundMelody[0].play(((0.01f * setup.getVolume()) * 0.9f));
                break;
            case HAND:
                soundMelody[1].stop();
                soundMelody[1].play(((0.01f * setup.getVolume()) * 0.4f));
                break;
            case GRAB_FIGURE:
                soundMelody[2].stop();
                soundMelody[2].play(((0.01f * setup.getVolume()) * 0.8f));
                break;
            case BAD_RESULT:
                soundMelody[3].stop();
                soundMelody[3].play(((0.01f * setup.getVolume()) * 0.3f));
                break;
            case GOOD_RESULT:
                soundMelody[4].stop();
                soundMelody[4].play(((0.01f * setup.getVolume()) * 0.9f));
                break;
            case SPRING:
                soundMelody[5].stop();
                soundMelody[5].play(((0.01f * setup.getVolume()) * 0.8f));
                break;
            case RACQUET_SPRING:
                soundMelody[6].stop();
                soundMelody[6].play(((0.01f * setup.getVolume()) * 0.5f));
                break;
            case TELEPORT:
                soundMelody[7].stop();
                soundMelody[7].play(((0.01f * setup.getVolume()) * 0.5f));
                break;
            case START_LEVEL:
                soundMelody[8].stop();
                soundMelody[8].play(((0.01f * setup.getVolume()) * 0.5f));
                break;
        }


        return true;
    }



    public void dispose() {
        for (int i = 0; i < maxSound; i++)
            soundMelody[i].dispose();
//        music.dispose();
    }
}
