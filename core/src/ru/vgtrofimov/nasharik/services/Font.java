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

    public static BitmapFont play_bold_14px;
    public static BitmapFont play_regular_14px;

    public Font() {
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

        play_regular.dispose();
        play_bold.dispose();

    }

    public static GlyphLayout getGlyphLayout() {
        return glyphLayout;
    }

}
