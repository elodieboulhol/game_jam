package com.mygdx.gamejam.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.gamejam.NightHunt;

public class DesktopLauncher {
	public static void main (String[] arg) {
		System.out.println("tetst");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "NightHunt";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new NightHunt(), config);
	}
}
