package ru.vgtrofimov.ballsshmalls.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Vector;

import ru.vgtrofimov.ballsshmalls.Balls;
import ru.vgtrofimov.ballsshmalls.services.XY;
import ru.vgtrofimov.ballsshmalls.settings.GameConstant;
import ru.vgtrofimov.ballsshmalls.settings.Setup;

public class ActorShape extends Actor {

    TextureRegion skin;
    int number_shape;
    int score;
    boolean enabled = true;
    boolean scored = true;
    float angle = 0, max_angle = 45, count_angle = 66;
    float speedX, speedY;
    int correctX, correctY;
    int centerX, centerY, maxX, maxY;
    int widthScreen, heightScreen;

    Vector<XY> shadow_ball;
    float lifetime_for_shadow = 0;


    public ActorShape(TextureRegion skin, int number_shape, float x, float y, float speedX, float speedY, int maxX, int maxY, int widthScreen, int heightScreen) {
        this.skin = skin;
        this.number_shape = number_shape;
        this.speedX = speedX;
        this.speedY = speedY;
        this.maxX = maxX;
        this.maxY = maxY;
        this.centerX = (int) x;
        this.centerY = (int) y;
        this.widthScreen = widthScreen;
        this.heightScreen = heightScreen;
        setWidth(skin.getRegionWidth()); setHeight(skin.getRegionHeight());
        setX(x); setY(y);
        setScale(0.9f, 0.9f);
        setOrigin(getWidth() / 2, getHeight() / 2);
        setRotation(angle);
        correctX = (int) (getWidth() / 2); correctY = (int) (getHeight() / 2);
        angle = (float) (-max_angle + (Math.random() * max_angle * 2));

        shadow_ball = new Vector<>();
        shadow_ball.add(new XY(getX(), getY(), getScaleX(), getRotation()));
        lifetime_for_shadow = 0;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        setRotation(angle);
        angle += count_angle * delta;
        if (Math.abs(angle) > max_angle) {
            count_angle *= -1;
        }

        lifetime_for_shadow += delta;

        if (enabled) {
            move(delta);

            if (lifetime_for_shadow > GameConstant.TIME_TO_STEP_BALL) {
                lifetime_for_shadow = 0;
                if (shadow_ball.size() > 10) {
                    shadow_ball.remove(shadow_ball.size() - 1);
                }
                shadow_ball.insertElementAt(new XY(getX(), getY(), getScaleX(), getRotation()), 0);
            }

        } else {
            if (lifetime_for_shadow > GameConstant.TIME_TO_STEP_BALL * 5) {
                lifetime_for_shadow = 0;
                if (shadow_ball.size() > 0) {
                    shadow_ball.remove(shadow_ball.size() - 1);
                }
            }
        }
    }

    private void move(float delta) {

        setX(getX() + speedX * delta);
        setY(getY() + speedY * delta);
        check_coord(delta);
    }

    private void check_coord(float delta) {
        if (getX() > widthScreen - getWidth() || getX() < getWidth()
        || getX() > centerX + maxX || getX() < centerX - maxX) {
            setSpeedX(-getSpeedX());
            setX(getX() + getSpeedX() * delta);
        }

        if (getY() > heightScreen - getHeight() || getY() < getHeight() ||
        getY() > centerY + maxY || getY() < centerY - maxY) {
            setSpeedY(-getSpeedY());
            setY(getY() + speedY * delta);
        }


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (Setup.shadow) {
            for (int i = shadow_ball.size() - 1; i > -1; i--) {
                batch.setColor(1 - i / 10.0f, 1 - i / 30.0f, 1 - i / 10.0f, i / 15.0f);
                batch.draw(skin, shadow_ball.elementAt(i).getX() - correctX, shadow_ball.elementAt(i).getY() - correctY, getOriginX(), getOriginY(), getWidth(), getHeight(), shadow_ball.elementAt(i).getScale() * 2 - i / 5f, shadow_ball.elementAt(i).getScale() * 2 - i / 5f, getRotation());
            }
        }

        batch.setColor(1, 1, 1, parentAlpha);

        if (enabled) {
            batch.draw(skin, getX() - correctX, getY() - correctY, getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        }

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

    public int getNumber_shape() {
        return number_shape;
    }

    public boolean isCollision(ActorBall actorBall) {
        /** Проверка столкновения с шаром. */
        int a = (int) Math.abs(actorBall.getX() - getX());
        int b = (int) Math.abs(actorBall.getY() - getY());
        int c = (int) Math.pow(a * a + b * b, 0.5f);
        if (c < actorBall.getWidth() * 0.75f) {
            return true;
        }
        return false;
    }

    public boolean isReallyRemove() {
        return shadow_ball.size() == 0;
    }
}
