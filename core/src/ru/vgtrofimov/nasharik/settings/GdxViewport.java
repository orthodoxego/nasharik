package ru.vgtrofimov.nasharik.settings;

public class GdxViewport {

    public static final float WORLD_WIDTH = 512f;
    public static final float WORLD_HEIGHT = 1024f;
    public static final float FIXED_BLOCK = WORLD_WIDTH / 25;
    public static float TOP;
    public static float BOTTOM;
    public static float HEIGHT;
    public static float RATIO, RATIO_HORIZONTAL;

    public static void resize(int width, int height) {
        RATIO_HORIZONTAL = (float) WORLD_WIDTH / width;
        RATIO = (float) height / width;
        float viewportHeight = WORLD_WIDTH * RATIO;

        BOTTOM = (WORLD_HEIGHT - viewportHeight) / 2;
        TOP = BOTTOM + viewportHeight;
        HEIGHT = TOP - BOTTOM;
    }


}
