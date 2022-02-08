package com.mygdx.gamejam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {

	private final NightHunt game;

	OrthographicCamera camera;
	
	Texture homeScreenTexture, rulesTexture, playTexture, exitTexture, arrowTexture;
	
	private Sound beepSound;
	
	private boolean isArrowOnPlay = true;
	
	public MainMenuScreen(final NightHunt game) {
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
		
		homeScreenTexture = new Texture("img/home_screen.png");
		rulesTexture = new Texture("img/rules.png");
		playTexture = new Texture("img/menu_play.png");
		exitTexture = new Texture("img/menu_exit.png");
		arrowTexture = new Texture("img/menu_arrow.png");
		
		beepSound = Gdx.audio.newSound(Gdx.files.internal("sound/beep.mp3"));
	}
	
	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		
		Gdx.gl.glClearColor(41/255f, 183/255f, 195/255f, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	    game.batch.begin();

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
		
		if (isArrowOnPlay) {
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
		
		game.batch.end();

		if (Gdx.input.isKeyJustPressed(Keys.UP) || Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			if (isArrowOnPlay) isArrowOnPlay = false;
			else isArrowOnPlay = true;
			beepSound.play();
		}
		if (Gdx.input.isKeyPressed(Keys.SPACE) || Gdx.input.isKeyPressed(Keys.ENTER)) {
			if (isArrowOnPlay) {
				game.setScreen(new GameScreen(game));
			} else {
				Gdx.app.exit();
				System.exit(0);
			}
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
		
		playTexture.dispose();
		exitTexture.dispose();
		arrowTexture.dispose();
		
		beepSound.dispose();
		
	}

}
