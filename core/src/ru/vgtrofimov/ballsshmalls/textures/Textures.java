package ru.vgtrofimov.ballsshmalls.textures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Textures {

    TextureRegion ball;
    TextureRegion ball_shadow;

    public Textures() {
        Texture load;

        load = new Texture("png/pack.png");

        ball = getTextureRegionFromMap(0, 0, 64, 64, true, true, load);
        ball_shadow = getTextureRegionFromMap(64, 0, 64, 64, true, true, load);
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
}
