package ru.vgtrofimov.ballsshmalls.settings;

import ru.vgtrofimov.ballsshmalls.Balls;

public class Score {

    Setup setup;
    int score;
    int lives;
    int currentShape;
    Task[] task;

    public Score(Setup setup) {
        this.setup = setup;
        restart();
    }

    private void restart() {
        lives = 3;
        currentShape = 0;
        setup.setLevel(setup.getLevel() + 1);
        int count_shapes_grabbed = Math.min(Math.max(5, setup.getLevel() * 3 - 1), 9);
        count_shapes_grabbed = 9;
        task = new Task[count_shapes_grabbed];
    }

    /** В момент добавления фигур на сцену создаётся случайная последовательность. **/
    public void setTask(int num, int shape) {
        task[num] = new Task(shape, false);
    }

    public void createTask(int[] sh) {
        for (int i = 0; i < task.length; i++) {
            setTask(i, sh[i]);
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
        if (number_shape == task[currentShape].number_shape) {
            task[currentShape].setGrabbed(true);
            currentShape += 1;
            return true;
        }
        return false;
    }
    public void addScore(int i) {
        Balls.log("Score added");
        this.score += i;
    }

    public void decScore(int i) {
        this.score -= i;
        if (this.score < 0) this.score = 0;
    }
}
