package ru.vgtrofimov.ballsshmalls.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.vgtrofimov.ballsshmalls.Balls;

public class ActorBall extends Actor {

    TextureRegion skin;
    TextureRegion shadow;
    int correctX, correctY;
    float speedX, speedY, default_speed_x, default_speed_y;
    int world_width, world_height;
    float velocity, default_velocity = 19.8f;
    float gravity = 0.98f;
    float massa = 10f;
    float uprugost = 50f;

    public ActorBall(TextureRegion skin, TextureRegion shadow, int x, int y, int speedX, int speedY, int world_width, int world_height) {
        this.skin = skin;
        this.shadow = shadow;
        setWidth(skin.getRegionWidth());
        setHeight(skin.getRegionWidth());
        correctX = (int) (getWidth() / 2);
        correctY = (int) (getHeight() / 2);
        setRotation(0);
        setX(x);
        setY(y);
        setBounds(x, y, getWidth(), getHeight());
        setOrigin(32, 32);
        setScale(1, 1);
        this.default_speed_x = speedX;
        this.default_speed_y = speedY;
        setSpeedX(default_speed_x);
        setSpeedY(default_speed_y);
        this.world_width = world_width;
        this.world_height = world_height;
        velocity = default_velocity;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (getSpeedY() != 0)
            setRotation(getRotation() + delta * getSpeedY() + 5);

        setY(getY() + getSpeedY() * delta);
        //Balls.log("" + getSpeedY());

        check_move_balls(delta);
    }

    private boolean check_move_balls(float delta) {
        if (getSpeedY() == 0) return false;

        setSpeedY(getSpeedY() + velocity + massa * gravity);
        // velocity *= gravity;

        if (getY() + getHeight() > world_height) {
            setY(world_height - getHeight());
            setSpeedY((float) (-getSpeedY() * Math.sqrt(uprugost) / massa));
            velocity = default_velocity;

            if (Math.abs(getSpeedY()) < world_height * 0.035f) setSpeedY(0);

        }
        if (getY() < 0) {
            setY(0);
            velocity = default_velocity;
            setSpeedY(-getSpeedY());
        }

        return true;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.setColor(0.1f, 0.2f, 0, parentAlpha / 2);
        batch.draw(skin, getX() - correctX + 8, getY() - correctY + 8, getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.setColor(1, 1, 1, parentAlpha);
        batch.draw(skin, getX() - correctX, getY() - correctY, getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.draw(shadow, getX() - correctX, getY() - correctY, getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), 0);
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
