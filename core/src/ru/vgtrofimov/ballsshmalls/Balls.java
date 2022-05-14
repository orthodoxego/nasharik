package ru.vgtrofimov.ballsshmalls;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.ballsshmalls.screens.GameScreen;
import ru.vgtrofimov.ballsshmalls.settings.GdxViewport;

public class Balls extends ApplicationAdapter {

	private OrthographicCamera camera;
	private Viewport viewport;
	private AssetManager manager;

	// Игровые классы
	GameScreen gameScreen;

	// Пауза
	boolean pause = false;
	
	@Override
	public void create () {

		camera = new OrthographicCamera();
		camera.setToOrtho(true, GdxViewport.WORLD_WIDTH, GdxViewport.WORLD_HEIGHT);
		viewport = new FillViewport(GdxViewport.WORLD_WIDTH, GdxViewport.WORLD_HEIGHT, camera);

		manager = new AssetManager();

		// gameScreen = new GameScreen(this, setup, viewport, camera, manager, font, textures);

	}

	public static Balls self() {
		/** Возвращает главный класс игры из любого места. **/
		return (Balls) Gdx.app.getApplicationListener();
	}

	public static void log(String nameClass, String msg) {
		// Gdx.app.log(Setup.APP_ID, nameClass + ": " + msg);
	}

	// public static void log(String msg) {
		// Gdx.app.log(Setup.APP_ID, "NO CLASS: " + msg);
	// }

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		if (!pause) {
			gameScreen.render(Gdx.graphics.getDeltaTime());
		}
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		viewport.update(width, height);
		GdxViewport.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
		pause = true;
	}

	@Override
	public void resume() {
		super.resume();
		pause = false;
	}

	@Override
	public void dispose () {
	}

}
