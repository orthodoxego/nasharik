package ru.vgtrofimov.nasharik.actors.menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorLittleText extends Actor {

    BitmapFont bitmapFont;
    String[] msg;

    public ActorLittleText(BitmapFont bitmapFont, String[] msg, int x, int y) {
        this.bitmapFont = bitmapFont;
        this.msg = msg;
        setX(x);
        setY(y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        for (int i = 0; i < msg.length; i++) {
            bitmapFont.draw(batch, msg[i], getX(), getY() + i * 23);
        }
    }

    public void setMsg(String[] msg) {
        this.msg = msg;
    }

    public void setBitmapFont(BitmapFont bitmapFont) {
        this.bitmapFont = bitmapFont;
    }
}
