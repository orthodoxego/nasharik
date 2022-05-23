package ru.vgtrofimov.nasharik.actors.help;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Vector;

public class ActorHelpScreen extends Actor  {
    Vector<String> msg;
    TextureRegion textureRegion;

    int startTextY, heightLine;
    Vector<Integer> startTextX;

    public ActorHelpScreen(Vector<String> msg, TextureRegion textureRegion, BitmapFont font, int x, int y) {
        this.msg = msg;
        this.textureRegion = textureRegion;
        setX(x); setY(y);
        setWidth(textureRegion.getRegionWidth()); setHeight(textureRegion.getRegionHeight());
        setBounds(0, 0, getWidth(), getHeight());
        setRotation(0); setScale(1, 1);
    }
}
