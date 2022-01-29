package com.mygdx.gamejam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {

	private final NightHunt game;

	OrthographicCamera camera;
	
	Texture playTexture, exitTexture, arrowTexture;
	
	private boolean isArrowOnPlay = true;
	
	public MainMenuScreen(final NightHunt game) {
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
		
		playTexture = new Texture("img/menu_play.png");
		exitTexture = new Texture("img/menu_exit.png");
		arrowTexture = new Texture("img/menu_arrow.png");
	}
	
	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);

		game.batch.begin();
		
		game.batch.draw(playTexture,
						Settings.SCREEN_WIDTH / 3,
						Settings.SCREEN_HEIGHT / 2,
						Settings.SCREEN_WIDTH / 3,
						Settings.SCREEN_HEIGHT / 2);
		game.batch.draw(exitTexture,
						Settings.SCREEN_WIDTH / 3,
						Settings.SCREEN_HEIGHT / 4,
						Settings.SCREEN_WIDTH / 3,
						Settings.SCREEN_HEIGHT / 2);
		
		if (isArrowOnPlay) {
			game.batch.draw(arrowTexture,
							Settings.SCREEN_WIDTH / 6,
							Settings.SCREEN_HEIGHT / 2,
							Settings.SCREEN_WIDTH / 4,
							Settings.SCREEN_HEIGHT / 2);
		} else {
			game.batch.draw(arrowTexture,
							Settings.SCREEN_WIDTH / 6,
							Settings.SCREEN_HEIGHT / 4,
							Settings.SCREEN_WIDTH / 4,
							Settings.SCREEN_HEIGHT / 2);
		}
		
		game.batch.end();

		if (Gdx.input.isKeyJustPressed(Keys.UP) || Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			if (isArrowOnPlay) isArrowOnPlay = false;
			else isArrowOnPlay = true;
		}
		if (Gdx.input.isKeyPressed(Keys.SPACE) || Gdx.input.isKeyPressed(Keys.ENTER)) {
			if (isArrowOnPlay) {
				game.setScreen(new GameScreen(game));
				dispose();
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
		// TODO Auto-generated method stub
		
	}

}
