package ru.vgtrofimov.nasharik.actors.menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import ru.vgtrofimov.nasharik.services.ReturnKey;

public class ActorTextKey extends Actor {

    BitmapFont bitmapFont;
    String msg;
    TextureRegion ico;
    ReturnKey returnKey;
    ReturnKey.KEY_NAME key_name;
    int icoCenterY;

    public ActorTextKey(final ReturnKey returnKey, BitmapFont bitmapFont, String msg, TextureRegion ico, int x, int y, final ReturnKey.KEY_NAME key_name) {
        this.bitmapFont = bitmapFont;
        this.returnKey = returnKey;
        this.msg = msg;
        this.ico = ico;
        this.key_name = key_name;
        setX(x); setY(y);

        GlyphLayout gl = new GlyphLayout();
        gl.setText(bitmapFont, msg);
        setWidth(ico.getRegionWidth() + gl.width);
        setHeight(ico.getRegionHeight() + gl.height);
        icoCenterY = (int) (getY() + (16 - gl.height) / 2);
        setBounds(x, y, getWidth() + ico.getRegionWidth(), getHeight());

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
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(ico, getX(), icoCenterY, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        bitmapFont.draw(batch, msg, getX() + ico.getRegionWidth(), getY());
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setIco(TextureRegion ico) {
        this.ico = ico;
    }
}
