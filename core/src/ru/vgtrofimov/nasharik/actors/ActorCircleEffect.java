package ru.vgtrofimov.nasharik.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorCircleEffect extends Actor {
    /** Кручение текстуры относительно центра с увеличением. */

    TextureRegion skin;
    float lifetime = 0;
    float alphaChannel = 1;
    float scale = 2f;
    boolean enabled = true;


    public ActorCircleEffect(TextureRegion skin, int x, int y) {
        this.skin = skin;
        setX(x); setY(y);
        setWidth(skin.getRegionWidth()); setHeight(skin.getRegionHeight());
        setOrigin(getWidth() / 2, getHeight() / 2);
        setScale(scale, scale);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        lifetime += delta;

        setRotation(getRotation() + delta * 1440 * lifetime);
        if (getRotation() > 360) setRotation(0);

        if (lifetime < 0.2f) {
            alphaChannel += delta * 3;
            if (alphaChannel > 1) alphaChannel = 1;

            scale -= delta * 4;

        } else if (lifetime < 0.4f) {

            scale -= delta * 5;
            if (scale < 0.1f) scale = 0.1f;
            setScale(scale, scale);

        } else if (lifetime < 0.8f) {
            alphaChannel -= delta * 2;
            if (alphaChannel < 0) alphaChannel = 0;
        } else {
            enabled = false;
        }

        if (scale > 1) scale = 1;
        if (scale < 0) scale = 0;
        setScale(scale, scale);


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.setColor(1, 1, 1, alphaChannel);
        batch.draw(skin, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.setColor(1, 1, 1, 1);
    }

    public boolean isEnabled() {
        return enabled;
    }
}
