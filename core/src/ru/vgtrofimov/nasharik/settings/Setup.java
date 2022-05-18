package ru.vgtrofimov.nasharik.settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Setup {

    public static final String APP_ID = "NASHARIK";
    public static final String FONT_CHARS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";

    // Сколько раз повторяется текстура (высота игрового мира)
    public static int count_background = 15;
    int recordScore;
    int score;
    int level;

    public static boolean shadow;
    public static int theme;

    public Setup() {
        this.level = 0;
        this.score = 0;

        loadPrefs();
    }

    public void loadPrefs() {
        Preferences prefs = Gdx.app.getPreferences(APP_ID);
        recordScore = prefs.getInteger("ajg6256ghjb3hg134j", 0);
        shadow = prefs.getBoolean("kj828u2hjb3897y2h1", false);
        theme = prefs.getInteger("hjn2jbg1hjbHhvhUGB", 0);
    }

    public void savePrefs() {
        Preferences prefs = Gdx.app.getPreferences(APP_ID);
        prefs.putInteger("ajg6256ghjb3hg134j", recordScore);
        prefs.putBoolean("kj828u2hjb3897y2h1", shadow);
        prefs.putInteger("hjn2jbg1hjbHhvhUGB", theme);
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
