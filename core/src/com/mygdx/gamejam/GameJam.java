package com.mygdx.gamejam;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.gamejam.controller.PlayerController;
import com.mygdx.gamejam.model.Coordinates;
import com.mygdx.gamejam.model.Player;

public class GameJam extends ApplicationAdapter {
	SpriteBatch batch;
	Texture texturePlayer;
	PlayerController playerController;
	Player player;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		texturePlayer = new Texture("img/player_png_front.png");
		player = new Player(new Coordinates(0, 0));
		playerController = new PlayerController(player);
		
		Gdx.input.setInputProcessor(playerController);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);
		batch.begin();
		batch.draw(texturePlayer,
				   player.getCoord().getAbs() * Settings.TILE_SIZE,
				   player.getCoord().getOrd() * Settings.TILE_SIZE,
				   32,
				   48);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		texturePlayer.dispose();
	}
}
