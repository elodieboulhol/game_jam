package com.mygdx.gamejam;

import java.util.HashMap;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.gamejam.controller.PlayerController;
import com.mygdx.gamejam.model.AnimationSet;
import com.mygdx.gamejam.model.Camera;
import com.mygdx.gamejam.model.Coordinates;
import com.mygdx.gamejam.model.Ground;
import com.mygdx.gamejam.model.Orb;
import com.mygdx.gamejam.model.OrbType;
import com.mygdx.gamejam.model.Player;
import com.mygdx.gamejam.model.TileMap;

public class GameJam extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture texturePlayer;
	private AnimationSet animations;
	private HashMap<Ground, Texture> groundTextureMap = new HashMap<Ground, Texture>();
	private HashMap<OrbType, Texture> orbTextureMap = new HashMap<OrbType, Texture>();
	private PlayerController playerController;
	private Player player;
	private TileMap map;
	private Camera camera;

	@Override
	public void create () {
		batch = new SpriteBatch();
		
		texturePlayer = new Texture("img/player_down.png");

		Array<Texture> textureAnimationsUp = new Array<Texture>();
		textureAnimationsUp.add(new Texture("img/player_up_walk1.png"));
		textureAnimationsUp.add(new Texture("img/player_up_walk2.png"));
		
		Array<Texture> textureAnimationsDown = new Array<Texture>();
		textureAnimationsDown.add(new Texture("img/player_down_walk1.png"));
		textureAnimationsDown.add(new Texture("img/player_down_walk2.png"));

		Array<Texture> textureAnimationsLeft = new Array<Texture>();
		textureAnimationsLeft.add(new Texture("img/player_left_walk1.png"));
		textureAnimationsLeft.add(new Texture("img/player_left_walk2.png"));

		Array<Texture> textureAnimationsRight = new Array<Texture>();
		textureAnimationsRight.add(new Texture("img/player_right_walk1.png"));
		textureAnimationsRight.add(new Texture("img/player_right_walk2.png"));
		
		animations = new AnimationSet(
							new Animation<Texture>(0.3f/2f, textureAnimationsUp, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/2f, textureAnimationsDown, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/2f, textureAnimationsLeft, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/2f, textureAnimationsRight, PlayMode.LOOP_PINGPONG),
							new Texture("img/player_up.png"),
							new Texture("img/player_down.png"),
							new Texture("img/player_left.png"),
							new Texture("img/player_right.png")
						);
		
		groundTextureMap.put(Ground.GRASS, new Texture("img/grass.png"));
		groundTextureMap.put(Ground.ROCK, new Texture("img/rock1.png"));
		groundTextureMap.put(Ground.WATER, new Texture("img/water.png"));
		groundTextureMap.put(Ground.TREE, new Texture("img/tree1.png"));
		
		orbTextureMap.put(OrbType.ICE, new Texture("img/orb_blue.png"));
		orbTextureMap.put(OrbType.ATTACK, new Texture("img/orb_orange.png"));
		orbTextureMap.put(OrbType.LIFE, new Texture("img/orb_red.png"));
		
		map = new TileMap(Settings.GROUNDMAP1, Settings.GROUNDMAP1[0].length, Settings.GROUNDMAP1[0].length);
		player = new Player(new Coordinates(30, 20), map, animations);
		// map = new TileMap(Settings.GROUNDMAP1, Settings.GROUNDMAP1.length, Settings.GROUNDMAP1[0].length);
		playerController = new PlayerController(player);
		camera = new Camera();
		
		Gdx.input.setInputProcessor(playerController);
	}

	@Override
	public void render () {
		float delta = Gdx.graphics.getDeltaTime();
		
		ScreenUtils.clear(0, 0, 0, 0);
		
		playerController.update(delta);
		camera.update(player.getCurrentCoord().getAbs(), player.getCurrentCoord().getOrd());
		player.update(delta);
		
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
		
		for (Orb orb : map.getOrbsList()) { 		      
	           batch.draw(orbTextureMap.get(orb.getOrbType()),
					   	  mapStartAbs + orb.getCoord().getAbs() * Settings.TILE_SIZE,
					   	  mapStartOrd + orb.getCoord().getOrd() * Settings.TILE_SIZE,
					   	  Settings.TILE_SIZE,
					   	  Settings.TILE_SIZE); 		
	    }
		
		batch.draw(player.getSprite(),
				   mapStartAbs + player.getCurrentCoord().getAbs() * Settings.TILE_SIZE + ((Settings.TILE_SIZE - Settings.PLAYER_WIDTH) / 2),
				   mapStartOrd + player.getCurrentCoord().getOrd() * Settings.TILE_SIZE,
				   Settings.TILE_SIZE,
				   Settings.TILE_SIZE);
		
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		texturePlayer.dispose();
	}
}
