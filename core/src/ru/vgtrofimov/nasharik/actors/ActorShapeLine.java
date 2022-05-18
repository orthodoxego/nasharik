package ru.vgtrofimov.nasharik.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.vgtrofimov.nasharik.services.Font;
import ru.vgtrofimov.nasharik.settings.Score;

public class ActorShapeLine extends Actor {

    TextureRegion[] shapes;
    Score score;
    float[] rotation_array_to_elements;
    int viewportHeight;

    public ActorShapeLine(TextureRegion[] shapes, Score score, int viewportHeight) {
        this.shapes = shapes;
        this.score = score;
        this.viewportHeight = viewportHeight;
        rotation_array_to_elements = new float[15];
        for (int i = 0; i < score.getTask().length; i++) {
            rotation_array_to_elements[i] = i * (360.0f / rotation_array_to_elements.length);
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        for (int i = 0; i < score.getTask().length; i++) {
            rotation_array_to_elements[i] += 90 * delta;
            if (rotation_array_to_elements[i] > 360) rotation_array_to_elements[i] = 0;
        }

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        // Balls.log(score.getTask().length + " " + rtate.length);
        for (int i = 0; i < score.getTask().length; i++) {
            if (!score.getTask()[i].isGrabbed()) {
                batch.draw(shapes[score.getTask()[i].getNumber_shape()], 30 + getX() + i * 50, getY() + 60, 24, 24, 48, 48, 1, 1, rotation_array_to_elements[i]);
            } else {
                batch.setColor(1, 1, 1, 0.2f);
                batch.draw(shapes[score.getTask()[i].getNumber_shape()], 30 + getX() + i * 50, getY() + 60, 18, 18, 48, 48, 1, 1, 0);
            }

            batch.setColor(1, 1, 1, 1);
        }

        Font.play_regular_14px.draw(batch, "Очки: " + score.getScore(), getX() + 30, getY() + 20);
        Font.play_regular_14px.draw(batch, "Уровень: " + score.getLevel(), getX() + 305, getY() + 20);

        Font.play_regular_14px.draw(batch, "Рекорд: " + score.getRecordScore(), getX() + 30, getY() + viewportHeight - 40);
        Font.play_regular_14px.draw(batch, "Попытки: " + score.getLives(), getX() + 305, getY() + viewportHeight - 40);
    }
}
