package ru.vgtrofimov.ballsshmalls.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Vector;

import ru.vgtrofimov.ballsshmalls.Balls;
import ru.vgtrofimov.ballsshmalls.actors.ActorBackground;
import ru.vgtrofimov.ballsshmalls.actors.ActorBall;
import ru.vgtrofimov.ballsshmalls.actors.ActorShape;
import ru.vgtrofimov.ballsshmalls.actors.ActorLeftHand;
import ru.vgtrofimov.ballsshmalls.actors.ActorRacquet;
import ru.vgtrofimov.ballsshmalls.actors.ActorRightHand;
import ru.vgtrofimov.ballsshmalls.actors.ActorShapeLine;
import ru.vgtrofimov.ballsshmalls.actors.ActorTimer;
import ru.vgtrofimov.ballsshmalls.screens.GameScreen;
import ru.vgtrofimov.ballsshmalls.settings.Score;
import ru.vgtrofimov.ballsshmalls.settings.Setup;
import ru.vgtrofimov.ballsshmalls.textures.Textures;

public class GameStage extends StageParent {

    Score score;
    Textures textures;
    InputProcessor inputProcessor;
    public static int game_world_width, game_world_height;

    ActorBall actorBall;
    ActorRacquet actorRacquet;
    ActorShapeLine actorShapeLine;
    int correct_camera_y;

    Vector<ActorShape> actorShape;

    ActorRightHand actorRightHand;
    ActorLeftHand actorLeftHand;
    ActorTimer actorTimer;

    public GameStage(GameScreen gameScreen, Setup setup, Viewport viewport, OrthographicCamera camera, Textures textures) {
        super(gameScreen, setup, viewport, camera);

        this.textures = textures;

        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        reset();
    }

    private void reset() {

        inputProcessor = new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
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
                if (actorTimer != null) {
                    actorTimer.setRandomFrame();
                    actorTimer.setPressed(true);
                } else {
                    if (actorBall.getY() > Gdx.graphics.getHeight() / 2) {
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
                }
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                if (actorTimer != null && actorTimer.isPressed()) {
                    actorTimer.setPressed(false);
                    actorRacquet.setPressed_energy(actorTimer.getFrame());
                }

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
        };

        Gdx.input.setInputProcessor(inputProcessor);

        correct_camera_y = 128;
        score = new Score(setup);
        addActors();
    }

    private void addActors() {
        ActorBackground actorBackground = new ActorBackground(textures.getBackground());
        int sx = 100 + (int) (Math.random() * 200);
        if (Math.random() < 0.5) sx *= -1;
        actorBall = new ActorBall(textures.getBall(), textures.getBall_shadow(),
                game_world_width / 2,
                game_world_height - 512, // (int) (camera.viewportHeight / 2),
                (int) sx,
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

        int speed[] = {-10, -20, -30, 30, 20, 10};
        int number = 15;
        int[] shapes = new int[number];

        int line = (int) ((game_world_height * 0.9f) / number);

        actorShape = new Vector<>();

        for (int i = 0; i < number; i++) {
            int shp = (int) (Math.random() * textures.getShapes().length);
            shapes[i] = shp;
            actorShape.add(new ActorShape(textures.getShapes()[shp], shp,
                    textures.getCircle(),
                    64 + (int) (Math.random() * (game_world_width - 128)), line * i + (int) (Math.random() * line),
                    speed[(int) (Math.random() * speed.length)], speed[(int) (Math.random() * speed.length)],
                    100 + (int) (Math.random() * 200), 50 + (int) (Math.random() * 50),
                    game_world_width, game_world_height)
                    );
            addActor(actorShape.lastElement());
        }

        shapes = shuffleShapes(shapes);
        score.createTask(shapes);

        addActor(actorBall);

        actorShapeLine = new ActorShapeLine(textures.getShapes(), score);
        addActor(actorShapeLine);
    }

    private int[] shuffleShapes(int[] sh) {
        for (int i = 0; i < sh.length * 3; i++) {
            int pos1 = (int) (Math.random() * sh.length);
            int pos2 = (int) (Math.random() * sh.length);
            int tmp = sh[pos1];
            sh[pos2] = sh[pos1];
            sh[pos1] = tmp;
        }
        return sh;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        checkHand();
        calc_camera_pos(delta);

        check_collision_player_and_shape();

        if (actorShapeLine != null) {
            actorShapeLine.setX(camera.position.x - camera.viewportWidth / 2);
            actorShapeLine.setY(camera.position.y - camera.viewportHeight / 2);
        }
    }

    private void check_collision_player_and_shape() {
        for (ActorShape ash : actorShape) {
            if (ash.isEnabled() && ash.isCollision(actorBall)) {
                if (score.checkShape(ash.getNumber_shape())) {
                    score.addScore(1);
                } else {
                    score.decScore(3);
                }
                ash.setEnabled(false);
            }
        }
    }


    private void checkHand() {
        if (actorRightHand != null) {
            actorRightHand.setX(actorBall.getX() - 2);
            actorRightHand.setY(actorBall.getY() + 16);
            if (!actorRightHand.isEnabled()) {
                actorRightHand.remove();
                actorRightHand = null;
            }
        }

        if (actorLeftHand != null) {
            actorLeftHand.setX(actorBall.getX() - 30);
            actorLeftHand.setY(actorBall.getY() + 16);
            if (!actorLeftHand.isEnabled()) {
                actorLeftHand.remove();
                actorLeftHand = null;
            }
        }
    }

    private void calc_camera_pos(float delta) {
        /** РАСЧЁТ ПОЗИЦИИ КАМЕРЫ */

        if (actorTimer != null) actorTimer.setX(actorRacquet.getX() - 32);


        /**
         * Это какой-то пипец с расчётами камеры.
         * По факту - взял correct_camera_y для расчёта коррекции оси Y камеры в
         * зависимости от приближения или удаления шара от верхней и нижней границы.
         * Куча ифов, которые я объяснить не смогу. Но вроде роботает.
         * --- я даже не уверен, что код не рандомный ---
         * 15/05/22
         */

        int cam_pos_x = (int) (game_world_width / 2);
        int cam_pos_y = (int) (actorBall.getY());

        if (cam_pos_y > game_world_height - camera.viewportHeight / 2) {
            cam_pos_y = (int) (game_world_height - camera.viewportHeight / 2);

            if (actorBall.getSpeedY() > 0) correct_camera_y = 0;
        } else if (cam_pos_y < camera.viewportHeight / 2) {
            cam_pos_y = (int) (camera.viewportHeight / 2);
            if (actorBall.getSpeedY() <= 0) correct_camera_y = 0;
        }

        if (cam_pos_y > game_world_height - camera.viewportHeight * 2  && actorBall.getSpeedY() > 0) {
            correct_camera_y += 512 * delta;
        } else if (cam_pos_y < game_world_height - camera.viewportHeight && actorBall.getSpeedY() <= 0) {
            correct_camera_y -= 1024 * delta;
        }

        if (cam_pos_y + correct_camera_y < camera.viewportHeight / 2) {
            correct_camera_y = (int) (camera.viewportHeight / 2 - cam_pos_y);
        }

        if (cam_pos_y + correct_camera_y > game_world_height - camera.viewportHeight / 2) {
            correct_camera_y = (int) (game_world_height - camera.viewportHeight / 2 - cam_pos_y);
        }

        if (correct_camera_y > camera.viewportHeight / 1) correct_camera_y = (int) (camera.viewportHeight / 1);
        if (correct_camera_y < -camera.viewportHeight / 3) correct_camera_y = (int) -(camera.viewportHeight / 3);

        if (actorBall.getY() > game_world_height - camera.viewportHeight / 2) {
            if (actorTimer == null) {
                actorTimer = new ActorTimer(textures.getTimer(), textures.getBlank_timer(), (int) actorRacquet.getX() - 32, (int) (actorRacquet.getY() + 48));
                addActor(actorTimer);
            }
        } else {
            if (actorTimer != null) {
                actorTimer.remove();
                actorTimer = null;
            }
        }

        camera.position.set(cam_pos_x,cam_pos_y + correct_camera_y, 0);
        camera.update();
    }

    @Override
    public void resize(int width, int height) {

        game_world_width = 512;
        game_world_height = textures.getBackground().getRegionHeight() * Setup.count_background;

        getViewport().setWorldWidth(game_world_width);
        getViewport().setWorldHeight(game_world_width * height / width);
        getViewport().update(game_world_width, game_world_width * height / width);
    }

    @Override
    public void draw() {
        super.draw();
    }
}
