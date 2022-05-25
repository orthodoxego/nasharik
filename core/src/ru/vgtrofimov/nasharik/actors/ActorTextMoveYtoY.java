package ru.vgtrofimov.nasharik.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.vgtrofimov.nasharik.services.Font;
import ru.vgtrofimov.nasharik.stages.GameStage;

public class ActorTextMoveYtoY extends Actor {
    float alpha_channel;
    TextureRegion blackHole;
    Font font;
    int fromY;
    int toY;
    String msg0, msg1;
    int msg0_x;
    int speed;
    boolean enabled;
    int widthText;
    int nulX, nulY;
    int screenWidth, screenHeight;
    float lifetime;

    public ActorTextMoveYtoY(TextureRegion blackHole, Font font, float fromY, float toY, String msg0, String msg1, int screenWidth, int screenHeight, int nulX, int nulY) {
        this.blackHole = blackHole;
        this.font = font;
        alpha_channel = 0.0f;
        setY(fromY);
        this.fromY = (int) fromY;
        this.toY = (int) toY;
        this.msg0 = msg0;
        this.msg1 = msg1;
        enabled = true;
        this.nulX = nulX;
        this.nulY = nulY;
        this.lifetime = 0;

        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        speed = screenHeight / 2;
        if (fromY > toY) speed *= -1;

        GlyphLayout gl = Font.getGlyphLayout();
        gl.setText(font.play_bold_14px, msg1);
        widthText = (int) gl.width;
        setX((GameStage.game_world_width - widthText) >> 1);

        gl.setText(font.play_bold_14px, msg0);
        widthText = (int) gl.width;
        msg0_x = ((GameStage.game_world_width - widthText) >> 1);

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (Math.abs(getY() - toY) > 10) setY(getY() + speed * delta);

        alpha_channel += delta * 3;
        if (alpha_channel > 0.9f) alpha_channel = 0.9f;
        lifetime += delta;
        if (lifetime > 1.5f) enabled = false;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.setColor(1, 1, 1, alpha_channel);
        batch.draw(blackHole, nulX, nulY, 0, 0, screenWidth, screenHeight, 1, 1, 0);
        batch.setColor(1, 1, 1, 1);

        font.play_bold_14px.draw(batch, msg1, getX(), getY());
        font.play_bold_14px.draw(batch, msg0, msg0_x, getY() - 48);

    }

    public boolean isEnabled() {
        return enabled;
    }
}
