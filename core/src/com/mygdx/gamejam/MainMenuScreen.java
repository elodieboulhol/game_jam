package com.mygdx.gamejam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.gamejam.controller.MenuController;
import com.mygdx.gamejam.model.SelectedLevel;

public class MainMenuScreen implements Screen {

	private final NightHunt game;

	OrthographicCamera camera;
	
	private Texture homeScreenTexture, rulesTexture, playTexture, exitTexture, arrowTexture;
	private Texture introTexture, level1Texture, level2Texture, level3Texture, backTexture;
	
	public static Sound beepSound;
	
	private MenuController menuController;
	
	private static final int OFFSET = 55;
	
	public MainMenuScreen(final NightHunt game) {
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
		
		homeScreenTexture = new Texture("img/home_screen.png");
		rulesTexture = new Texture("img/rules.png");
		playTexture = new Texture("img/menu_play.png");
		exitTexture = new Texture("img/menu_exit.png");
		arrowTexture = new Texture("img/menu_arrow.png");
		
		introTexture = new Texture("img/intro.png");
		level1Texture = new Texture("img/level1.png");
		level2Texture = new Texture("img/level2.png");
		level3Texture = new Texture("img/level3.png");
		backTexture = new Texture("img/back.png");
		
		beepSound = Gdx.audio.newSound(Gdx.files.internal("sound/beep.mp3"));
		
		menuController = new MenuController();
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(menuController);
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		
		Gdx.gl.glClearColor(41/255f, 183/255f, 195/255f, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	    game.batch.begin();

	    if (menuController.getLevelSelected() == SelectedLevel.NONE) {
	    	game.batch.draw(homeScreenTexture,
					Settings.SCREEN_WIDTH / 6 + 20,
					Settings.SCREEN_HEIGHT / 4 + 20,
					Settings.SCREEN_WIDTH / 2 + 150,
					Settings.SCREEN_HEIGHT / 2 + 100);

			game.batch.draw(rulesTexture,
					Settings.SCREEN_WIDTH / 2 + 400,
					Settings.SCREEN_HEIGHT / 8 - 90,
					Settings.SCREEN_WIDTH / 6,
					Settings.SCREEN_HEIGHT / 4);

			game.batch.draw(playTexture,
							Settings.SCREEN_WIDTH / 3,
							Settings.SCREEN_HEIGHT / 8 - 50,
							Settings.SCREEN_WIDTH / 3,
							Settings.SCREEN_HEIGHT / 2);
			game.batch.draw(exitTexture,
							Settings.SCREEN_WIDTH / 3,
							Settings.SCREEN_HEIGHT / 8 - 150,
							Settings.SCREEN_WIDTH / 3,
							Settings.SCREEN_HEIGHT / 2);
			
			if (menuController.getIsArrowOnPlay()) {
				game.batch.draw(arrowTexture,
								Settings.SCREEN_WIDTH / 6 + 40,
								Settings.SCREEN_HEIGHT / 8 - 20,
								Settings.SCREEN_WIDTH / 4 - 50,
								Settings.SCREEN_HEIGHT / 2 - 50);
			} else {
				game.batch.draw(arrowTexture,
								Settings.SCREEN_WIDTH / 6 + 40,
								Settings.SCREEN_HEIGHT / 8 - 120,
								Settings.SCREEN_WIDTH / 4 - 50,
								Settings.SCREEN_HEIGHT / 2 - 50);
			}
	    } else {
	    	game.batch.draw(introTexture,
			    			Settings.SCREEN_WIDTH / 3,
			    			Settings.SCREEN_HEIGHT / 2 + OFFSET,
							Settings.SCREEN_WIDTH / 3,
							Settings.SCREEN_HEIGHT / 2);

			game.batch.draw(level1Texture,
							Settings.SCREEN_WIDTH / 3,
							Settings.SCREEN_HEIGHT / 3 + OFFSET,
							Settings.SCREEN_WIDTH / 3,
							Settings.SCREEN_HEIGHT / 2);

			game.batch.draw(level2Texture,
							Settings.SCREEN_WIDTH / 3,
							Settings.SCREEN_HEIGHT / 6 + OFFSET,
							Settings.SCREEN_WIDTH / 3,
							Settings.SCREEN_HEIGHT / 2);
			
			game.batch.draw(level3Texture,
							Settings.SCREEN_WIDTH / 3,
							OFFSET,
							Settings.SCREEN_WIDTH / 3,
							Settings.SCREEN_HEIGHT / 2);
			
			game.batch.draw(backTexture,
							Settings.SCREEN_WIDTH / 3,
							-Settings.SCREEN_HEIGHT / 6 + OFFSET,
							Settings.SCREEN_WIDTH / 3,
							Settings.SCREEN_HEIGHT / 2);
			
			game.batch.draw(arrowTexture,
							Settings.SCREEN_WIDTH / 6 + 20,
							menuController.getLevelSelected().getValue() * Settings.SCREEN_HEIGHT / 6 + OFFSET + 60,
							Settings.SCREEN_WIDTH / 6,
							Settings.SCREEN_HEIGHT / 3);
	    }
		
		game.batch.end();
		
		if (menuController.getShouldGameStart()) {
			game.setScreen(new GameScreen(game));
		} else if (menuController.getShouldGameStop()) {
			Gdx.app.exit();
			System.exit(0);
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		
	}
}



