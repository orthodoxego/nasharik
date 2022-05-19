package ru.vgtrofimov.nasharik.textures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.vgtrofimov.nasharik.settings.Setup;

public class Textures {

    String [] dir = {"base", "stone", "sea"};

    TextureRegion background;
    TextureRegion timer[];
    TextureRegion blank_timer;
    TextureRegion blackHole;
    TextureRegion nasharik;
    TextureRegion winHole;

    TextureRegion keyRestart, keyMenu;

    TextureRegion shapes[];
    TextureRegion techobject[];
    TextureRegion explosion[];
    TextureRegion stars;

    TextureRegion ball;
    TextureRegion ball_shadow;
    TextureRegion racquet;

    TextureRegion leftHand, rightHand;

    TextureRegion menuStartGame, menuSkin, menuVolume, menuHelp, menuShadow;

    public Textures(Setup setup) {
        Texture load;

        load = new Texture("png/" + dir[setup.getSkin()] + "/explosion.png");
        explosion = new TextureRegion[8];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                explosion[(i * 4 + j)] = getTextureRegionFromMap(j * 128, i * 128, 128, 128, false, true, load);            }
        }


        load = new Texture("png/" + dir[setup.getSkin()] + "/background.png");
        background = getTextureRegionFromMap(0, 0, load.getWidth(), load.getHeight(), false, true, load);

        load = new Texture("png/" + dir[setup.getSkin()] + "/nasharik.png");
        nasharik = getTextureRegionFromMap(0, 0, load.getWidth(), load.getHeight(), false, true, load);

        load = new Texture("png/" + dir[setup.getSkin()] + "/pack.png");

        menuStartGame = getTextureRegionFromMap(256, 386, 64, 64, false, true, load);
        menuSkin = getTextureRegionFromMap(256, 448, 64, 64, false, true, load);
        menuVolume = getTextureRegionFromMap(320, 386, 64, 64, false, true, load);
        menuHelp = getTextureRegionFromMap(320, 448, 64, 64, false, true, load);
        menuShadow = getTextureRegionFromMap(256, 320, 64, 64, false, true, load);

        keyRestart = getTextureRegionFromMap(0, 256, 64, 64, false, true, load);
        keyMenu = getTextureRegionFromMap(64, 256, 64, 64, false, true, load);

        leftHand = getTextureRegionFromMap(0, 128, 32, 64, false, true, load);
        rightHand = getTextureRegionFromMap(32, 128, 32, 64, false, true, load);
        blackHole = getTextureRegionFromMap(256, 64, 64, 64, false, true, load);
        winHole = getTextureRegionFromMap(384, 64, 64, 64, false, true, load);


        stars = getTextureRegionFromMap(384, 384, 128, 128, false, true, load);

        shapes = new TextureRegion[7];
        for (int i = 0; i < 7; i++) {
            shapes[i] = getTextureRegionFromMap(64 + i * 64, 128, 64, 64, false, true, load);
        }

        techobject = new TextureRegion[10];
        for (int i = 0; i < techobject.length; i++) {
            techobject[i] = getTextureRegionFromMap(i * 64, 192, 64, 64, false, true, load);
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

    public TextureRegion getBlackHole() {
        return blackHole;
    }

    public TextureRegion getWinHole() {
        return winHole;
    }

    public TextureRegion[] getTechobject() {
        return techobject;
    }

    public TextureRegion[] getExplosion() {
        return explosion;
    }

    public TextureRegion getKeyRestart() {
        return keyRestart;
    }

    public TextureRegion getKeyMenu() {
        return keyMenu;
    }

    public String[] getDir() {
        return dir;
    }

    public TextureRegion getMenuStartGame() {
        return menuStartGame;
    }

    public TextureRegion getMenuSkin() {
        return menuSkin;
    }

    public TextureRegion getMenuVolume() {
        return menuVolume;
    }

    public TextureRegion getNasharik() {
        return nasharik;
    }

    public TextureRegion getMenuHelp() {
        return menuHelp;
    }

    public TextureRegion getStars() {
        return stars;
    }

    public TextureRegion getMenuShadow() {
        return menuShadow;
    }
}
