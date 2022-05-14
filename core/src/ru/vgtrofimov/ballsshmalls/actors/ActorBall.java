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
    float massa = 8f;
    float uprugost = 50f;
    ActorRacquet actorRacquet;


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
            setRotation(getRotation() + delta * getSpeedX() * 3);

        setY(getY() + getSpeedY() * delta);
        setX(getX() + getSpeedX() * delta);
        //Balls.log("" + getSpeedY());

        check_move_balls(delta);
    }

    private boolean check_move_balls(float delta) {
        if (getSpeedY() == 0) return false;

        setSpeedY(getSpeedY() + velocity + massa * gravity);

        if (getY() + getHeight() > world_height - skin.getRegionHeight()) {
            setY(world_height - getHeight() - skin.getRegionHeight() - getHeight() / 2);
            setSpeedY((float) (-getSpeedY() * Math.sqrt(uprugost) / massa));
            velocity = default_velocity;

            if (Math.abs(getSpeedY()) < world_height * 0.03f) setSpeedY(0);
            actorRacquet.setY_correct_to_fire(getHeight() / 2);

        }
        if (getY() < 0) {
            setY(0);
            velocity = default_velocity;
            setSpeedY(-getSpeedY());
        }

        if (getX() < skin.getRegionWidth() / 2) {
            setX(skin.getRegionWidth() / 2);
            setSpeedX(-getSpeedX() * gravity);
        }

        if (getX() > world_width - skin.getRegionWidth() / 2) {
            setX(world_width - skin.getRegionWidth() / 2);
            setSpeedX(-getSpeedX() * gravity);
        }

        if (Math.abs(getSpeedY()) < world_width * 0.001f)
            setSpeedX(0);

        return true;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.setColor(0.1f, 0.2f, 0, parentAlpha / 2);
        batch.draw(skin, getX() - correctX + 3, getY() - correctY + 3, getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
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

    public void setActorRacquet(ActorRacquet ar) {
        this.actorRacquet = ar;
    }
}
