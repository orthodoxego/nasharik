package ru.vgtrofimov.nasharik.services;

public interface ReturnKey {

    public enum KEY_NAME {MENU, RESTART, MENU_START_GAME, MENU_SELECT_SKIN, MENU_VOLUME};

    public void pressKey(KEY_NAME key_name);

}
