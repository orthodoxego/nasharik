package ru.vgtrofimov.ballsshmalls.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.vgtrofimov.ballsshmalls.Balls;

public class ActorRacquet extends Actor {

    TextureRegion skin;
    ActorBall actorBall;
    int world_width, world_height;
    int correct_x;
    float y_correct_to_fire; // Корректировка для отпружинивания когда мяч бьёт по ракетке
    int pressed_energy;

    public ActorRacquet(TextureRegion skin, ActorBall actorBall, int world_width, int world_height) {
        this.skin = skin;
        this.actorBall = actorBall;
        this.world_width = world_width;
        this.world_height = world_height;
        setY(world_height - 96);
        correct_x = skin.getRegionWidth() / 2;
        pressed_energy = 0;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        setX(actorBall.getX() - correct_x);

        if (getX() < 0) setX(0);
        if (getX() > world_width - correct_x * 2) setX(world_width - correct_x * 2);
        if (Math.abs(y_correct_to_fire) > 0) y_correct_to_fire *= 0.97f;

        if (pressed_energy != 0) {
            if (pressed_energy > 0) pressed_energy *= 0.98f;
            if (pressed_energy < 1) pressed_energy = 0;
        }

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        //batch.setColor(0.1f, 0.2f, 0, parentAlpha / 2);
        //batch.draw(skin, getX() + 3, getY() + 3 - y_correct_to_fire);

        batch.setColor(1, 1, 1, parentAlpha);
        batch.draw(skin, getX(), getY() - y_correct_to_fire - pressed_energy * 3);
    }

    public void setY_correct_to_fire(float yc) {
        this.y_correct_to_fire = yc;
    }

    public int getPressed_energy() {
        return pressed_energy;
    }

    public void setPressed_energy(int pressed_energy) {
        if (pressed_energy != 0 && actorBall.getY() + 128 >= getY() - y_correct_to_fire - pressed_energy * 3) {
            actorBall.setY(getY() - 128 - y_correct_to_fire - pressed_energy * 3);
            actorBall.setEnergySpeedY(-pressed_energy * 50);
            // Balls.log("Energy to ball: " + (pressed_energy * 50));
        }

        this.pressed_energy = pressed_energy;
    }



    public float getY_correct_to_fire() {
        return y_correct_to_fire;
    }
}
