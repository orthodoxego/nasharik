package ru.vgtrofimov.ballsshmalls;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import ru.vgtrofimov.ballsshmalls.Balls;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);

		int width = 1200, height = 2640;
		float ratio = 0.5f;

		config.setWindowedMode((int) (width * ratio), (int) (height * ratio));
		config.setTitle("BallsShmalls");
		new Lwjgl3Application(new Balls(), config);
	}
}
