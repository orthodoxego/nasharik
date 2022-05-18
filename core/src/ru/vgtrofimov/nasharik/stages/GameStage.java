package ru.vgtrofimov.nasharik.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Vector;

import ru.vgtrofimov.nasharik.actors.ActorBackground;
import ru.vgtrofimov.nasharik.actors.ActorBall;
import ru.vgtrofimov.nasharik.actors.ActorFrames;
import ru.vgtrofimov.nasharik.actors.ActorSpring;
import ru.vgtrofimov.nasharik.actors.ActorShape;
import ru.vgtrofimov.nasharik.actors.ActorLeftHand;
import ru.vgtrofimov.nasharik.actors.ActorRacquet;
import ru.vgtrofimov.nasharik.actors.ActorRightHand;
import ru.vgtrofimov.nasharik.actors.ActorShapeLine;
import ru.vgtrofimov.nasharik.actors.ActorTeleport;
import ru.vgtrofimov.nasharik.actors.ActorTextMoveYtoY;
import ru.vgtrofimov.nasharik.screens.GameScreen;
import ru.vgtrofimov.nasharik.settings.GameConstant;
import ru.vgtrofimov.nasharik.settings.Levels;
import ru.vgtrofimov.nasharik.services.PositionUnit;
import ru.vgtrofimov.nasharik.settings.Score;
import ru.vgtrofimov.nasharik.settings.Setup;
import ru.vgtrofimov.nasharik.textures.Textures;

public class GameStage extends StageParent implements InputProcessor{

    Score score;
    boolean move_cam;
    Textures textures;
    public static int game_world_width, game_world_height;

    ActorTextMoveYtoY actorTextMoveYtoY;
    ActorTextMoveYtoY actorPause;

    ActorBall actorBall;
    ActorRacquet actorRacquet;
    ActorShapeLine actorShapeLine;
    int correct_camera_y;

    Vector<ActorShape> actorShape;
    Vector<ActorSpring> actorSprings;
    Vector<ActorTeleport> actorTeleport;
    Vector<ActorFrames> actorStarsGrab;

    ActorRightHand actorRightHand;
    ActorLeftHand actorLeftHand;
    // ActorTimer actorTimer;

    public GameStage(GameScreen gameScreen, Setup setup, Viewport viewport, OrthographicCamera camera, Textures textures) {
        super(gameScreen, setup, viewport, camera);

        this.textures = textures;

        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        resize((int) viewport.getWorldWidth(), (int) viewport.getWorldHeight());
        camera.position.x = 10;
        camera.position.y = 10;


        hardReset();
    }

    private void hardReset() {
        score = new Score(setup);
        softReset();
    }

    private void softReset() {
        for (Actor act : getActors()) {
            act.remove();
        }

        actorBall = null;
        actorRightHand = null;
        actorLeftHand = null;
        actorShapeLine = null;

        score.restart();
        move_cam = true;
        pause = false;
        correct_camera_y = 128;
        addActors();
    }

    private void addActors() {

        actorStarsGrab = new Vector<>();
        gameScreen.setInputListener();

        ActorBackground actorBackground = new ActorBackground(textures.getBackground(), Setup.count_background);
        int sx = 100 + (int) (Math.random() * 200);
        if (Math.random() < 0.5) sx *= -1;
        actorBall = new ActorBall(textures.getBall(), textures.getBall_shadow(),
                game_world_width / 2,
                game_world_height - 512, // (int) (camera.viewportHeight / 2),
                sx,
                50,
                game_world_width,
                game_world_height);

        actorRacquet = new ActorRacquet(textures.getRacquet(), actorBall, game_world_width, game_world_height);
        actorBall.setActorRacquet(actorRacquet);

        addActor(actorBackground);
        addActor(actorRacquet);


        /***************************************************************************
         ********* ДОБАВЛЕНИЕ ФИГУР И ФОРМИРОВАНИЕ СПИСКА ПОСЛЕДОВАТЕЛЬНОСТИ ******* 16/05/22
         **************************************************************************/

        Levels lev = new Levels();
        addTech(lev);
        addShapes(lev);

        addActor(actorBall);

        actorShapeLine = new ActorShapeLine(textures.getShapes(), score, (int) camera.viewportHeight);
        addActor(actorShapeLine);
    }

    private void addTech(Levels lev) {
        Vector<PositionUnit> tech = lev.getTech(setup.getLevel() - 1);
        actorSprings = new Vector<>();
        actorTeleport = new Vector<>();

        int[] speed = {-1, -2, -3, 3, 2, 1};
        for (PositionUnit pu : tech) {
            switch (pu.code) {
                case GameConstant.MINE:
                    actorSprings.add(new ActorSpring(textures.getTechobject()[pu.code - GameConstant.CORRECT_TECH], pu.code,
                            pu.x, pu.y,
                            speed[(int) (Math.random() * speed.length)], speed[(int) (Math.random() * speed.length)],
                            5 + (int) (Math.random() * 20), 5 + (int) (Math.random() * 20),
                            game_world_width, game_world_height)
                    );
                    addActor(actorSprings.lastElement());
                    break;
                case GameConstant.TELEPORT:
                    actorTeleport.add(new ActorTeleport(textures.getTechobject()[pu.code - GameConstant.CORRECT_TECH], pu.code,
                            pu.x, pu.y,
                            0, 0,
                            0, 0,
                            game_world_width, game_world_height,
                            pu.teleportToX, pu.teleportToY)
                    );
                    actorTeleport.lastElement().setActorBall(actorBall);
                    addActor(actorTeleport.lastElement());
                    break;
                default:
                    break;
            }
        }
    }

    private void addShapes(Levels lev) {

        Vector<PositionUnit> level = lev.getLevel(setup.getLevel() - 1);
        Vector<Integer> shapes = lev.getGrabber(setup.getLevel() - 1);

        int[] speed = {-10, -20, -30, 30, 20, 10};
        int number = 15;

        int line = (int) ((game_world_height * 0.9f) / number);
        actorShape = new Vector<>();

        for (PositionUnit pu : level) {
            actorShape.add(new ActorShape(textures.getShapes()[pu.code], pu.code,
                    pu.x, pu.y,
                    speed[(int) (Math.random() * speed.length)], speed[(int) (Math.random() * speed.length)],
                    5 + (int) (Math.random() * 100), 5 + (int) (Math.random() * 50),
                    game_world_width, game_world_height)
            );
            addActor(actorShape.lastElement());
        }
        // Collections.shuffle(shapes);
        score.createTask(shapes);
    }

    @Override
    public void act(float delta) {
        if (!pause) {
            super.act(delta);
            if (move_cam) {
                // РАСЧЁТЫ В МОМЕНТ ИГРЫ И ПЕРЕМЕЩЕНИЯ КАМЕРЫ
                calc_camera_pos(delta);
                checkHand();
                check_collision_player_and_shape();
                check_collision_player_and_tech();
            } else {
                // КАМЕРА ЗАБЛОЧЕНА
                // Останавливается шар
                actorBall.setSpeedX(0);
                actorBall.setSpeedY(0);

                // Проверка текстового актёра.
                // Если актер есть и если он закончен, то либо следующий уровень, либо заново
                if (actorTextMoveYtoY != null) {
                    if (!actorTextMoveYtoY.isEnabled()) {
                        actorTextMoveYtoY.remove();
                        // КОНЕЦ ИГРЫ
                        if (score.getLives() < 0) {
                            gameScreen.setEndGameStage();
                        }
                        // СЛЕДУЮЩИЙ УРОВЕНЬ
                        if (score.getCurrentShape() == GameConstant.WIN) {
                            score.nextLevel();
                        }
                        softReset();
                    }
                }
            }

            removeActorFrames();

            if (actorShapeLine != null) {
                actorShapeLine.setX(camera.position.x - camera.viewportWidth / 2);
                actorShapeLine.setY(camera.position.y - camera.viewportHeight * 0.5f);
            }

        }
    }

    private void removeActorFrames() {
        for (ActorFrames af : actorStarsGrab) {
            if (!af.isEnabled()) af.remove();
        }

        for (int i = actorStarsGrab.size() - 1; i > -1; i--) {
            if (!actorStarsGrab.elementAt(i).isEnabled()) actorStarsGrab.removeElement(actorStarsGrab.elementAt(i));
        }
    }

    private void check_collision_player_and_shape() {
        for (ActorFrames asg : actorStarsGrab) {
            asg.setX(actorBall.getX() - 64);
            asg.setY(actorBall.getY() - 96);
        }

        for (ActorShape ash : actorShape) {
            if (ash.isEnabled() && ash.isCollision(actorBall)) {
                if (score.checkShape(ash.getNumber_shape())) {
                    score.addScore(1);
                    actorBall.addScalle(actorBall.getScaleX() + 0.4f / score.getTask().length);

                    // Добавит взрыв
                    actorStarsGrab.add(new ActorFrames(textures.getExplosion(),
                            0, 32,
                            1,
                            (int) actorBall.getX() - 64, (int) actorBall.getY() - 64));
                    addActor(actorStarsGrab.lastElement());

                    if (score.getCurrentShape() == GameConstant.WIN) {
                        nextLevel(); // Следующий уровень
                    }
                } else {
                    nextTry(); // Новая попытка
                }
                ash.setEnabled(false);
            }
        }
    }

    private void check_collision_player_and_tech() {
        for (ActorSpring am : actorSprings) {
            if (am.isEnabled() && am.isCollision(actorBall)) {
                // am.setEnabled(false);
                // am.remove();
                am.setScale(2.5f, 2.5f);
                actorBall.setSpeedX(-actorBall.getSpeedX() * 3);
                actorBall.setSpeedY(-actorBall.getSpeedY() * 3);
                actorBall.check_move_balls(Gdx.graphics.getDeltaTime());
                actorBall.check_move_balls(Gdx.graphics.getDeltaTime());
            }
        }

        for (ActorTeleport at : actorTeleport) {
            if (at.isEnabled() && at.isCollision(actorBall) && !at.isProcessing_teleport()) {
                at.setProcessing_teleport(true);
                at.setScale(0f, 0f);
                actorBall.setX(at.getX());
                actorBall.setY(at.getY());
                actorBall.setSpeedX(0);
                actorBall.setSpeedY(0);
            }
        }

    }

    private void checkHand() {
        if (actorRightHand != null) {
            actorRightHand.setX(actorBall.getX() - 4);
            actorRightHand.setY(actorBall.getY() + 16);
            if (!actorRightHand.isEnabled()) {
                actorRightHand.remove();
                actorRightHand = null;
            }
        }

        if (actorLeftHand != null) {
            actorLeftHand.setX(actorBall.getX() - 32);
            actorLeftHand.setY(actorBall.getY() + 8);
            if (!actorLeftHand.isEnabled()) {
                actorLeftHand.remove();
                actorLeftHand = null;
            }
        }
    }

    private void calc_camera_pos(float delta) {
        /** РАСЧЁТ ПОЗИЦИИ КАМЕРЫ */

//        if (actorTimer != null) actorTimer.setX(actorRacquet.getX() - 32);

        /**
         * Это какой-то пипец с расчётами камеры.
         * По факту - взял correct_camera_y для расчёта коррекции оси Y камеры в
         * зависимости от приближения или удаления шара от верхней и нижней границы.
         * Куча ифов, которые я объяснить не смогу. Но вроде роботает.
         * --- *даже не уверен, что код не рандомный* ---
         * 15/05/22
         */

        int cam_pos_x = game_world_width / 2;
        int cam_pos_y = (int) (actorBall.getY());

        if (cam_pos_y > game_world_height - camera.viewportHeight / 2) {
            cam_pos_y = (int) (game_world_height - camera.viewportHeight / 2);
            if (actorBall.getSpeedY() > 0) correct_camera_y = 0;
        } else if (cam_pos_y < camera.viewportHeight / 2) {
            cam_pos_y = (int) (camera.viewportHeight / 2);
            if (actorBall.getSpeedY() <= 0) correct_camera_y = 0;
        }

        if (actorBall.getSpeedY() > 150) {
            correct_camera_y += camera.viewportHeight / 4 * delta;
        }

        if (actorBall.getSpeedY() < -150 && actorBall.getY() < game_world_height - camera.viewportHeight * 0.75f) {
            correct_camera_y -= camera.viewportHeight / 4 * delta;
        }

        if (cam_pos_y + correct_camera_y < camera.viewportHeight / 2) {
            correct_camera_y = (int) (camera.viewportHeight / 2 - cam_pos_y);
        }

        if (cam_pos_y + correct_camera_y > game_world_height - camera.viewportHeight / 2) {
            correct_camera_y = (int) (game_world_height - camera.viewportHeight / 2 - cam_pos_y);
        }

        if (correct_camera_y > camera.viewportHeight / 3) correct_camera_y = (int) (camera.viewportHeight / 3);
        if (correct_camera_y < -camera.viewportHeight / 3) correct_camera_y = (int) -(camera.viewportHeight / 3);

//        if (actorBall.getY() > game_world_height - camera.viewportHeight / 2) {
//            if (actorTimer == null) {
//                actorTimer = new ActorTimer(textures.getTimer(),
//                        textures.getBlank_timer(),
//                        (int) actorRacquet.getX() - 32,
//                        (int) (actorRacquet.getY() + 32));
//                addActor(actorTimer);
//            }
//        } else {
//            if (actorTimer != null) {
//                actorTimer.remove();
//                actorTimer = null;
//            }
//        }

        camera.position.set(cam_pos_x,cam_pos_y + correct_camera_y, 0);
        camera.update();
    }

    @Override
    public void resize(int width, int height) {
        // Balls.log("RESIZE GS " + width + " " + height);

        game_world_width = 512;
        game_world_height = textures.getBackground().getRegionHeight() * Setup.count_background;

        /*
        getViewport().setScreenWidth(game_world_width);
        getViewport().setScreenHeight((int) (game_world_width * (float) height / width));
        getViewport().update(game_world_width, game_world_width * height / width);

         */

        camera.viewportWidth = game_world_width;
        camera.viewportHeight = game_world_width * (float) height / width;
        camera.position.set(camera.viewportWidth / 2,camera.viewportHeight / 2, 0);
        camera.update();
    }

    @Override
    public void draw() {
        super.draw();
    }

    private void nextTry() {
        // Добавляется актёр с текстом. Когда текст пройдёт, актёр удаляется и вызывается
        // softReset()

        score.decScore(3);
        score.setLives(score.getLives() - 1);

        move_cam = false;
        if (actorLeftHand != null) actorLeftHand.remove();
        if (actorRightHand != null) actorRightHand.remove();

        actorBall.setSpeedX(0);
        actorBall.setSpeedY(0);
        Gdx.input.setInputProcessor(null);

        if (score.getLives() < 0) {
            actorTextMoveYtoY = new ActorTextMoveYtoY(textures.getBlackHole(),
                    camera.position.y + 200,
                    camera.position.y - 100,
                    "ЭТО КОНЕЦ", (int) camera.viewportWidth, (int) camera.viewportHeight,
                    (int) (camera.position.x - camera.viewportWidth / 2),
                    (int) (camera.position.y - camera.viewportHeight / 2));
        } else {
            actorTextMoveYtoY = new ActorTextMoveYtoY(textures.getBlackHole(),
                    camera.position.y + 200,
                    camera.position.y - 100,
                    "ПОПРОБУЙ ЕЩЁ РАЗ :(", (int) camera.viewportWidth, (int) camera.viewportHeight,
                    (int) (camera.position.x - camera.viewportWidth / 2),
                    (int) (camera.position.y - camera.viewportHeight / 2));
        }

        addActor(actorTextMoveYtoY);
        actorShapeLine.toFront();
    }

    private void nextLevel() {
        // Добавляется актёр с текстом. Когда текст пройдёт, актёр удаляется и вызывается
        // softReset()
        move_cam = false;
        if (actorLeftHand != null) actorLeftHand.remove();
        if (actorRightHand != null) actorRightHand.remove();

        actorBall.setSpeedX(0);
        actorBall.setSpeedY(0);

        Gdx.input.setInputProcessor(null);

        actorTextMoveYtoY = new ActorTextMoveYtoY(textures.getWinHole(),
                camera.position.y + 200,
                camera.position.y - 100,
                "СЛЕДУЮЩИЙ УРОВЕНЬ!", (int) camera.viewportWidth, (int) camera.viewportHeight,
                (int) (camera.position.x - camera.viewportWidth / 2),
                (int) (camera.position.y - camera.viewportHeight / 2));

        addActor(actorTextMoveYtoY);
        actorShapeLine.toFront();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.MINUS) score.setLives(score.getLives() - 1);
        if (keycode == Input.Keys.P) {
            pause = !pause;
        }

        // Добавит актёра экрана паузы
        if (pause) {
            actorPause = new ActorTextMoveYtoY(textures.getBlackHole(),
                    camera.position.y,
                    camera.position.y,
                    "П А У З А", (int) camera.viewportWidth, (int) camera.viewportHeight,
                    (int) (camera.position.x - camera.viewportWidth / 2),
                    (int) (camera.position.y - camera.viewportHeight / 2));
            addActor(actorPause);
        } else {
            if (actorPause != null) actorPause.remove();
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//                if (actorTimer != null) {
//                    actorTimer.setRandomFrame();
//                    actorTimer.setPressed(true);
//                } else {
        if (actorBall.getY() > camera.viewportHeight / 3 && !pause) {
            if (actorRightHand == null && actorLeftHand == null && screenX > Gdx.graphics.getWidth() / 2) {
                actorRightHand = new ActorRightHand(actorBall, textures.getRightHand(), (int) actorBall.getX(), (int) actorBall.getY());
                actorRightHand.setPressed(true);
                addActor(actorRightHand);
            }

            if (actorLeftHand == null && actorRightHand == null && screenX <= Gdx.graphics.getWidth() / 2 && !pause) {
                actorLeftHand = new ActorLeftHand(actorBall, textures.getLeftHand(), (int) actorBall.getX(), (int) actorBall.getY());
                actorLeftHand.setPressed(true);
                addActor(actorLeftHand);
            }
        }
//                }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
//                if (actorTimer != null && actorTimer.isPressed()) {
//                    actorTimer.setPressed(false);
//                    actorRacquet.setPressed_energy(actorTimer.getFrame());
//                }

        if (actorRightHand != null && actorRightHand.isPressed()) {
            actorRightHand.setPressed(false);
            actorRightHand.setTime_to_death(0.1f);
        }

        if (actorLeftHand != null && actorLeftHand.isPressed()) {
            actorLeftHand.setPressed(false);
            actorLeftHand.setTime_to_death(0.1f);
        }

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }


}
