package com.mygdx.gamejam;

import java.util.HashMap;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.gamejam.controller.PlayerController;
import com.mygdx.gamejam.model.Camera;
import com.mygdx.gamejam.model.Coordinates;
import com.mygdx.gamejam.model.Ground;
import com.mygdx.gamejam.model.Player;
import com.mygdx.gamejam.model.TileMap;

public class GameJam extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture texturePlayer;
	private HashMap<Ground, Texture> groundTextureMap = new HashMap<Ground, Texture>();
	private PlayerController playerController;
	private Player player;
	private TileMap map;
	private Camera camera;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		
		texturePlayer = new Texture("img/player_png_front.png");
		
		groundTextureMap.put(Ground.GRASS, new Texture("img/grass.png"));
		groundTextureMap.put(Ground.ROCK, new Texture("img/rock1.png"));
		groundTextureMap.put(Ground.WATER, new Texture("img/water.png"));
		groundTextureMap.put(Ground.TREE, new Texture("img/tree1.png"));
		
		map = new TileMap(Settings.GROUNDMAP1, Settings.GROUNDMAP1.length, Settings.GROUNDMAP1[0].length);
		player = new Player(new Coordinates(0, 0), map);
		playerController = new PlayerController(player);
		camera = new Camera();
		
		Gdx.input.setInputProcessor(playerController);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);
		camera.update(player.getCoord().getAbs(), player.getCoord().getOrd());
		
		batch.begin();
		
		float mapStartAbs = Gdx.graphics.getWidth() / 2 - camera.getCameraAbs() * Settings.TILE_SIZE ;		
		float mapStartOrd = Gdx.graphics.getHeight() / 2 - camera.getCameraOrd() * Settings.TILE_SIZE ;
		
		for (int abs = 0; abs < map.getWidth(); abs++) {
			for (int ord = 0; ord < map.getHeight(); ord++) {
				batch.draw(groundTextureMap.get(map.getTile(abs, ord).getGroundType()),
							mapStartAbs + abs * Settings.TILE_SIZE,
							mapStartOrd + ord * Settings.TILE_SIZE,
							Settings.TILE_SIZE,
							Settings.TILE_SIZE);
			}
		}
		
		batch.draw(texturePlayer,
				   mapStartAbs + player.getCoord().getAbs() * Settings.TILE_SIZE + ((Settings.TILE_SIZE - Settings.PLAYER_WIDTH) / 2),
				   mapStartOrd + player.getCoord().getOrd() * Settings.TILE_SIZE,
				   Settings.PLAYER_WIDTH,
				   Settings.PLAYER_HEIGHT);
		
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		texturePlayer.dispose();
	}
}
