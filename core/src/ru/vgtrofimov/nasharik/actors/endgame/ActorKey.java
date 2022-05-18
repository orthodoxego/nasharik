package ru.vgtrofimov.nasharik.actors.endgame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import ru.vgtrofimov.nasharik.Balls;
import ru.vgtrofimov.nasharik.services.ReturnKey;

public class ActorKey extends Actor {
    ReturnKey returnKey;
    ReturnKey.KEY_NAME key_name;
    TextureRegion skin;
    int x, y, width, height;

    public ActorKey(final ReturnKey returnKey, final ReturnKey.KEY_NAME key_name, TextureRegion skin, int x, int y, int width, int height) {
        this.returnKey = returnKey;
        this.key_name = key_name;
        this.skin = skin;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setBounds(x, y, width, height);
        setRotation(0);
        setScale(1, 1);

        setTouchable(Touchable.enabled);
        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                returnKey.pressKey(key_name);
                return true;
            }
        });

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(skin, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }
}
