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
import ru.vgtrofimov.nasharik.settings.Sound;

public class ActorTextKey extends Actor {

    BitmapFont bitmapFont;
    Sound sound;
    String msg;
    TextureRegion ico;
    TextureRegion lineShrink;
    ReturnKey returnKey;
    ReturnKey.KEY_NAME key_name;
    int icoCenterY;
    boolean enabled;

    public ActorTextKey(final ReturnKey returnKey, final Sound sound, BitmapFont bitmapFont, String msg, TextureRegion ico, TextureRegion lineShrink, int x, int y, final ReturnKey.KEY_NAME key_name, boolean enabled) {
        this.bitmapFont = bitmapFont;
        this.sound = sound;
        this.returnKey = returnKey;
        this.msg = msg;
        this.ico = ico;
        this.lineShrink = lineShrink;
        this.key_name = key_name;
        this.enabled = enabled;
        setX(x); setY(y);

        GlyphLayout gl = new GlyphLayout();
        gl.setText(bitmapFont, msg);
        setWidth(ico.getRegionWidth() + gl.width);
        setHeight(ico.getRegionHeight() + gl.height);
        icoCenterY = (int) (getY() + (16 - gl.height) / 2);
        setBounds(x, y, 512, getHeight());

        setTouchable(Touchable.enabled);
        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (isEnabled()) {
                    returnKey.pressKey(key_name);
                } else {
                    sound.play(Sound.SOUND.BAD_RESULT);
                }
                return true;
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (!enabled) {
            batch.setColor(0.5f, 0.7f, 0.8f, 0.75f);
            batch.draw(ico, getX(), icoCenterY, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
            bitmapFont.setColor(0.5f, 0.7f, 0.8f, 0.75f);
            bitmapFont.draw(batch, msg, getX() + ico.getRegionWidth(), getY());
            bitmapFont.setColor(1, 1, 1, parentAlpha);
            batch.setColor(1, 1, 1, parentAlpha);
            batch.draw(lineShrink, getX() + 50, icoCenterY + 15, getOriginX(), getOriginY(), 256, 6, getScaleX(), getScaleY(), getRotation());
        } else {
            batch.draw(ico, getX(), icoCenterY, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
            bitmapFont.draw(batch, msg, getX() + ico.getRegionWidth(), getY());
        }
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

    public void setBitmapFont(BitmapFont bitmapFont) {
        this.bitmapFont = bitmapFont;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setLineShrink(TextureRegion lineShrink) {
        this.lineShrink = lineShrink;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
