package ru.vgtrofimov.nasharik.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.vgtrofimov.nasharik.settings.Sound;

public class ActorCat extends Actor {

    TextureRegion textureRegion;
    enum MOVE { HELLO, PAUSE, DOWN, CANCEL};
    MOVE state;
    float alpha = 0;
    boolean enabled;
    int movingY = 0;
    Sound sound;
    float pause = 2.4f;

    public ActorCat(TextureRegion textureRegion, Sound sound, int x, int y, int width, int height) {
        this.textureRegion = textureRegion;
        this.sound = sound;
        setX(x); setY(y); setWidth(width); setHeight(height);
        setBounds(x, y, width, height);
        setRotation(0); setScale(1, 1);
        enabled = true;
        state = MOVE.HELLO;

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        switch (state) {
            case HELLO:
                movingY += delta * 128;
                alpha += delta;
                if (alpha >= 1) alpha = 1;
                if (movingY > 120) {
                    movingY = 128;
                    sound.play(Sound.SOUND.CAT);
                    state = MOVE.PAUSE;
                }
                break;
            case PAUSE:
                pause -= delta;
                if (pause <= 0) state = MOVE.DOWN;
                break;
            case DOWN:
                movingY -= delta * 64;
                alpha -= delta;
                if (alpha <= 0) alpha = 0;
                if (movingY < 0) {
                    movingY = 0;
                    state = MOVE.CANCEL;
                }
                break;
            case CANCEL:
                enabled = false;
                break;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.setColor(1, 1, 1, alpha);
        batch.draw(textureRegion, getX(), getY() - movingY, getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.setColor(1, 1, 1, 1);
    }

    public boolean isEnabled() {
        return enabled;
    }
}
