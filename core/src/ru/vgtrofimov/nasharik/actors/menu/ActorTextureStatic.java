package ru.vgtrofimov.nasharik.actors.menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorTextureStatic extends Actor {

    private TextureRegion region;
    boolean deleted = false;

    float alpha = 1.0f;

    public ActorTextureStatic(float x, float y, float width, float height, TextureRegion region) {
        this.region = region;
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setBounds(x, y, width, height);
        setRotation(0);
        setOrigin(width / 2, height / 2);
        setScale(1, 1);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.setColor(1.0f, 1.0f, 1.0f, alpha);
        batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());

        batch.setColor(1.0f, 1.0f, 1.0f, parentAlpha);
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setRegion(TextureRegion region) {
        this.region = region;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }



}
