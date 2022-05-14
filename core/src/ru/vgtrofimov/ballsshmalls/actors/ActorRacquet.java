package ru.vgtrofimov.ballsshmalls.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorRacquet extends Actor {

    TextureRegion skin;
    ActorBall actorBall;
    int world_width, world_height;
    int correct_x;
    float y_correct_to_fire; // Корректировка для отпружинивания когда мяч бьёт по ракетке

    public ActorRacquet(TextureRegion skin, ActorBall actorBall, int world_width, int world_height) {
        this.skin = skin;
        this.actorBall = actorBall;
        this.world_width = world_width;
        this.world_height = world_height;
        setY(world_height - 96);
        correct_x = skin.getRegionWidth() / 2;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setX(actorBall.getX() - correct_x);
        if (getX() < 0) setX(0);
        if (getX() > world_width - correct_x * 2) setX(world_width - correct_x * 2);
        if (Math.abs(y_correct_to_fire) > 0) y_correct_to_fire *= 0.97f;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        //batch.setColor(0.1f, 0.2f, 0, parentAlpha / 2);
        //batch.draw(skin, getX() + 3, getY() + 3 - y_correct_to_fire);

        batch.setColor(1, 1, 1, parentAlpha);
        batch.draw(skin, getX(), getY() - y_correct_to_fire);
    }

    public void setY_correct_to_fire(float yc) {
        this.y_correct_to_fire = yc;
    }
}
