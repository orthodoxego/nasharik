package ru.vgtrofimov.nasharik.actors.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import ru.vgtrofimov.nasharik.Balls;
import ru.vgtrofimov.nasharik.settings.Sound;

public class ActorLittleText extends Actor {

    Sound sound;
    BitmapFont bitmapFont;
    TextureRegion background;
    String href;
    GlyphLayout gl;
    String[] msg;
    int xText, yText;
    float openUrl = 0;
    float alphaBackground;

    InputListener inputListener;

    public ActorLittleText(final Sound sound, BitmapFont bitmapFont, TextureRegion background, String[] msg, final String href, int x, int y) {
        this.sound = sound;
        this.bitmapFont = bitmapFont;
        this.background = background;
        this.msg = msg;
        this.href = href;
        this.xText = x;
        this.yText = y;
        setY(y);
        gl = new GlyphLayout();

        setHref(href);

    }

    public void setHref(String href) {
        this.href = href;
        alphaBackground = getAlphaBackground();
        refreshListener();
    }

    private void refreshListener() {
        if (href.length() > 0) {
            setBounds(0, yText - 32, 512, 107);
            setTouchable(Touchable.enabled);
            inputListener = new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    sound.play(Sound.SOUND.GOOD_RESULT);
                    openUrl = 0.1f;
                    return true;
                }
            };
            addListener(inputListener);
        } else {
            if (inputListener != null) {
                removeListener(inputListener);
            }
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (openUrl > 0) {
            openUrl += delta;
            alphaBackground -= delta;
            if (alphaBackground < 0) alphaBackground = 0;
            if (openUrl > 1.5f && openUrl < 2f) {
                if (href.length() > 0) Gdx.net.openURI(href);
                openUrl = 2.1f;
            }
            if (openUrl > 2.8f) {
                openUrl = 0;
                alphaBackground = getAlphaBackground();
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        for (int i = 0; i < msg.length; i++) {
            if (!(msg[i].equals(""))) {
                batch.setColor(1, 1, 1, alphaBackground);
                gl.setText(bitmapFont, msg[i]);
                batch.draw(background, 0, yText + i * 25 - 1, 0, 0, 512, gl.height + 8, 1, 1, 0);
                batch.setColor(1, 1, 1, 1);
            }
            bitmapFont.draw(batch, msg[i], xText, yText + i * 25);
        }

    }

    public void setMsg(String[] msg) {
        this.msg = msg;
    }

    public void setBitmapFont(BitmapFont bitmapFont) {
        this.bitmapFont = bitmapFont;
    }

    private float getAlphaBackground() {
        return 0.75f;
    }
}
