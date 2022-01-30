package com.mygdx.gamejam.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.gamejam.NightHunt;
import com.mygdx.gamejam.Settings;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "NightHunt";
		config.width = Settings.SCREEN_WIDTH;
		config.height = Settings.SCREEN_HEIGHT;
		config.resizable = false;
		new LwjglApplication(new NightHunt(), config);
	}
}
