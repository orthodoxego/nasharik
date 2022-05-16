package ru.vgtrofimov.ballsshmalls.textures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Textures {

    TextureRegion background;
    TextureRegion circle;
    TextureRegion timer[];
    TextureRegion blank_timer;

    TextureRegion shapes[];

    TextureRegion ball;
    TextureRegion ball_shadow;
    TextureRegion racquet;

    TextureRegion leftHand, rightHand;

    public Textures() {
        Texture load;

        load = new Texture("png/background.png");
        background = getTextureRegionFromMap(0, 0, load.getWidth(), load.getHeight(), false, true, load);

        load = new Texture("png/pack.png");

        leftHand = getTextureRegionFromMap(0, 128, 32, 64, false, true, load);
        rightHand = getTextureRegionFromMap(32, 128, 32, 64, false, true, load);
        circle = getTextureRegionFromMap(196, 64, 64, 64, false, true, load);

        shapes = new TextureRegion[7];
        for (int i = 0; i < 7; i++) {
            shapes[i] = getTextureRegionFromMap(64 + i * 64, 128, 64, 64, false, true, load);
        }

        timer = new TextureRegion[32];
        for (int i = 0; i < 32; i++) {
                timer[i] = getTextureRegionFromMap(192 + i * 8, 0, 8, 32, false, true, load);
        }
        blank_timer = getTextureRegionFromMap(192, 32, 256, 32, false, true, load);


        ball = getTextureRegionFromMap(0, 0, 64, 64, false, true, load);
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

    public TextureRegion[] getTimer() {
        return timer;
    }

    public TextureRegion getBlank_timer() {
        return blank_timer;
    }

    public TextureRegion getLeftHand() {
        return leftHand;
    }

    public TextureRegion getRightHand() {
        return rightHand;
    }

    public TextureRegion[] getShapes() {
        return shapes;
    }

    public TextureRegion getCircle() {
        return circle;
    }
}
