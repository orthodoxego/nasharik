package ru.vgtrofimov.nasharik.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Vector;

import ru.vgtrofimov.nasharik.services.XY;
import ru.vgtrofimov.nasharik.settings.GameConstant;
import ru.vgtrofimov.nasharik.settings.Setup;

public class ActorCircleEffect extends Actor {
    /** Кручение текстуры относительно центра с увеличением. */

    TextureRegion skin;
    float lifetime = 0;
    float alphaChannel = 1;
    float scale = 2f;
    boolean enabled = true;

    Vector<XY> shadow_ball;
    float lifetime_for_shadow = 0;

    public ActorCircleEffect(TextureRegion skin, int x, int y) {
        this.skin = skin;
        setX(x); setY(y);
        setWidth(skin.getRegionWidth()); setHeight(skin.getRegionHeight());
        setOrigin(getWidth() / 2, getHeight() / 2);
        setScale(scale, scale);

        shadow_ball = new Vector<>();
        shadow_ball.add(new XY(getX(), getY(), getScaleX(), getRotation()));
        lifetime_for_shadow = 0;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        lifetime += delta;

        setRotation(getRotation() + delta * 640);
        if (getRotation() > 360) setRotation(0);

        if (lifetime < 0.2f) {
            alphaChannel += delta * 4;
            if (alphaChannel > 1) alphaChannel = 1;
            scale -= delta / 3;
        } else if (lifetime < 0.4f) {
            scale -= delta * 5;
            if (scale < 0.1f) scale = 0.1f;

        } else if (lifetime < 0.6f) {
            alphaChannel -= delta * 2;
            if (alphaChannel < 0) alphaChannel = 0;
        } else {
            enabled = false;
        }

        if (scale > 1) scale = 1;
        if (scale < 0) scale = 0;
        setScale(scale, scale);


        lifetime_for_shadow += delta;
        if (lifetime_for_shadow > GameConstant.TIME_TO_STEP_BALL) {
            lifetime_for_shadow = 0;
            if (shadow_ball.size() > 20) {
                shadow_ball.remove(shadow_ball.size() - 1);
            }
            shadow_ball.insertElementAt(new XY(getX(), getY(), getScaleX(), getRotation()), 0);
        }

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (Setup.shadow) {
            for (int i = 0; i < shadow_ball.size(); i++) {
                batch.setColor(1 - i * 0.05f, 1 - i * 0.02f, 1 - i * 0.05f, 0.5f - i * 0.04f);
                batch.draw(skin, shadow_ball.elementAt(i).getX(), shadow_ball.elementAt(i).getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), shadow_ball.elementAt(i).getScale()  * 1.2f - i * 0.01f, shadow_ball.elementAt(i).getScale() * 1.2f - i * 0.01f, shadow_ball.elementAt(i).getRotation());
            }
        }


        batch.setColor(1, 1, 1, alphaChannel);
        batch.draw(skin, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.setColor(1, 1, 1, 1);
    }

    public boolean isEnabled() {
        return enabled;
    }
}
