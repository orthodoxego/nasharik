package ru.vgtrofimov.ballsshmalls.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.vgtrofimov.ballsshmalls.settings.Font;
import ru.vgtrofimov.ballsshmalls.stages.GameStage;

public class ActorTextMoveYtoY extends Actor {
    float r, g, b, a;
    int fromY;
    int toY;
    String text;
    int speed;
    boolean enabled;
    int widthText;

    public ActorTextMoveYtoY(float r, float g, float b, float a, float fromY, float toY, String text, int screenHeight) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
        setY(fromY);
        this.fromY = (int) fromY;
        this.toY = (int) toY;
        this.text = text;
        enabled = true;

        speed = screenHeight / 4;
        if (fromY > toY) speed *= -1;

        GlyphLayout gl = Font.getGlyphLayout();
        gl.setText(Font.play_bold_14px, text);
        widthText = (int) gl.width;
        setX((GameStage.game_world_width - widthText) >> 1);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setY(getY() + speed * delta);
        if (Math.abs(getY() - toY) < 10) enabled = false;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.setColor(r, g, b, a);
        Font.play_bold_14px.draw(batch, text, getX(), getY());

        batch.setColor(1, 1, 1, 1);
    }

    public boolean isEnabled() {
        return enabled;
    }
}
