package ru.vgtrofimov.ballsshmalls.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.vgtrofimov.ballsshmalls.settings.Font;
import ru.vgtrofimov.ballsshmalls.settings.Score;
import ru.vgtrofimov.ballsshmalls.settings.Task;

public class ActorShapeLine extends Actor {

    TextureRegion[] shapes;
    Score score;
    float[] rotate;
    int viewportHeight;

    public ActorShapeLine(TextureRegion[] shapes, Score score, int viewportHeight) {
        this.shapes = shapes;
        this.score = score;
        this.viewportHeight = viewportHeight;
        rotate = new float[score.getTask().length];
        for (int i = 0; i < rotate.length; i++) {
            rotate[i] = i * (360.0f / rotate.length);
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        for (int i = 0; i < rotate.length; i++) {
            rotate[i] += 90 * delta;
            if (rotate[i] > 360) rotate[i] = 0;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        for (int i = 0; i < score.getTask().length; i++) {
            if (!score.getTask()[i].isGrabbed()) {
                batch.draw(shapes[score.getTask()[i].getNumber_shape()], 30 + getX() + i * 50, getY() + 20, 24, 24, 48, 48, 1, 1, rotate[i]);
            } else {
                batch.setColor(1, 1, 1, 0.3f);
                batch.draw(shapes[score.getTask()[i].getNumber_shape()], 30 + getX() + i * 50, getY() + 20, 24, 24, 48, 48, 1, 1, 0);
            }

            batch.setColor(1, 1, 1, 1);
        }

        Font.play_regular_14px.draw(batch, "Очки: " + score.getScore(), getX() + 30, getY() + 80);
        Font.play_regular_14px.draw(batch, "Уровень: " + score.getLevel(), getX() + 305, getY() + 80);

        Font.play_regular_14px.draw(batch, "Рекорд: " + score.getScore(), getX() + 30, getY() + viewportHeight - 40);
        Font.play_regular_14px.draw(batch, "Попытки: " + score.getLives(), getX() + 305, getY() + viewportHeight - 40);
    }
}
