package ru.vgtrofimov.ballsshmalls.settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import ru.vgtrofimov.ballsshmalls.Balls;

public class Setup {

    public static final String APP_ID = "NASHARIK";
    public static final String FONT_CHARS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";

    // Сколько раз повторяется текстура (высота игрового мира)
    public static int count_background = 15;
    int recordScore;

    int level;

    public Setup() {
        this.level = 2;

        loadPrefs();
    }

    public void loadPrefs() {
        Preferences prefs = Gdx.app.getPreferences(APP_ID);
        recordScore = prefs.getInteger("ajg6256ghjb3hg134j", 0);
    }

    public void savePrefs() {
        Preferences prefs = Gdx.app.getPreferences(APP_ID);
        prefs.putInteger("ajg6256ghjb3hg134j", recordScore);
        prefs.flush();
    }

    public static int getCount_background() {
        return count_background;
    }

    public static void setCount_background(int count_background) {
        Setup.count_background = count_background;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRecordScore() {
        return recordScore;
    }

    public void setRecordScore(int recordScore) {
        this.recordScore = recordScore;
    }
}
