package ru.vgtrofimov.nasharik.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.vgtrofimov.nasharik.services.Font;
import ru.vgtrofimov.nasharik.settings.Score;

public class ActorShapeLine extends Actor {

    TextureRegion[] shapes;
    TextureRegion blackField;
    Score score;
    float[] rotation_array_to_elements;
    int viewportHeight;

    public ActorShapeLine(TextureRegion[] shapes, TextureRegion blackField, Score score, int viewportHeight) {
        this.shapes = shapes;
        this.blackField = blackField;
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

        batch.setColor(1, 1, 1, 0.5f);
        batch.draw(blackField, getX(), getY(), 0, 0, 512, 130, 1, 1, 0);
        batch.draw(blackField, getX(), getY() + viewportHeight - 60, 0, 0, 512, 60, 1, 1, 0);


        batch.setColor(1, 1, 1, 1);
        // Balls.log(score.getTask().length + " " + rtate.length);
        for (int i = 0; i < score.getTask().length; i++) {
            if (!score.getTask()[i].isGrabbed()) {
                // ROTATION
                // batch.draw(shapes[score.getTask()[i].getNumber_shape()], 30 + getX() + i * 50, getY() + 60, 24, 24, 48, 48, 1, 1, rotation_array_to_elements[i]);

                // NO ROTATION
                batch.draw(shapes[score.getTask()[i].getNumber_shape()], 30 + getX() + i * 50, getY() + 60, 24, 24, 48, 48, 1, 1, 0);
            } else {
                batch.setColor(1, 1, 1, 0.2f);
                batch.draw(shapes[score.getTask()[i].getNumber_shape()], 30 + getX() + i * 50, getY() + 60, 18, 18, 36, 36, 1, 1, 0);
            }

            batch.setColor(1, 1, 1, 1);
        }

        Font.play_regular_14px.draw(batch, "Очки: " + score.getScore(), getX() + 30, getY() + 20);
        Font.play_regular_14px.draw(batch, "Уровень: " + score.getLevel(), getX() + 305, getY() + 20);

        Font.play_regular_14px.draw(batch, "Рекорд: " + score.getRecordScore(), getX() + 30, getY() + viewportHeight - 40);
        Font.play_regular_14px.draw(batch, "Попытки: " + Math.max(0, score.getLives()), getX() + 305, getY() + viewportHeight - 40);
    }
}
