package ru.vgtrofimov.nasharik.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Vector;

import ru.vgtrofimov.nasharik.Balls;
import ru.vgtrofimov.nasharik.actors.ActorBackground;
import ru.vgtrofimov.nasharik.actors.ActorBall;
import ru.vgtrofimov.nasharik.actors.ActorCat;
import ru.vgtrofimov.nasharik.actors.ActorCircleEffect;
import ru.vgtrofimov.nasharik.actors.ActorSpring;
import ru.vgtrofimov.nasharik.actors.ActorShape;
import ru.vgtrofimov.nasharik.actors.ActorLeftHand;
import ru.vgtrofimov.nasharik.actors.ActorRacquet;
import ru.vgtrofimov.nasharik.actors.ActorRightHand;
import ru.vgtrofimov.nasharik.actors.ActorShapeLine;
import ru.vgtrofimov.nasharik.actors.ActorTeleport;
import ru.vgtrofimov.nasharik.actors.ActorTextMoveYtoY;
import ru.vgtrofimov.nasharik.actors.ActorWizard;
import ru.vgtrofimov.nasharik.actors.help.ActorHelpStaticTime;
import ru.vgtrofimov.nasharik.screens.GameScreen;
import ru.vgtrofimov.nasharik.services.VectorMoveShapes;
import ru.vgtrofimov.nasharik.settings.GameConstant;
import ru.vgtrofimov.nasharik.settings.Levels;
import ru.vgtrofimov.nasharik.services.PositionUnit;
import ru.vgtrofimov.nasharik.settings.Score;
import ru.vgtrofimov.nasharik.settings.Setup;
import ru.vgtrofimov.nasharik.settings.Sound;
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
    int cam_move_to_Y = -1;
    float cam_step_move_to = -1;
    ActorTeleport objTeleport = null;
    ActorCat actorCat;

    public static boolean isCollision = true;
    public static boolean isGrabShape = true;
    public static boolean isMouseGlue = false;
    public static int correct_mouse_Y = 0;

    Vector<ActorShape> actorShape;
    Vector<ActorSpring> actorSprings;
    Vector<ActorTeleport> actorTeleport;
    Vector<ActorWizard> actorWizard;
    VectorMoveShapes vectorMoveShapes;
    Vector<ActorCircleEffect> actorStarsGrab;

    ActorRightHand actorRightHand;
    ActorLeftHand actorLeftHand;
    // ActorTimer actorTimer;

    int countSpring; // Количество ударов о пружину

    public GameStage(GameScreen gameScreen, Setup setup, Viewport viewport, OrthographicCamera camera, Textures textures, Sound sound) {
        super(gameScreen, setup, sound, viewport, camera);

        countSpring = 0;
        this.textures = textures;

        // resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        resize((int) viewport.getWorldWidth(), (int) viewport.getWorldHeight());
        Balls.log(getClass().getName(), "" + viewport.getWorldWidth() + " " + viewport.getWorldHeight());

        camera.position.x = 10;
        camera.position.y = 10;


        hardReset();
    }

    private void hardReset() {
        score = new Score(setup);
        softReset();
    }

    public void softReset() {

        if (actorBall != null) actorBall.remove();
        if (actorCat != null) {
            actorCat.remove();
            actorCat = null;
        }

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
        actorBall = new ActorBall(textures.getBall(), textures.getBall_shadow(), sound,
                game_world_width / 2,
                (int) (game_world_height * 0.95f), // (int) (camera.viewportHeight / 2),
                sx,
                50,
                game_world_width,
                game_world_height);

        actorRacquet = new ActorRacquet(textures.getRacquet(), sound, actorBall, game_world_width, game_world_height);
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

        actorShapeLine = new ActorShapeLine(textures.getShapes(), textures.getBlackHole(), score, (int) camera.viewportHeight);
        addActor(actorShapeLine);

    }

    private void addTech(Levels lev) {
        Vector<PositionUnit> tech = lev.getLevel(setup.getLevel() - 1);
        actorSprings = new Vector<>();
        actorTeleport = new Vector<>();
        actorWizard = new Vector<>();

        int[] speed = {-1, -2, -3, 3, 2, 1};
        for (PositionUnit pu : tech) {
            switch (pu.code) {
                case GameConstant.MINE:
                    actorSprings.add(new ActorSpring(textures.getTechobject()[pu.code - GameConstant.CORRECT_TECH], pu.code,
                            pu.x, pu.y,
                            0, 0, // speed[(int) (Math.random() * speed.length)], speed[(int) (Math.random() * speed.length)],
                            0, 0, // 5 + (int) (Math.random() * 20), 5 + (int) (Math.random() * 20),
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
                case GameConstant.WIZARD:
                    actorWizard.add(new ActorWizard(textures.getTechobject()[pu.code - GameConstant.CORRECT_TECH], pu.code,
                            pu.x, pu.y,
                            0, 0,
                            0, 0,
                            game_world_width, game_world_height));
                    addActor(actorWizard.lastElement());
                default:
                    break;
            }
        }
    }

    public void addShapes(Levels lev) {

        Vector<PositionUnit> level = lev.getLevel(setup.getLevel() - 1);
        Vector<Integer> shapes = lev.getGrabber(setup.getLevel() - 1);
        vectorMoveShapes = null;
        actorShape = new Vector<>();
        for (PositionUnit pu : level) {
            if (pu.code <= 6) {
                actorShape.add(new ActorShape(textures.getShapes()[pu.code], pu.code,
                        pu.x, pu.y,
                        0, 0,//speed[(int) (Math.random() * speed.length)] * 0.5f, speed[(int) (Math.random() * speed.length)] * 0.5f,
                        0, 0,//  + (int) (Math.random() * 130), 5 + (int) (Math.random() * 50),
                        game_world_width, game_world_height)
                );
                addActor(actorShape.lastElement());
            }
        }
        score.createTask(shapes);
        if (score.getLevel() >= new Levels().getCountAllLevel()) {
            gameScreen.setEndGameStage();
        }
    }

    private void addCat() {
        if (actorCat == null) {
            actorCat = new ActorCat(textures.getCat(), sound,
                    50,
                    (int) camera.position.y,
                    128, 128);
            addActor(actorCat);
        }
        if (actorShapeLine != null) actorShapeLine.toFront();
    }

    @Override
    public void act(float delta) {
        if (!pause) {
            super.act(delta);

            if (move_cam) {
                // РАСЧЁТЫ В МОМЕНТ ИГРЫ И ПЕРЕМЕЩЕНИЯ КАМЕРЫ
                if (objTeleport == null && cam_move_to_Y == -1) {
                    calc_camera_pos(delta);
                } else {
                    cam_processing_teleport(delta);
                }

                checkHand();

                if (GameStage.isMouseGlue) {
                    actorBall.setSpeedX(0);
                    actorBall.setSpeedY(0);
                    actorBall.setX(Gdx.input.getX());
                    actorBall.setY(correct_mouse_Y + Gdx.input.getY());

                    if (Gdx.input.getY() < 100) correct_mouse_Y -= Gdx.graphics.getHeight() * delta;
                    if (Gdx.input.getY() > Gdx.graphics.getHeight() * 0.9f) correct_mouse_Y += Gdx.graphics.getHeight() * delta;

                }

                if (isCollision) {
                    if (vectorMoveShapes == null) check_collision_player_and_shape();
                    check_collision_player_and_tech();
                }
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
                            gameScreen.setLoseStage();
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

            if (actorCat != null) {
                actorCat.setX(32);
                actorCat.setY(camera.position.y + camera.viewportHeight / 2);
                if (!actorCat.isEnabled()) {
                    actorCat.remove();
                    actorCat = null;
                }
            } else if (countSpring >= 3) {
                if (Math.random() * 100 < 30) {
                    addCat();
                }
                countSpring = 0;
            }

            if (actorShapeLine != null) {
                actorShapeLine.setX(camera.position.x - camera.viewportWidth / 2);
                actorShapeLine.setY(camera.position.y - camera.viewportHeight * 0.5f);
            }

            if (vectorMoveShapes != null) {
                vectorMoveShapes.act(actorShape, delta);
                if (vectorMoveShapes.isFinalMoving())
                    vectorMoveShapes = null;
            }

        }
    }

    private void removeActorFrames() {
        for (ActorCircleEffect af : actorStarsGrab) {
            if (!af.isEnabled()) af.remove();
        }

        for (int i = actorStarsGrab.size() - 1; i > -1; i--) {
            if (!actorStarsGrab.elementAt(i).isEnabled()) actorStarsGrab.removeElement(actorStarsGrab.elementAt(i));
        }
    }

    private void check_collision_player_and_shape() {
//        for (ActorCircleEffect asg : actorStarsGrab) {
//            asg.setX(actorBall.getX() - 64);
//            asg.setY(actorBall.getY() - 64);
//        }

        if (isGrabShape) {
            for (ActorShape ash : actorShape) {
                if (ash.isEnabled() && ash.isCollision(actorBall)) {
                    if (score.checkShape(ash.getNumber_shape())) {
                        score.addScore(1);
                        actorBall.addScalle(actorBall.getScaleX() + 0.03f);
                        actorStarsGrab.add(new ActorCircleEffect(textures.getStars(),
                                (int) ash.getX() - 64, (int) ash.getY() - 64));

                        addActor(actorStarsGrab.lastElement());
                        sound.play(Sound.SOUND.GRAB_FIGURE);

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
    }

    private void check_collision_player_and_tech() {
        for (ActorSpring am : actorSprings) {
            if (am.isEnabled() && am.getScaleX() == 1 && am.isCollision(actorBall)) {
                // am.setEnabled(false);
                // am.remove();
                am.setScale(2.5f, 2.5f);
                countSpring += 1;
                actorBall.setSpeedX(-actorBall.getSpeedX() * 4);
                actorBall.setSpeedY(-actorBall.getSpeedY() * 4);
                actorBall.check_move_balls(Gdx.graphics.getDeltaTime());
                actorBall.check_move_balls(Gdx.graphics.getDeltaTime());
                sound.play(Sound.SOUND.SPRING);
            }
        }

        for (ActorTeleport at : actorTeleport) {
            if (at.isEnabled() && at.isCollision(actorBall) && !at.isProcessing_teleport()) {
                sound.play(Sound.SOUND.TELEPORT);
                if (objTeleport != null) {
                    objTeleport.setProcessing_teleport(false);
                    cam_processing_teleport(Gdx.graphics.getDeltaTime());
                }
                at.setProcessing_teleport(true);
                cam_move_to_Y = -1;
                at.setScale(0f, 0f);
                actorBall.setTempAlpha(0);
                objTeleport = at;
                actorBall.setX(objTeleport.getTeleportToX());
                actorBall.setY(objTeleport.getTeleportToY());
                actorBall.setSpeedX(0);
                actorBall.setSpeedY(0);
            }
        }

        if (vectorMoveShapes == null) {
            for (ActorWizard aw : actorWizard) {
                if (aw.getScaleX() == 1 && aw.isEnabled() && aw.isCollision(actorBall)) {
                    aw.setScale(0, 0);
                    vectorMoveShapes = new VectorMoveShapes(actorShape);
                    sound.play(Sound.SOUND.WIZARD);
                }
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

        if (actorBall.getSpeedY() > 50) {
            correct_camera_y += camera.viewportHeight / 4 * delta;
        }

        if (actorBall.getSpeedY() < -50 && actorBall.getY() < game_world_height - camera.viewportHeight * 0.75f) {
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

        camera.position.set(cam_pos_x,cam_pos_y + correct_camera_y, 0);
        camera.update();
    }

    private void cam_processing_teleport(float delta) {
        if (cam_move_to_Y == -1) {
            cam_move_to_Y = objTeleport.getTeleportToY();
            cam_step_move_to = (int) ((cam_move_to_Y - camera.position.y) * delta * 0.75f);
        }

        int cam_pos_x = game_world_width / 2;
        float cam_pos_y = camera.position.y + cam_step_move_to;

        if (cam_step_move_to <= 0) {
            if (cam_pos_y < cam_move_to_Y || !objTeleport.isProcessing_teleport()) {
                correct_camera_y = 0;
                cam_pos_y = cam_move_to_Y;
                cam_move_to_Y = -1;
                objTeleport = null;
            }
        } else if (cam_step_move_to > 0) {
            if (cam_pos_y > cam_move_to_Y || !objTeleport.isProcessing_teleport()) {
                correct_camera_y = 0;
                cam_pos_y = cam_move_to_Y;
                cam_move_to_Y = -1;
                objTeleport = null;
            }
        }

        camera.position.set(cam_pos_x,cam_pos_y, 0);
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

        sound.play(Sound.SOUND.BAD_RESULT);

        score.decScore(0);
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
                    camera.position.y + 300,
                    camera.position.y,
                    "УПС... ПОПРОБУЙ ЕЩЁ!", (int) camera.viewportWidth, (int) camera.viewportHeight,
                    (int) (camera.position.x - camera.viewportWidth / 2),
                    (int) (camera.position.y - camera.viewportHeight / 2));
        }

        addActor(actorTextMoveYtoY);
        actorShapeLine.toFront();
    }

    private void nextLevel() {
        // Добавляется актёр с текстом. Когда текст пройдёт, актёр удаляется и вызывается
        // softReset()
        sound.play(Sound.SOUND.GOOD_RESULT);
        move_cam = false;
        if (actorLeftHand != null) actorLeftHand.remove();
        if (actorRightHand != null) actorRightHand.remove();

        actorBall.setSpeedX(0);
        actorBall.setSpeedY(0);

        Gdx.input.setInputProcessor(null);

        if (score.getLevel() + 1 >= new Levels().getCountAllLevel()) {
            gameScreen.setEndGameStage();
        } else {
            actorTextMoveYtoY = new ActorTextMoveYtoY(textures.getWinHole(),
                    camera.position.y + 300,
                    camera.position.y,
                    "УСПЕШНО! НОВЫЙ УРОВЕНЬ: " + (score.getLevel() + 1), (int) camera.viewportWidth, (int) camera.viewportHeight,
                    (int) (camera.position.x - camera.viewportWidth / 2),
                    (int) (camera.position.y - camera.viewportHeight / 2));

            addActor(actorTextMoveYtoY);
            actorShapeLine.toFront();
        }
    }

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.NUM_4) {
            isMouseGlue = !isMouseGlue;
            correct_mouse_Y = (int) (camera.position.y - Gdx.graphics.getHeight() / 2);
        }

        if (keycode == Input.Keys.NUM_2) {
            isGrabShape = !isGrabShape;
        }

        if (keycode == Input.Keys.NUM_3) {
            int num = 0;
            while (!actorShape.elementAt(num).isEnabled()
                    || actorShape.elementAt(num).getNumber_shape() != score.getTask().elementAt(0).getNumber_shape()) {
                num += 1;
            }
            actorBall.setX(actorShape.elementAt(num).getX());
            actorBall.setY(actorShape.elementAt(num).getY());
            actorBall.setSpeedX(0);
            actorBall.setSpeedY(0);
        }
        if (keycode == Input.Keys.MINUS) score.setLives(score.getLives() - 10);
        if (keycode == Input.Keys.ESCAPE || keycode == Input.Keys.BACK) {
            sound.play(Sound.SOUND.CLICK_MENU);
            gameScreen.setLoseStage();
        }
        if (keycode == Input.Keys.NUM_1) isCollision = !isCollision;
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
        if (actorBall.getY() > camera.viewportHeight / 3 && !pause && objTeleport == null) {
            if (actorRightHand == null && actorLeftHand == null && screenX > Gdx.graphics.getWidth() / 2) {
                actorRightHand = new ActorRightHand(actorBall, textures.getRightHand(), (int) actorBall.getX(), (int) actorBall.getY());
                actorRightHand.setPressed(true);
                addActor(actorRightHand);
            }

            if (actorLeftHand == null && actorRightHand == null && screenX <= Gdx.graphics.getWidth() / 2) {
                actorLeftHand = new ActorLeftHand(actorBall, textures.getLeftHand(), (int) actorBall.getX(), (int) actorBall.getY());
                actorLeftHand.setPressed(true);
                addActor(actorLeftHand);
            }
        }
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
            sound.play(Sound.SOUND.HAND);
        }

        if (actorLeftHand != null && actorLeftHand.isPressed()) {
            actorLeftHand.setPressed(false);
            actorLeftHand.setTime_to_death(0.1f);
            sound.play(Sound.SOUND.HAND);
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
