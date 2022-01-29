package com.mygdx.gamejam;

import java.util.HashMap;

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
import com.mygdx.gamejam.model.Ground;
import com.mygdx.gamejam.model.Monster;
import com.mygdx.gamejam.model.MonsterType;
import com.mygdx.gamejam.model.Orb;
import com.mygdx.gamejam.model.OrbType;
import com.mygdx.gamejam.model.Player;
import com.mygdx.gamejam.model.TileMap;

public class GameScreen implements Screen {
	private final NightHunt game;
	
	private Texture fullHeartTexture;
	private Texture emptyHeartTexture;
	
	private AnimationSet animationsPlayer;
	private AnimationSet animationsMonster;
	private HashMap<Ground, Texture> groundTextureMap = new HashMap<Ground, Texture>();
	private HashMap<OrbType, Texture> orbTextureMap = new HashMap<OrbType, Texture>();
	private HashMap<MonsterType, Texture> monsterTextureMap = new HashMap<MonsterType, Texture>();
	private PlayerController playerController;
	private Player player;
	private TileMap map;
	private Camera camera;
	

	private Array<Texture> textureAnimationsPlayerUp = new Array<Texture>();
	private Array<Texture> textureAnimationsPlayerDown = new Array<Texture>();
	private Array<Texture> textureAnimationsPlayerLeft = new Array<Texture>();
	private Array<Texture> textureAnimationsPlayerRight = new Array<Texture>();
	
	private Array<Texture> textureAnimationsMonsterUp = new Array<Texture>();
	private Array<Texture> textureAnimationsMonsterDown = new Array<Texture>();
	private Array<Texture> textureAnimationsMonsterLeft = new Array<Texture>();
	private Array<Texture> textureAnimationsMonsterRight = new Array<Texture>();
	
	public GameScreen(final NightHunt game) {
		this.game = game;

		fullHeartTexture = new Texture("img/heart_full.png");
		emptyHeartTexture = new Texture("img/heart_empty.png");
		
		textureAnimationsPlayerUp.add(new Texture("img/player_up_walk1.png"));
		textureAnimationsPlayerUp.add(new Texture("img/player_up_walk2.png"));
		textureAnimationsPlayerDown.add(new Texture("img/player_down_walk1.png"));
		textureAnimationsPlayerDown.add(new Texture("img/player_down_walk2.png"));
		textureAnimationsPlayerLeft.add(new Texture("img/player_left_walk1.png"));
		textureAnimationsPlayerLeft.add(new Texture("img/player_left_walk2.png"));
		textureAnimationsPlayerRight.add(new Texture("img/player_right_walk1.png"));
		textureAnimationsPlayerRight.add(new Texture("img/player_right_walk2.png"));
		
		animationsPlayer = new AnimationSet(
							new Animation<Texture>(0.3f/2f, textureAnimationsPlayerUp, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/2f, textureAnimationsPlayerDown, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/2f, textureAnimationsPlayerLeft, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/2f, textureAnimationsPlayerRight, PlayMode.LOOP_PINGPONG),
							new Texture("img/player_up.png"),
							new Texture("img/player_down.png"),
							new Texture("img/player_left.png"),
							new Texture("img/player_right.png")
						);
		
//		textureAnimationsMonsterUp.add(new Texture(""));
//		textureAnimationsMonsterUp.add(new Texture(""));
		
		
		groundTextureMap.put(Ground.GRASS, new Texture("img/grass.png"));
		groundTextureMap.put(Ground.ROCK, new Texture("img/rock1.png"));
		groundTextureMap.put(Ground.WATER, new Texture("img/water.png"));
		groundTextureMap.put(Ground.TREE, new Texture("img/tree1.png"));
		
		orbTextureMap.put(OrbType.ICE, new Texture("img/orb_blue.png"));
		orbTextureMap.put(OrbType.ATTACK, new Texture("img/orb_orange.png"));
		orbTextureMap.put(OrbType.LIFE, new Texture("img/orb_red.png"));

		monsterTextureMap.put(MonsterType.MONSTER1, new Texture("img/monster1_left.png"));
		monsterTextureMap.put(MonsterType.MONSTER2, new Texture("img/monster2_left.png"));
		monsterTextureMap.put(MonsterType.MONSTER3, new Texture("img/monster3_left.png"));
		monsterTextureMap.put(MonsterType.MONSTER4, new Texture("img/monster4_left.png"));
		
		map = new TileMap(Settings.GROUNDMAP1, Settings.GROUNDMAP1[0].length, Settings.GROUNDMAP1[0].length);
		player = new Player(new Coordinates(30, 20), map, animationsPlayer);
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
		

		for (Monster monster : map.getMonsterList()) {
			game.batch.draw(monsterTextureMap.get(monster.getMonsterType()),
				   	  mapStartAbs + monster.getCoord().getAbs() * Settings.TILE_SIZE,
				   	  mapStartOrd + monster.getCoord().getOrd() * Settings.TILE_SIZE,
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
		
		for (int nbLostLifePoint = player.getLifePoint(); nbLostLifePoint < Settings.MAX_LIFEPOINTS; nbLostLifePoint++) {
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
		for(Texture texture : textureAnimationsPlayerDown) texture.dispose();
		for(Texture texture : textureAnimationsPlayerUp) texture.dispose();
		for(Texture texture : textureAnimationsPlayerRight) texture.dispose();
		for(Texture texture : textureAnimationsPlayerLeft) texture.dispose();
		
	}

}