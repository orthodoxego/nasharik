package ru.vgtrofimov.ballsshmalls.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.vgtrofimov.ballsshmalls.Balls;

public class ActorFruit extends Actor {

    TextureRegion skin;
    TextureRegion background;
    int score;
    boolean enabled = true;
    boolean scored = true;
    float angle = 0, max_angle = 45, count_angle = 66;
    float speedX, speedY;
    int correctX, correctY;

    public ActorFruit(TextureRegion skin, TextureRegion background, float x, float y, float speedX, float speedY) {
        this.skin = skin;
        this.background = background;
        this.speedX = speedX;
        this.speedY = speedY;
        setWidth(skin.getRegionWidth()); setHeight(skin.getRegionHeight());
        setX(x); setY(y);
        setScale(0.75f, 0.75f);
        setOrigin(getWidth() / 2, getHeight() / 2);
        setRotation(angle);
        correctX = (int) (getWidth() / 2); correctY = (int) (getHeight() / 2);
        angle = (float) (-max_angle + (Math.random() * max_angle * 2));
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        setRotation(angle);
        angle += count_angle * delta;
        if (Math.abs(angle) > max_angle) {
            count_angle *= -1;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        // batch.draw(background, getX() - correctX, getY() - correctY, getOriginX(), getOriginY(), background.getRegionWidth(), background.getRegionHeight(), getScaleX() + 0.2f, getScaleY() + 0.2f, 0);
        batch.draw(skin, getX() - correctX, getY() - correctY, getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());


    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isScored() {
        return scored;
    }

    public void setScored(boolean scored) {
        this.scored = scored;
    }

    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }
}
