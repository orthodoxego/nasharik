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
    float velocity, gravity, default_velocity = 98;
    float speed_rotate = 360, default_rotate = 360;

    public ActorBall(TextureRegion skin, TextureRegion shadow, int x, int y, int speedX, int speedY, int world_width, int world_height) {
        this.skin = skin;
        this.shadow = shadow;
        setWidth(skin.getRegionWidth());
        setHeight(skin.getRegionWidth());
        correctX = (int) (getWidth() / 2);
        correctY = (int) (getHeight() / 2);
        setRotation(default_rotate);
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
        gravity = 0.1f;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        setRotation(getRotation() + delta * getSpeedY() + 5);

        setY(getY() + getSpeedY() * delta);
        //Balls.log("" + getSpeedY());

        check_move_balls(delta);
    }

    private boolean check_move_balls(float delta) {
        if (getSpeedY() == 0) return false;

        setSpeedY(getSpeedY() + velocity * delta);

        if (getY() + getHeight() > world_height) {
            setY(world_height - getHeight());
            setSpeedY(-getSpeedY() * 0.95f);
            speed_rotate = default_rotate;

            if (Math.abs(getSpeedY()) < world_height * gravity / 32) setSpeedY(0);

        }
        if (getY() < 0) {
            setY(0);
            setSpeedY(-getSpeedY() * 1.2f);
            speed_rotate = default_rotate;
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
