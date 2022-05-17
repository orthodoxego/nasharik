package ru.vgtrofimov.ballsshmalls.actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ActorMine extends ActorShape {
    public ActorMine(TextureRegion skin, int number_shape, float x, float y, float speedX, float speedY, int maxX, int maxY, int widthScreen, int heightScreen) {
        super(skin, number_shape, x, y, speedX, speedY, maxX, maxY, widthScreen, heightScreen);
    }
}
