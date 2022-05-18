package ru.vgtrofimov.nasharik.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorBackground extends Actor {

    TextureRegion skin;
    int count_background;

    public ActorBackground(TextureRegion skin, int count_background) {
        this.skin = skin;
        this.count_background = count_background;
        setX(0);
        setY(0);
        setWidth(skin.getRegionWidth());
        setHeight(skin.getRegionHeight());
        setOrigin(1, 1);
        setRotation(0);
        setScale(1, 1);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        for (int i = 0; i < count_background; i++) {
            batch.draw(skin, getX(), getY() + i * getWidth(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        }
    }
}
