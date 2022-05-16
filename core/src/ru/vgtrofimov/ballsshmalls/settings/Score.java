package ru.vgtrofimov.ballsshmalls.settings;

import java.util.Vector;

import ru.vgtrofimov.ballsshmalls.Balls;

public class Score {

    Setup setup;
    int score;
    int lives;
    int currentShape;
    Task[] task;

    public Score(Setup setup) {
        this.setup = setup;
        nextLevel();
        restart();
    }

    public void nextLevel() {
        setup.setLevel(setup.getLevel() + 1);
        lives = 3;
    }

    public void restart() {
        currentShape = 0;
    }

    /** В момент добавления фигур на сцену создаётся случайная последовательность. **/
    public void setTask(int num, int shape) {
        task[num] = new Task(shape, false);
    }

    public void createTask(Vector<Integer> sh) {
        task = new Task[sh.size()];
        for (int i = 0; i < sh.size(); i++) {
            setTask(i, sh.elementAt(i));
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Task[] getTask() {
        return task;
    }

    public void setTask(Task[] task) {
        this.task = task;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public boolean checkShape(int number_shape) {
        if (currentShape == GameConstant.WIN) return true;
        if (number_shape == task[currentShape].number_shape) {
            task[currentShape].setGrabbed(true);
            currentShape += 1;
            if (currentShape == task.length) {
                currentShape = GameConstant.WIN;
            }
            return true;
        }
        return false;
    }
    public void addScore(int i) {
        this.score += i;
    }

    public void decScore(int i) {
        this.score -= i;
        if (this.score < 0) this.score = 0;
    }

    public int getCurrentShape() {
        return currentShape;
    }

    public int getLevel() {
        return setup.getLevel();
    }
}
