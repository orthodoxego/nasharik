package ru.vgtrofimov.nasharik.actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ActorSpring extends ActorShape {
    public ActorSpring(TextureRegion skin, int number_shape, float x, float y, float speedX, float speedY, int maxX, int maxY, int widthScreen, int heightScreen) {
        super(skin, number_shape, x, y, speedX, speedY, maxX, maxY, widthScreen, heightScreen);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (getScaleX() > 1) {
            setScale(getScaleX() * 0.98f, getScaleX() * 0.95f);
        } else {
            setScale(1, 1);
        }

    }
}
