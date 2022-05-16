package ru.vgtrofimov.ballsshmalls.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.vgtrofimov.ballsshmalls.stages.GameStage;

public class ActorLeftHand extends Actor {

    ActorBall actorBall;
    TextureRegion skin;
    boolean pressed = true;
    boolean enabled = true;
    float time_to_death = 0;
    float timeToPressed = 0;

    public ActorLeftHand(ActorBall actorBall, TextureRegion skin, int x, int y) {
        this.actorBall = actorBall;
        this.skin = skin;
        setX(x); setY(y); // setBounds(getX(), getY(), skin.getRegionWidth(), skin.getRegionHeight());
        setWidth(skin.getRegionWidth()); setHeight(skin.getRegionHeight());
        setOrigin(getWidth(), getHeight() / 2); setScale(1, 1);
        setRotation(-33);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (!isPressed() && time_to_death > 0) {
            time_to_death -= delta;
            if (time_to_death <= 0) {
                enabled = false;
            }
        }

        if (isPressed() && isEnabled()) {
            timeToPressed += delta;
            if (timeToPressed > 1.5f) {
                enabled = false;
            }
            setRotation(getRotation() - timeToPressed);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(skin, getX() - timeToPressed * 10, getY() - timeToPressed * 10, getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setTime_to_death(float time_to_death) {
        if (time_to_death > 0) {
            setRotation(-10);
            actorBall.setSpeedY(actorBall.getSpeedY() - (int) (timeToPressed * GameStage.game_world_height * 0.1f));
            actorBall.setSpeedX(actorBall.getSpeedX() + (int) (timeToPressed * GameStage.game_world_width));
        }
        this.time_to_death = time_to_death;
        timeToPressed = 0;
    }
}
