package ru.vgtrofimov.ballsshmalls.textures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.vgtrofimov.ballsshmalls.Balls;

public class Textures {

    TextureRegion background;

    TextureRegion ball;
    TextureRegion ball_shadow;
    TextureRegion racquet;

    public Textures() {
        Texture load;

        load = new Texture("png/background.png");
        background = getTextureRegionFromMap(0, 0, load.getWidth(), load.getHeight(), false, true, load);

        load = new Texture("png/pack.png");
        ball = getTextureRegionFromMap(0, 0, 64, 64, true, true, load);
        ball_shadow = getTextureRegionFromMap(64, 0, 64, 64, false, true, load);

        racquet = getTextureRegionFromMap(0, 64, 196, 64, false, true, load);
    }

    private TextureRegion getTextureRegionFromMap(int x, int y, int width, int height, boolean flipX, boolean flipY, Texture texture) {
        TextureRegion tr = new TextureRegion(texture, x, y, width, height);
        tr.flip(flipX, flipY);
        return tr;
    }

    public TextureRegion getBall() {
        return ball;
    }

    public TextureRegion getBall_shadow() {
        return ball_shadow;
    }

    public TextureRegion getBackground() {
        return background;
    }

    public TextureRegion getRacquet() {
        return racquet;
    }
}
