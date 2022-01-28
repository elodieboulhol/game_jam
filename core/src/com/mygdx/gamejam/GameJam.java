package com.mygdx.gamejam;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameJam extends ApplicationAdapter {
	SpriteBatch batch;
	Texture texturePlayer;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		texturePlayer = new Texture("img/player_png_front.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);
		batch.begin();
		batch.draw(texturePlayer, 0, 0, 32, 48);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		texturePlayer.dispose();
	}
}
