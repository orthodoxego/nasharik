package ru.vgtrofimov.nasharik.settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import ru.vgtrofimov.nasharik.Balls;

public class Setup {

    public static final String APP_ID = "NASHARIK";
    public static final String FONT_CHARS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
    public static final int level_in_game = 20;

    // Сколько раз повторяется текстура (высота игрового мира)
    public static int count_background = 15;
    int recordScore;
    int score;
    int max_level;
    int level;
    int volume;
    int skin;
    String[] skinName;
    boolean help, viewHelp;
    boolean openAllLevel;

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
        help = prefs.getBoolean("bbnwjhjushuh2jqpoj", true);
        viewHelp = prefs.getBoolean("bbnbjhjushuh3jqpoj", false);
        theme = prefs.getInteger("hjn2jbg1hjbHhvhUGB", 0);
        volume = prefs.getInteger("jkoqopwoii919287iq", 30);
        skin = prefs.getInteger("jqywopwoii919287iq", 0);
        max_level = prefs.getInteger("jqywomwoiir1928wiq", 0);
        openAllLevel = prefs.getBoolean("jqywomqattr1928wiq", false);
    }

    public void savePrefs() {
        Preferences prefs = Gdx.app.getPreferences(APP_ID);
        prefs.putInteger("ajg6256ghjb3hg134j", recordScore);
        prefs.putBoolean("kj828u2hjb3897y2h1", shadow);
        prefs.putBoolean("bbnwjhjushuh2jqpoj", help);
        prefs.putBoolean("bbnbjhjushuh3jqpoj", viewHelp);
        prefs.putBoolean("jqywomqattr1928wiq", openAllLevel);
        prefs.putInteger("hjn2jbg1hjbHhvhUGB", theme);
        prefs.putInteger("jkoqopwoii919287iq", volume);
        prefs.putInteger("jqywopwoii919287iq", skin);
        prefs.putInteger("jqywomwoiir1928wiq", max_level);

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
        if (level - 1 > max_level) max_level = level - 1;
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
        if (help) return "Инструкция: вкл.";
        return "Инструкция: выкл.";
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
        return new String[]{"питомцы", "c_ball the cat", "самоцветы", "море", "8 бит", "геометрия"};
    }

    public String[] getDir() {
        return new String[] {"pets", "cyberball", "stone", "sea", "pixel", "base"};
    }

    public String getHref() {
        String[] href = new String[] {"https://www.instagram.com/elwaaart/", "https://instagram.com/ataman_cg/", "", "", "", ""};
        return href[skin];
    }

    public String[] getMessageSkin() {
        String[] ret = new String[3];;
        if (skin == 0) {
            ret[0] = "";
            ret[1] = "Автор скина: Эля";
            ret[2] = "Задизайнить? Instagram: @elwaaart";
        } else if (skin == 1) {
            ret[0] = "";
            ret[1] = "Автор скина: Aliaksei Krachko";
            ret[2] = "Обращайтесь в Instagram: @ataman_cg";
        } else if (skin == 2) {
            ret[0] = "";
            ret[1] = "";
            ret[2] = "";
        } else if (skin == 3) {
            ret[0] = "";
            ret[1] = "";
            ret[2] = "";
        } else if (skin == 4) {
            ret[0] = "";
            ret[1] = "";
            ret[2] = "";
        } else if (skin == 5) {
            ret[0] = "";
            ret[1] = "";
            ret[2] = "";
        }

        if (Math.max(0, getMax_level()) < getSkin() * 2 && !isOpenAllLevel()) {
            ret[0] = "Вам нужно завершить уровень " + getSkin() * 2;
        }

        return ret;
    }

    public void shadowOnOff() {
        shadow = !shadow;
    }

    public String getShadowStr() {
        if (shadow) {
            return "Эффекты: есть";
        }
        return "Эффекты: нет";
    }

    public int getMax_level() {
        return max_level;
    }

    public void setOpenAllLevel(boolean b) {
        this.openAllLevel = b;
    }

    public boolean isOpenAllLevel() {
        return this.openAllLevel;
    }

    public boolean isHelp() {
        return help;
    }

    public void setHelp(boolean help) {
        this.help = help;
    }

    public boolean isViewHelp() {
        return viewHelp;
    }

    public void setViewHelp(boolean viewHelp) {
        this.viewHelp = viewHelp;
    }
}
