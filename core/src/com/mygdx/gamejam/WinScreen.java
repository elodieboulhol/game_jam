package com.mygdx.gamejam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class WinScreen implements Screen {
	
	private NightHunt game;
	
	private Stage stage;
	private Viewport viewport;
	
	private Music winMusic;
	
	private Texture winTexture;

	public WinScreen(NightHunt game) {
		this.game = game;
		viewport = new FitViewport(Settings.SCREEN_WIDTH, 
								   Settings.SCREEN_HEIGHT,
								   new OrthographicCamera());
		stage = new Stage(viewport, game.batch);
		
		winTexture = new Texture("img/win_screen.png");
		Image winImage = new Image(winTexture);
		
		Table table = new Table();
		table.center();
		table.setFillParent(true);
		table.add(winImage).expandX();
		table.row();
		
		stage.addActor(table);
		
		winMusic = Gdx.audio.newMusic(Gdx.files.internal("sound/win.mp3"));
		winMusic.setLooping(true);
	}
	
	@Override
	public void show() {
		winMusic.play();

	}

	@Override
	public void render(float delta) {
		if (Gdx.input.isKeyPressed(Keys.A)) {
			game.setScreen(new MainMenuScreen(game));
			dispose();
		}
		
		Gdx.gl.glClearColor(41/255f, 183/255f, 195/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();

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
		stage.dispose();
		winTexture.dispose();
		winMusic.stop();
		winMusic.dispose();
	}

}
