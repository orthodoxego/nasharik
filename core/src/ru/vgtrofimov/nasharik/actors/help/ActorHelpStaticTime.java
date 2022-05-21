package ru.vgtrofimov.nasharik.actors.help;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import ru.vgtrofimov.nasharik.Balls;
import ru.vgtrofimov.nasharik.actors.menu.ActorTextureStatic;
import ru.vgtrofimov.nasharik.stages.GameHelpStage;
import ru.vgtrofimov.nasharik.stages.GameStage;

public class ActorHelpStaticTime extends ActorTextureStatic {

    GameHelpStage gameHelpStage;
    boolean touch = false;
    public int correctY;
    int numHelp;
    float timeToEnd;

    public ActorHelpStaticTime(GameHelpStage gameHelpStage, int numHelp, float timeToEnd, float x, float y, float width, float height, TextureRegion region) {
        super(x, y, width, height, region);
        this.gameHelpStage = gameHelpStage;
        this.numHelp = numHelp;
        this.timeToEnd = timeToEnd;
        setAlpha(0.8f);

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (!isDeleted() && touch && timeToEnd > 0) {
            timeToEnd -= delta;
        }

        if (!isDeleted() && timeToEnd <= 0) {
            if (getAlpha() > 0)
                setAlpha(getAlpha() - delta / 3);
            else {
                setAlpha(0);
                setDeleted(true);
                // gameHelpStage.addHelp();
            }
        }
    }

    public boolean isTouch() {
        return touch;
    }

    public void setTouch(boolean touch) {
        this.touch = touch;
    }

    public int getNumHelp() {
        return numHelp;
    }

    public void setNumHelp(int numHelp) {
        this.numHelp = numHelp;
    }
}
