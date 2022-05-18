package ru.vgtrofimov.nasharik.services;

public interface ReturnKey {

    public enum KEY_NAME {MENU, RESTART};

    public void pressKey(KEY_NAME key_name);

}
