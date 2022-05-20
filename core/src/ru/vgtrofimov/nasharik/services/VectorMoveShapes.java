package ru.vgtrofimov.nasharik.services;

import java.util.Vector;

import ru.vgtrofimov.nasharik.actors.ActorShape;

public class VectorMoveShapes {
    class Move {
        public float speedX;
        public float speedY;
        public boolean moving = true;
        float toX;
        float toY;

        boolean moveX = true, moveY = true;


        public Move(float toX, float toY) {
            this.toX = toX;
            this.toY = toY;
        }

        private void calc_speed(float x, float y) {
            speedX = -(x - toX);
            speedY = -(y - toY);

        }

        public void act(float x, float y) {
            if (Math.abs(x - toX) < Math.abs(speedX) / 10)
                moveX = false;
            else if (speedX < 0 && x < toX)
                moveX = false;
            else if (speedX > 0 && x > toX)
                moveX = false;


            if (Math.abs(y - toY) < Math.abs(speedX) / 10)
                moveY = false;
            else if (speedY > 0 && y > toY)
                moveY = false;
            else if (speedY < 0 && y < toY)
                moveY = false;

            if (!moveX && !moveY)
                moving = false;

        }


    }

    Vector<Move> moves = new Vector<>();

    public VectorMoveShapes(Vector<ActorShape> actorShape) {
        for (int i = 0; i < actorShape.size(); i++) {
            int idx = i + 1;
            if (idx >= actorShape.size()) idx = 0;
            moves.add(new Move(actorShape.elementAt(idx).getX(),
                    actorShape.elementAt(idx).getY()));
            moves.lastElement().calc_speed(actorShape.elementAt(i).getX(),
                    actorShape.elementAt(i).getY());
        }
    }

    public void act(Vector<ActorShape> actorShape, float delta) {
        for (int i = 0; i < actorShape.size(); i++) {
            if (moves.elementAt(i).moving) {

                moves.elementAt(i).act(actorShape.elementAt(i).getX(), actorShape.elementAt(i).getY());

                if (moves.elementAt(i).moveX)
                    actorShape.elementAt(i).setX(actorShape.elementAt(i).getX() + moves.elementAt(i).speedX * delta);
                else
                    actorShape.elementAt(i).setX(moves.elementAt(i).toX);

                if (moves.elementAt(i).moveY)
                    actorShape.elementAt(i).setY(actorShape.elementAt(i).getY() + moves.elementAt(i).speedY * delta);
                else
                    actorShape.elementAt(i).setY(moves.elementAt(i).toY);

            } else {
                actorShape.elementAt(i).setX(moves.elementAt(i).toX);
                actorShape.elementAt(i).setY(moves.elementAt(i).toY);
            }
        }
    }

    public boolean isFinalMoving() {
        boolean res = false;
        for (Move mv : moves) {
            res = res || mv.moving;
        }
        return !res;
    }

}
