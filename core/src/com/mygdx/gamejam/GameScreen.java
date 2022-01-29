package com.mygdx.gamejam;

import java.util.HashMap;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.gamejam.controller.PlayerController;
import com.mygdx.gamejam.model.AnimationSet;
import com.mygdx.gamejam.model.Camera;
import com.mygdx.gamejam.model.Coordinates;
import com.mygdx.gamejam.model.Direction;
import com.mygdx.gamejam.model.Fireball;
import com.mygdx.gamejam.model.Ground;
import com.mygdx.gamejam.model.Orb;
import com.mygdx.gamejam.model.OrbType;
import com.mygdx.gamejam.model.Player;
import com.mygdx.gamejam.model.TileMap;

public class GameScreen implements Screen {
	private final NightHunt game;
	
	private Texture fullHeartTexture;
	private Texture emptyHeartTexture;
	
	private AnimationSet animations;
	private HashMap<Ground, Texture> groundTextureMap = new HashMap<Ground, Texture>();
	private HashMap<OrbType, Texture> orbTextureMap = new HashMap<OrbType, Texture>();
	private HashMap<Direction, Texture> fireballTextureMap = new HashMap<Direction, Texture>();
	private PlayerController playerController;
	private Player player;
	private TileMap map;
	private Camera camera;
	
	private Array<Texture> textureAnimationsUp = new Array<Texture>();
	private Array<Texture> textureAnimationsDown = new Array<Texture>();
	private Array<Texture> textureAnimationsLeft = new Array<Texture>();
	private Array<Texture> textureAnimationsRight = new Array<Texture>();
	
	public GameScreen(final NightHunt game) {
		this.game = game;

		fullHeartTexture = new Texture("img/heart_full.png");
		emptyHeartTexture = new Texture("img/heart_empty.png");
		
		textureAnimationsUp.add(new Texture("img/player_up_walk1.png"));
		textureAnimationsUp.add(new Texture("img/player_up_walk2.png"));
		textureAnimationsDown.add(new Texture("img/player_down_walk1.png"));
		textureAnimationsDown.add(new Texture("img/player_down_walk2.png"));
		textureAnimationsLeft.add(new Texture("img/player_left_walk1.png"));
		textureAnimationsLeft.add(new Texture("img/player_left_walk2.png"));
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
		
		fireballTextureMap.put(Direction.DOWN, new Texture("img/fireball_down.png"));
		fireballTextureMap.put(Direction.UP, new Texture("img/fireball_up.png"));
		fireballTextureMap.put(Direction.LEFT, new Texture("img/fireball_left.png"));
		fireballTextureMap.put(Direction.RIGHT, new Texture("img/fireball_right.png"));
		
		map = new TileMap(Settings.GROUNDMAP1, Settings.GROUNDMAP1[0].length, Settings.GROUNDMAP1[0].length);
		player = new Player(new Coordinates(30, 20), map, animations);
		// map = new TileMap(Settings.GROUNDMAP1, Settings.GROUNDMAP1.length, Settings.GROUNDMAP1[0].length);
		playerController = new PlayerController(player);
		camera = new Camera();
		
		// Gdx.input.setInputProcessor(playerController);
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(playerController);
		
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0, 0);
		
		playerController.update(delta);
		camera.update(player.getCurrentCoord().getAbs(), player.getCurrentCoord().getOrd());
		player.update(delta);
		
		Iterator<Fireball> fireballList = map.getFireballList().iterator();
	    while (fireballList.hasNext()) {
	    	Fireball fireball = fireballList.next();
	    	if (fireball.update(delta)) fireballList.remove();
	    }
		
		game.batch.begin();
		
		float mapStartAbs = Gdx.graphics.getWidth() / 2 - camera.getCameraAbs() * Settings.TILE_SIZE ;		
		float mapStartOrd = Gdx.graphics.getHeight() / 2 - camera.getCameraOrd() * Settings.TILE_SIZE ;
		
		for (int abs = 0; abs < map.getWidth(); abs++) {
			for (int ord = 0; ord < map.getHeight(); ord++) {
				game.batch.draw(groundTextureMap.get(map.getTile(abs, ord).getGroundType()),
						   mapStartAbs + abs * Settings.TILE_SIZE,
						   mapStartOrd + ord * Settings.TILE_SIZE,
						   Settings.TILE_SIZE,
						   Settings.TILE_SIZE);
			}
		}
		
		for (Orb orb : map.getOrbsList()) { 		      
	           game.batch.draw(orbTextureMap.get(orb.getOrbType()),
					   	  mapStartAbs + orb.getCoord().getAbs() * Settings.TILE_SIZE,
					   	  mapStartOrd + orb.getCoord().getOrd() * Settings.TILE_SIZE,
					   	  Settings.TILE_SIZE,
					   	  Settings.TILE_SIZE); 		
	    }
		
		for (Fireball fireball : map.getFireballList()) {
			game.batch.draw(fireballTextureMap.get(fireball.getCurrentDir()),
							mapStartAbs + fireball.getCoord().getAbs() * Settings.TILE_SIZE,
							mapStartOrd + fireball.getCoord().getOrd() * Settings.TILE_SIZE,
							Settings.TILE_SIZE,
							Settings.TILE_SIZE);
		}
		
		for (int nbLifePoint = 0; nbLifePoint < player.getLifePoint(); nbLifePoint++) {
			game.batch.draw(fullHeartTexture, 
							Settings.LIFEABS + nbLifePoint * (Settings.LIFESIZE + Settings.LIFESPACE),
							Settings.LIFEORD,
							Settings.LIFESIZE,
							Settings.LIFESIZE);
		}
		
		for (int nbLostLifePoint = Math.max(0, player.getLifePoint()); nbLostLifePoint < Settings.MAX_LIFEPOINTS; nbLostLifePoint++) {
			game.batch.draw(emptyHeartTexture, 
							Settings.LIFEABS + nbLostLifePoint * (Settings.LIFESIZE + Settings.LIFESPACE),
							Settings.LIFEORD,
							Settings.LIFESIZE,
							Settings.LIFESIZE);
		}
		
		game.batch.draw(player.getSprite(),
				   mapStartAbs + player.getCurrentCoord().getAbs() * Settings.TILE_SIZE,
				   mapStartOrd + player.getCurrentCoord().getOrd() * Settings.TILE_SIZE,
				   Settings.TILE_SIZE,
				   Settings.TILE_SIZE);
		
		game.batch.end();
		
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
		fullHeartTexture.dispose();
		emptyHeartTexture.dispose();
		for(HashMap.Entry<OrbType, Texture> orb : orbTextureMap.entrySet()) {
		    orb.getValue().dispose();
		}
		for(HashMap.Entry<Ground, Texture> ground : groundTextureMap.entrySet()) {
		    ground.getValue().dispose();
		}
		for(HashMap.Entry<Direction, Texture> fireball : fireballTextureMap.entrySet()) {
		    fireball.getValue().dispose();
		}
		for(Texture texture : textureAnimationsDown) texture.dispose();
		for(Texture texture : textureAnimationsUp) texture.dispose();
		for(Texture texture : textureAnimationsRight) texture.dispose();
		for(Texture texture : textureAnimationsLeft) texture.dispose();
		
	}

}
