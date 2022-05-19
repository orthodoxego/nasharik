package ru.vgtrofimov.nasharik;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.vgtrofimov.nasharik.screens.GameScreen;
import ru.vgtrofimov.nasharik.services.Font;
import ru.vgtrofimov.nasharik.settings.GdxViewport;
import ru.vgtrofimov.nasharik.settings.Setup;
import ru.vgtrofimov.nasharik.settings.Sound;
import ru.vgtrofimov.nasharik.textures.Textures;


public class Balls extends ApplicationAdapter {

	private OrthographicCamera camera;
	private Viewport viewport;
	private AssetManager manager;

	// Настройки
	Setup setup;
	Sound sound;

	// Игровые классы
	GameScreen gameScreen;
	Textures textures;

	// Пауза
	boolean pause = false;
	public static Font font;
	
	@Override
	public void create () {

		camera = new OrthographicCamera();

		camera.setToOrtho(true, GdxViewport.WORLD_WIDTH, GdxViewport.WORLD_HEIGHT);
		// viewport = new FillViewport(GdxViewport.WORLD_WIDTH, GdxViewport.WORLD_HEIGHT, camera);
		viewport = new FillViewport(GdxViewport.WORLD_WIDTH, GdxViewport.WORLD_WIDTH * ((float) Gdx.graphics.getHeight() / Gdx.graphics.getWidth()), camera);

		setup = new Setup();
		sound = new Sound(setup);

		manager = new AssetManager();
		textures = new Textures();

		font = new Font();

		gameScreen = new GameScreen(this, setup, sound, viewport, camera, manager, textures);

	}

	public static Balls self() {
		/* Возвращает главный класс игры из любого места. */
		return (Balls) Gdx.app.getApplicationListener();
	}

	public static void log(String nameClass, String msg) {
		Gdx.app.log(Setup.APP_ID, nameClass + ": " + msg);
	}

	 public static void log(String msg) {
		 Gdx.app.log(Setup.APP_ID, "NO CLASS: " + msg);
	 }

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
		setup.savePrefs();
		pause = true;
		gameScreen.pause();
	}

	@Override
	public void resume() {
		super.resume();
		pause = false;
		gameScreen.resume();
	}



	@Override
	public void dispose () {

	}

}
