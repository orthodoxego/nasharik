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
    int volume;
    int skin;
    String[] skinName;
    boolean help;

    public static boolean shadow;
    public static int theme;

    public Setup() {
        this.level = 0;
        this.score = 0;
        this.skinName = getSkinName();

        loadPrefs();
    }

    public void loadPrefs() {
        Preferences prefs = Gdx.app.getPreferences(APP_ID);
        recordScore = prefs.getInteger("ajg6256ghjb3hg134j", 0);
        shadow = prefs.getBoolean("kj828u2hjb3897y2h1", false);
        help = prefs.getBoolean("bbnwjhjushuh2jqpoj", false);
        theme = prefs.getInteger("hjn2jbg1hjbHhvhUGB", 0);
        volume = prefs.getInteger("jkoqopwoii919287iq", 30);
        skin = prefs.getInteger("jqywopwoii919287iq", 0);
    }

    public void savePrefs() {
        Preferences prefs = Gdx.app.getPreferences(APP_ID);
        prefs.putInteger("ajg6256ghjb3hg134j", recordScore);
        prefs.putBoolean("kj828u2hjb3897y2h1", shadow);
        prefs.putBoolean("bbnwjhjushuh2jqpoj", help);
        prefs.putInteger("hjn2jbg1hjbHhvhUGB", theme);
        prefs.putInteger("jkoqopwoii919287iq", volume);
        prefs.putInteger("jqywopwoii919287iq", skin);
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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }


    public String getHelpStr() {
        if (help) return "Пояснить за игру: да";
        return "Описание выключено";
    }

    public String getSkinStr() {
        return "Скин: " + skinName[skin];
    }

    public void incSkin() {
        skin += 1;
        if (skin >= skinName.length) skin = 0;
    }

    public int getSkin() {
        return skin;
    }

    public void helpOnOff() {
        help = !help;
    }

    private String[] getSkinName() {
        // return new String[]{"базовый", "тёмный", "пузырьки"};
        return new String[]{"базовый", "камни"};
    }

    public String[] getMessageSkin() {
        String[] ret = new String[3];;
        if (skin == 0) {
            ret[0] = "";
            ret[1] = "Анимация: Андрей Фролов";
            ret[2] = "(c) 2022 Виктор Трофимов";
        } else if (skin == 1) {
            ret[0] = "";
            ret[1] = "";
            ret[2] = "(c) 2022 Виктор Трофимов";
        } else if (skin == 2) {
            ret[0] = "";
            ret[1] = "";
            ret[2] = "(c) 2022 Виктор Трофимов";
        }
        return ret;
    }

    public void shadowOnOff() {
        shadow = !shadow;
    }

    public String getShadowStr() {
        if (shadow)
            return "Следы: есть";
        return "Следы: нет";
    }
}
