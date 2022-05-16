package ru.vgtrofimov.ballsshmalls.settings;

public class Setup {

    public static final String APP_ID = "BALLS_SHMALLS";
    public static final String FONT_CHARS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";

    // Сколько раз повторяется текстура (высота игрового мира)
    public static int count_background = 15;

    int level;

    public Setup() {
        this.level = 0;
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
}
