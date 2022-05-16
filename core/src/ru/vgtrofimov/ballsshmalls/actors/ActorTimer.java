package ru.vgtrofimov.ballsshmalls.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.vgtrofimov.ballsshmalls.Balls;

public class ActorTimer extends Actor {
    TextureRegion[] skin;
    TextureRegion skin_blank;
    int frame;
    float timerFrame = 0.01f;
    float timerDelta = 0;
    int correctX, correctY;
    boolean enabled;
    boolean pressed = false;

    public ActorTimer(TextureRegion[] skin, TextureRegion skin_blank, int x, int y) {
        this.skin = skin;
        this.skin_blank = skin_blank;
        frame = skin.length - 1;
        setX(x);
        setY(y);
        setRotation(0);
        setWidth(skin[frame].getRegionWidth());
        setHeight(skin[frame].getRegionHeight() / 3.0f);
        setBounds(x, y, getWidth(), getHeight());
        setScale(1f, 1f);
        correctX = (int) (getWidth() / 2);
        correctY = (int) (getHeight() / 2);
        setOrigin(correctX, correctY);
        enabled = true;

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (pressed) {
            timerDelta += delta;
            if (timerDelta > timerFrame) {
                frame += 2;
                timerDelta = 0;
                if (frame >= skin.length) frame = 8;
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (pressed) {
            for (int i = 0; i <= frame; i++) {
                batch.draw(skin[i], getX() - correctX + i * skin[i].getRegionWidth(), getY() - correctY, getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
            }
        } else {
            batch.draw(skin_blank, getX() - correctX, getY() - correctY, getOriginX(), getOriginY(), getWidth() * 32, getHeight(), getScaleX(), getScaleY(), getRotation());
        }
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public int getFrame() {
        return frame;
    }

    public void setRandomFrame() {
        this.frame = 0;
        // this.frame = (int) (Math.random() * skin.length);
    }
}
