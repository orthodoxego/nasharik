package ru.vgtrofimov.nasharik.services;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import ru.vgtrofimov.nasharik.settings.GdxViewport;
import ru.vgtrofimov.nasharik.settings.Setup;

public class Font {

    FreeTypeFontGenerator play_regular;
    FreeTypeFontGenerator play_bold;
    public static GlyphLayout glyphLayout;

    public BitmapFont play_bold_14px;
    public BitmapFont play_regular_14px;

    public BitmapFont play_bold_big;
    public BitmapFont play_regular_little;

    public Font(int skin) {

        if (skin == 0) {
            play_regular = new FreeTypeFontGenerator(Gdx.files.internal("font/exo2.ttf"));
            play_bold = new FreeTypeFontGenerator(Gdx.files.internal("font/exo2_regular.ttf"));

            glyphLayout = new GlyphLayout();

            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

            parameter.characters = Setup.FONT_CHARS;
            parameter.flip = true;
            parameter.kerning = true;
            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 1.3f);
            parameter.borderWidth = 0;
            parameter.borderStraight = true;
            parameter.spaceX = 0;
            parameter.borderColor = Color.valueOf("FFFFFF");
            parameter.color = Color.valueOf("f8ec00");
            parameter.shadowColor = Color.valueOf("003500");
            parameter.shadowOffsetX = 3;
            parameter.shadowOffsetY = 3;

            // Основное меню и пр.
            play_regular_14px = play_regular.generateFont(parameter);

            parameter.borderColor = Color.valueOf("df9b62");
            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 1.6f);
            parameter.color = Color.valueOf("ffb76d");
            play_bold_14px = play_bold.generateFont(parameter);

            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 7.6f);
            parameter.color = Color.valueOf("edd970");
            play_bold_big = play_bold.generateFont(parameter);

            // Надпись внизу меню
            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 1.0f);
            parameter.color = Color.valueOf("FFFFFF");
            play_regular_little = play_bold.generateFont(parameter);

        } else if (skin == 1) {
            // CYBERBALL
            play_regular = new FreeTypeFontGenerator(Gdx.files.internal("font/marske_correct.ttf"));
            play_bold = new FreeTypeFontGenerator(Gdx.files.internal("font/marske_correct.ttf"));

            glyphLayout = new GlyphLayout();

            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

            parameter.characters = Setup.FONT_CHARS;
            parameter.flip = true;
            parameter.kerning = true;
            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 1.8f);
            parameter.borderWidth = 1;
            parameter.borderColor = Color.valueOf("84008b");
            parameter.borderStraight = true;
            parameter.spaceX = -1;
            parameter.color = Color.valueOf("c332ff");
            parameter.shadowColor = Color.valueOf("66059e");
            parameter.shadowOffsetX = 3;
            parameter.shadowOffsetY = 3;

            // Основное меню и пр.
            play_regular_14px = play_regular.generateFont(parameter);

            parameter.borderColor = Color.valueOf("df9b62");
            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 1.6f);
            parameter.color = Color.valueOf("ff6da1");
            play_bold_14px = play_bold.generateFont(parameter);

            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 7.6f);
            parameter.color = Color.valueOf("5400ef");
            play_bold_big = play_bold.generateFont(parameter);

            // Надпись внизу меню
            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 1.1f);
            parameter.color = Color.valueOf("FFFFFF");
            play_regular_little = play_bold.generateFont(parameter);

        } else if (skin == 2) {
            play_regular = new FreeTypeFontGenerator(Gdx.files.internal("font/wizland.ttf"));
            play_bold = new FreeTypeFontGenerator(Gdx.files.internal("font/wizland.ttf"));

            glyphLayout = new GlyphLayout();

            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

            parameter.characters = Setup.FONT_CHARS;
            parameter.flip = true;
            parameter.kerning = true;
            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 1.6f);
            parameter.borderWidth = 0;
            parameter.borderStraight = true;
            parameter.spaceX = 0;
            parameter.borderColor = Color.valueOf("3b8686");
            parameter.color = Color.valueOf("e7da83");

            play_regular_14px = play_regular.generateFont(parameter);

            parameter.borderColor = Color.valueOf("df9b62");
            parameter.color = Color.valueOf("df9b62");
            play_bold_14px = play_bold.generateFont(parameter);

            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 7.6f);
            parameter.color = Color.valueOf("edd970");
            play_bold_big = play_bold.generateFont(parameter);

            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 1f);
            parameter.color = Color.valueOf("f9b182");
            play_regular_little = play_regular.generateFont(parameter);
        } else if (skin == 3) {
            // МОРЕ
            play_regular = new FreeTypeFontGenerator(Gdx.files.internal("font/some_time.ttf"));
            play_bold = new FreeTypeFontGenerator(Gdx.files.internal("font/some_time.ttf"));

            glyphLayout = new GlyphLayout();

            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

            parameter.characters = Setup.FONT_CHARS;
            parameter.flip = true;
            parameter.kerning = true;
            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 1.8f);
            parameter.borderWidth = 0;
            parameter.borderColor = Color.valueOf("ea68a1");
            parameter.borderStraight = true;
            parameter.spaceX = -1;
            parameter.color = Color.valueOf("eada4a");
            parameter.shadowColor = Color.valueOf("9f8f00");
            parameter.shadowOffsetX = 3;
            parameter.shadowOffsetY = 3;

            // Основное меню и пр.
            play_regular_14px = play_regular.generateFont(parameter);

            // Номера уровней, концовка какая-то
            parameter.borderColor = Color.valueOf("df9b62");
            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 1.6f);
            parameter.color = Color.valueOf("e9dd6c");
            play_bold_14px = play_bold.generateFont(parameter);

            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 7.6f);
            parameter.color = Color.valueOf("71c600");
            play_bold_big = play_bold.generateFont(parameter);

            // Надпись внизу меню
            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 1.1f);
            parameter.spaceX = -1;
            parameter.color = Color.valueOf("FFFFFF");
            play_regular_little = play_bold.generateFont(parameter);

        } else if (skin == 4) {
            // 8 бит
//            play_regular = new FreeTypeFontGenerator(Gdx.files.internal("font/mercutio.ttf"));
//            play_bold = new FreeTypeFontGenerator(Gdx.files.internal("font/mercutio.ttf"));
            play_regular = new FreeTypeFontGenerator(Gdx.files.internal("font/bit.ttf"));
            play_bold = new FreeTypeFontGenerator(Gdx.files.internal("font/bit.ttf"));

            glyphLayout = new GlyphLayout();

            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

            parameter.characters = Setup.FONT_CHARS;
            parameter.flip = true;
            parameter.kerning = true;
            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 1.7f);
            parameter.borderWidth = 0;
            parameter.borderStraight = true;
            parameter.padTop = 4;
            parameter.borderColor = Color.valueOf("3b8686");
            parameter.color = Color.valueOf("ffdab5");

            play_regular_14px = play_regular.generateFont(parameter);

            parameter.borderColor = Color.valueOf("df9b62");
            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 2.2f);
            parameter.color = Color.valueOf("ffb76d");
            play_bold_14px = play_bold.generateFont(parameter);

            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 7.6f);
            parameter.color = Color.valueOf("edd970");
            play_bold_big = play_bold.generateFont(parameter);

            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 1.1f);
            parameter.spaceX = -1;
            parameter.color = Color.valueOf("f9b182");
            play_regular_little = play_regular.generateFont(parameter);

        } else {
            play_regular = new FreeTypeFontGenerator(Gdx.files.internal("font/playregular.ttf"));
            play_bold = new FreeTypeFontGenerator(Gdx.files.internal("font/playbold.ttf"));

            glyphLayout = new GlyphLayout();

            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

            parameter.characters = Setup.FONT_CHARS;
            parameter.flip = true;
            parameter.kerning = true;
            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 1.6f);
            parameter.borderWidth = 0;
            parameter.borderStraight = true;
            parameter.spaceX = 0;
            parameter.borderColor = Color.valueOf("3b8686");
            parameter.color = Color.valueOf("e7da83");

            play_regular_14px = play_regular.generateFont(parameter);

            parameter.borderColor = Color.valueOf("df9b62");
            parameter.color = Color.valueOf("df9b62");
            play_bold_14px = play_bold.generateFont(parameter);

            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 7.6f);
            parameter.color = Color.valueOf("edd970");
            play_bold_big = play_bold.generateFont(parameter);

            parameter.size = (int) (GdxViewport.FIXED_BLOCK * 1f);
            parameter.color = Color.valueOf("f9b182");
            play_regular_little = play_regular.generateFont(parameter);
        }

        if (play_regular != null) play_regular.dispose();
        if (play_bold != null) play_bold.dispose();

    }

    public static GlyphLayout getGlyphLayout() {
        return glyphLayout;
    }


}
