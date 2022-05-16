package ru.vgtrofimov.ballsshmalls.settings;

public class Task {

    /**
     * Хранит один элемент в цепочке для сбора последовательности.
     */

    int number_shape;
    boolean grabbed;

    public Task(int number_shape, boolean grabbed) {
        this.number_shape = number_shape;
        this.grabbed = grabbed;
    }

    public int getNumber_shape() {
        return number_shape;
    }

    public void setNumber_shape(int number_shape) {
        this.number_shape = number_shape;
    }

    public boolean isGrabbed() {
        return grabbed;
    }

    public void setGrabbed(boolean grabbed) {
        this.grabbed = grabbed;
    }
}
