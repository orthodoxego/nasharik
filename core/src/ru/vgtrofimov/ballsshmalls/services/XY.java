package ru.vgtrofimov.ballsshmalls.services;

public class XY {
    float x, y;
    float scale;
    float rotation;

    public XY() {}

    public XY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public XY(float x, float y, float scale) {
        this.x = x;
        this.y = y;
        this.scale = scale;
    }

    public XY(float x, float y, float scale, float rotation) {
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.rotation = rotation;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}
