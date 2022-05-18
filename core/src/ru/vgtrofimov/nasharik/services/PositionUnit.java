package ru.vgtrofimov.nasharik.services;

public class PositionUnit {
    public int x, y;
    public int code;
    public int teleportToX, teleportToY;

    public PositionUnit(int x, int y, int code) {
        this.x = x;
        this.y = y;
        this.code = code;
    }
}
