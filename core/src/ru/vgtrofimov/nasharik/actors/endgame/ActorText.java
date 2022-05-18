package ru.vgtrofimov.nasharik.actors.endgame;

import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.vgtrofimov.nasharik.services.Font;

public class ActorText extends Actor {

    Font font;
    String msg;

    public ActorText(Font font, String msg) {
        this.font = font;
        this.msg = msg;
    }
}
