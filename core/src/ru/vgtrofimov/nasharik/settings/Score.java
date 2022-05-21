package ru.vgtrofimov.nasharik.settings;

import java.util.Vector;

public class Score {

    Setup setup;
    int score;
    int lives;
    int currentShape;
    Vector<Task> task;

    public Score(Setup setup) {
        this.setup = setup;
        lives = 3;
        nextLevel();
        restart();
    }

    public void nextLevel() {
        setup.setLevel(setup.getLevel() + 1);
        setup.savePrefs();
    }

    public void restart() {
        currentShape = 0;
    }

    /** В момент добавления фигур на сцену создаётся случайная последовательность. **/
    // public void setTask(int num, int shape) {
    //    task[num] = new Task(shape, false);
    // }

    public void createTask(Vector<Integer> sh) {
        task = new Vector<>();
        for (int i = 0; i < sh.size(); i++) {
            // setTask(i, sh.elementAt(i));
            task.add(new Task(sh.elementAt(i), false));
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Vector<Task> getTask() {
        return task;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public boolean checkShape(int number_shape) {
        if (currentShape == GameConstant.WIN) return true;
        /*
        if (number_shape == task[currentShape].number_shape) {
            task[currentShape].setGrabbed(true);
            currentShape += 1;
            if (currentShape == task.length) {
                currentShape = GameConstant.WIN;
            }
            return true;
        }
        */

        if (number_shape == task.elementAt(0).number_shape) {
            task.elementAt(0).setGrabbed(true);
            task.remove(0);
            if (task.size() == 0) {
                currentShape = GameConstant.WIN;
            }
            return true;
        }

        return false;
    }
    public void addScore(int i) {
        score += i;
        if (score > 1610) score = 0;
        if (score > setup.getRecordScore()) {
            setup.setRecordScore(score);
        }
        setup.setScore(score);
    }

    public void decScore(int i) {
        this.score -= i;
        if (this.score < 0) this.score = 0;
        setup.setScore(score);
    }

    public int getCurrentShape() {
        return currentShape;
    }

    public int getLevel() {
        return setup.getLevel();
    }

    public int getRecordScore() {
        return setup.getRecordScore();
    }
}
