package ru.vgtrofimov.nasharik.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ActorTeleport extends ActorShape {

    int teleportToX, teleportToY;
    boolean processing_teleport = false;
    ActorBall actorBall;

    public ActorTeleport(TextureRegion skin, int number_shape, float x, float y, float speedX, float speedY, int maxX, int maxY, int widthScreen, int heightScreen, int teleportToX, int teleportToY) {
        super(skin, number_shape, x, y, speedX, speedY, maxX, maxY, widthScreen, heightScreen);
        this.teleportToX = teleportToX;
        this.teleportToY = teleportToY;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (getScaleX() < 0.98f && processing_teleport) {
            actorBall.setX(getTeleportToX());
            actorBall.setY(getTeleportToY());
            actorBall.setSpeedX(0);
            actorBall.setSpeedY(0);
            setScale(getScaleX() + delta * 0.55f, getScaleY() + delta * 0.55f);
            actorBall.setTempAlpha(getScaleX());
            if (getScaleX() >= 0.98f) {
                setScale(1, 1);
                actorBall.setTempAlpha(1);
                processing_teleport = false;
            }
        }

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (enabled) {
            batch.setColor(1, 1, 1, 0.3f);
            batch.draw(skin, teleportToX - correctX, teleportToY - correctY, getOriginX(), getOriginY(), getWidth(), getHeight(), 0.5f, 0.5f, 90);
        }

        batch.setColor(1, 1, 1, 1);

    }

    public int getTeleportToX() {
        return teleportToX;
    }

    public int getTeleportToY() {
        return teleportToY;
    }

    public boolean isProcessing_teleport() {
        return processing_teleport;
    }

    public void setProcessing_teleport(boolean processing_teleport) {
        this.processing_teleport = processing_teleport;
    }

    public ActorBall getActorBall() {
        return actorBall;
    }

    public void setActorBall(ActorBall actorBall) {
        this.actorBall = actorBall;
    }

    public void setScale(float scaleX, float scaleY) {
        super.setScale(scaleX, scaleY);
    }
}
