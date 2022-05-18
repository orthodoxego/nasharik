package ru.vgtrofimov.nasharik.actors.endgame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.vgtrofimov.nasharik.Balls;
import ru.vgtrofimov.nasharik.services.Font;

public class ActorText extends Actor {

    public enum ADJUST {LEFT, CENTER, RIGHT};
    ADJUST adjust;
    BitmapFont font;
    String msg;
    int widthText, heightText;

    public ActorText(BitmapFont font, String msg, ADJUST adjust, int widthScreen) {
        this.font = font;
        this.msg = msg;
        this.adjust = adjust;

        GlyphLayout gl = new GlyphLayout();
        gl.setText(font, msg);
        this.widthText = (int) gl.width;
        this.heightText = (int) gl.height;
        switch (adjust) {
            case LEFT:
                setX((float) (widthScreen * 0.05));
                break;
            case CENTER:
                setX((widthScreen - widthText) / 2.0f);
                break;
            case RIGHT:
                setX((float) ((widthScreen * 0.95) - widthText));
                break;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        font.draw(batch, msg, getX(), getY());
    }

    public int getWidthText() {
        return widthText;
    }

    public void setWidthText(int widthText) {
        this.widthText = widthText;
    }

    public int getHeightText() {
        return heightText;
    }

    public void setHeightText(int heightText) {
        this.heightText = heightText;
    }
}
