package ru.vgtrofimov.nasharik.actors.help;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Vector;

import ru.vgtrofimov.nasharik.Balls;

public class ActorHelpScreen extends Actor  {
    Vector<String> msg;
    TextureRegion textureRegion;
    BitmapFont font;

    int startTextY, heightLine;
    Vector<Integer> startTextX;

    public ActorHelpScreen(Vector<String> msg, TextureRegion textureRegion, BitmapFont font, int x, int y, int widthScreen) {
        this.msg = msg;
        this.textureRegion = textureRegion;
        this.font = font;
        setWidth(textureRegion.getRegionWidth() * 2.3f); setHeight(textureRegion.getRegionHeight() * 2.3f);
        setX((widthScreen - getWidth()) / 2); setY(y);
        setBounds(getX(), getY(), getWidth(), getHeight());
        setRotation(0); setScale(1, 1);
        setOrigin(getWidth() / 2, getHeight() / 2);

        startTextY = (int) (getY() + getHeight() * 1.04f);
        GlyphLayout gl = new GlyphLayout();
        gl.setText(font, msg.elementAt(0));
        heightLine = (int) (gl.height * 1.5f);

        startTextX = new Vector<>();
        for (String s : msg) {
            gl.setText(font, s);
            startTextX.add((int) ((widthScreen - gl.width) / 2));
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, getX(), getY(),  getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());

        for (int i = 0; i < msg.size(); i++) {
            font.draw(batch, msg.elementAt(i), startTextX.elementAt(i), startTextY + 1.2f * heightLine * i);
        }
    }
}
