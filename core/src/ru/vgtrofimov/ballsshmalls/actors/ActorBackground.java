package ru.vgtrofimov.ballsshmalls.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.vgtrofimov.ballsshmalls.settings.Setup;

public class ActorBackground extends Actor {

    TextureRegion skin;

    public ActorBackground(TextureRegion skin) {
        this.skin = skin;
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
        for (int i = 0; i < Setup.count_background; i++) {
            batch.draw(skin, getX(), getY() + i * getWidth(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        }
    }
}
