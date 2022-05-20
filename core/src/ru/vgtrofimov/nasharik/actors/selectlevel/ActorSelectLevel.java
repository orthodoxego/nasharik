package ru.vgtrofimov.nasharik.actors.selectlevel;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import ru.vgtrofimov.nasharik.Balls;
import ru.vgtrofimov.nasharik.services.ReturnKey;
import ru.vgtrofimov.nasharik.settings.Setup;
import ru.vgtrofimov.nasharik.settings.Sound;

public class ActorSelectLevel extends Actor {

    Setup setup;
    Sound sound;
    BitmapFont bitmapFontLittle;
    BitmapFont bitmapFontBig;
    GlyphLayout gl;
    String msg;
    int widthTextLittle, widthTextBig;
    int heightTextLittle, heightTextBig;
    TextureRegion skin;
    ReturnKey returnKey;
    int icoCenterY;
    int num;
    float alphaChannel;
    boolean isTouch = false;

    public ActorSelectLevel(final ReturnKey returnKey, Setup setup, final Sound sound, BitmapFont bitmapFontLittle, BitmapFont bitmapFontBig, String msg, TextureRegion skin, int x, int y, final int num) {
        this.bitmapFontLittle = bitmapFontLittle;
        this.setup = setup;
        this.sound = sound;
        this.bitmapFontBig = bitmapFontBig;
        this.returnKey = returnKey;
        this.msg = msg;
        this.skin = skin;
        this.num = num;
        setX(x); setY(y);

        gl = new GlyphLayout();
        gl.setText(bitmapFontLittle, msg);
        widthTextLittle = (int) gl.width; heightTextLittle = (int) gl.height;
        gl.setText(bitmapFontBig, "" + num);
        widthTextBig = (int) gl.width; heightTextBig = (int) gl.height;

        setWidth(Math.max(skin.getRegionWidth(), widthTextLittle));
        setHeight(skin.getRegionHeight() + heightTextLittle + heightTextBig);
        setBounds(getX(), getY(), getWidth(), getHeight());
        setOrigin((getWidth() - 30) * 0.5f, 24);

        alphaChannel = 0.4f;
        if (setup.getMax_level() + 1 >= num) {
            setTouchable(Touchable.enabled);
            addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    if (!isTouch) {
                        sound.play(Sound.SOUND.START_LEVEL);
                        setTouch();
                    }
                    return true;
                }
            });
            alphaChannel = 1.0f;
        }

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (isTouch) {
            setRotation(getRotation() + delta * 450);
            setScale(getScaleX() - delta * 2, getScaleX() - delta * 2);
            if (getRotation() > 360) {
                returnKey.pressKey(num);
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (!isTouch) {
            bitmapFontLittle.setColor(1, 1, 1, alphaChannel);
            bitmapFontBig.setColor(1, 1, 1, alphaChannel);
            bitmapFontLittle.draw(batch, msg, getX(), getY() + 48);
            bitmapFontBig.draw(batch, "" + num, getX() + (getWidth() - widthTextBig) * 0.5f, getY() + 54 + heightTextLittle);

            bitmapFontLittle.setColor(1, 1, 1, 1);
            bitmapFontBig.setColor(1, 1, 1, 1);
        }

        batch.setColor(1, 1, 1, alphaChannel);
        batch.draw(skin, getX() + (getWidth() - 48) * 0.5f, getY(), getOriginX(), getOriginY(), 48, 48, getScaleX(), getScaleY(), getRotation());
        batch.setColor(1, 1, 1, parentAlpha);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setSkin(TextureRegion skin) {
        this.skin = skin;
    }

    private void setTouch() {
        isTouch = true;
        setScale(2f, 2f);
        setTouchable(Touchable.disabled);
    }
}
