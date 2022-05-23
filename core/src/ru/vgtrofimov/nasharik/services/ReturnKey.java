package ru.vgtrofimov.nasharik.services;

public interface ReturnKey {

    public enum KEY_NAME {MENU,
        RESTART,
        MENU_START_GAME,
        MENU_SELECT_SKIN,
        MENU_VOLUME,
        MENU_HELP,
        MENU_SHADOW,
        KEY_PREVIOUS,
        KEY_STOP,
        KEY_NEXT
    };

    public void pressKey(KEY_NAME key_name);

    public void pressKey(int key_number);

}
