package com.mygdx.gamejam;

import java.util.HashMap;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.gamejam.controller.PlayerController;
import com.mygdx.gamejam.model.AnimationSetMonster;
import com.mygdx.gamejam.model.AnimationSetPlayer;
import com.mygdx.gamejam.model.Camera;
import com.mygdx.gamejam.model.Coordinates;
import com.mygdx.gamejam.model.Direction;
import com.mygdx.gamejam.model.Fireball;
import com.mygdx.gamejam.model.Ground;
import com.mygdx.gamejam.model.Monster;
import com.mygdx.gamejam.model.Orb;
import com.mygdx.gamejam.model.OrbType;
import com.mygdx.gamejam.model.Player;
import com.mygdx.gamejam.model.SelectedLevel;
import com.mygdx.gamejam.model.TileMap;

public class GameScreen implements Screen {
	private final NightHunt game;
	
	private boolean isDay = true;
	
	private Texture fullHeartTexture;
	private Texture emptyHeartTexture;
	private Texture keyTexture;
	private Texture closedChestTexture;
	private Texture openedChestTexture;
	private Texture shieldTexture;

	private AnimationSetPlayer animationsPlayer;
	private AnimationSetMonster animationsMonster;
	private HashMap<Integer, Texture> fireballCounterTextureMap = new HashMap<Integer, Texture>();
	private HashMap<Ground, Texture> dayGroundTextureMap = new HashMap<Ground, Texture>();
	private HashMap<Ground, Texture> nightGroundTextureMap = new HashMap<Ground, Texture>();
	private HashMap<OrbType, Texture> orbTextureMap = new HashMap<OrbType, Texture>();
	private HashMap<Direction, Texture> fireballTextureMap = new HashMap<Direction, Texture>();
	private PlayerController playerController;
	private Player player;
	private TileMap map;
	private Camera camera;
	
	
	private Array<Texture> dialogTextures = new Array<Texture>();
	
	private Array<Texture> textureAnimationsPlayerUp = new Array<Texture>();
	private Array<Texture> textureAnimationsPlayerDown = new Array<Texture>();
	private Array<Texture> textureAnimationsPlayerLeft = new Array<Texture>();
	private Array<Texture> textureAnimationsPlayerRight = new Array<Texture>();

	private Array<Texture> textureAnimationsPlayerMoonWalkUp = new Array<Texture>();
	private Array<Texture> textureAnimationsPlayerMoonWalkDown = new Array<Texture>();
	private Array<Texture> textureAnimationsPlayerMoonWalkLeft = new Array<Texture>();
	private Array<Texture> textureAnimationsPlayerMoonWalkRight = new Array<Texture>();
	
	private Array<Texture> textureAnimationsPlayerUpInvincible = new Array<Texture>();
	private Array<Texture> textureAnimationsPlayerDownInvincible = new Array<Texture>();
	private Array<Texture> textureAnimationsPlayerLeftInvincible = new Array<Texture>();
	private Array<Texture> textureAnimationsPlayerRightInvincible = new Array<Texture>();

	private Array<Texture> textureAnimationsPlayerMoonWalkUpInvincible = new Array<Texture>();
	private Array<Texture> textureAnimationsPlayerMoonWalkDownInvincible = new Array<Texture>();
	private Array<Texture> textureAnimationsPlayerMoonWalkLeftInvincible = new Array<Texture>();
	private Array<Texture> textureAnimationsPlayerMoonWalkRightInvincible = new Array<Texture>();
	
	private Array<Texture> textureAnimationsPlayerStandingUpInvincible = new Array<Texture>();
	private Array<Texture> textureAnimationsPlayerStandingDownInvincible = new Array<Texture>();
	private Array<Texture> textureAnimationsPlayerStandingLeftInvincible = new Array<Texture>();
	private Array<Texture> textureAnimationsPlayerStandingRightInvincible = new Array<Texture>();
	
	private Array<Texture> textureAnimationsMonster1Left = new Array<Texture>();
	private Array<Texture> textureAnimationsMonster2Left = new Array<Texture>();
	private Array<Texture> textureAnimationsMonster3Left = new Array<Texture>();
	private Array<Texture> textureAnimationsMonster4Left = new Array<Texture>();
	
	private static Music gameMusic = Gdx.audio.newMusic(Gdx.files.internal("sound/background_music.mp3"));
	static {
		gameMusic.setLooping(true);
	}
	
	public static Sound fireballSound;
	public static Sound chestOpenSound;
	public static Sound chestClosedSound;
	public static Sound orbSound = Gdx.audio.newSound(Gdx.files.internal("sound/orb.mp3"));
	public static Sound freezingSound = Gdx.audio.newSound(Gdx.files.internal("sound/freeze.mp3"));
	public static Sound ploofSound = Gdx.audio.newSound(Gdx.files.internal("sound/ploof.mp3"));
	public static Sound boomSound = Gdx.audio.newSound(Gdx.files.internal("sound/boom.mp3"));
	public static Sound keyCollectSound = Gdx.audio.newSound(Gdx.files.internal("sound/key_collect.mp3"));
	
	private Task switchDayTask;
	private float delayGameOver = -1f;
	private boolean isDeadInWater = false;
	private boolean hasJustWon = true;
	private float delayWin = -1f;
	
	private SelectedLevel selectedLevel;
	
	public GameScreen(final NightHunt game, SelectedLevel selectedLevel) {
		this.game = game;
		this.selectedLevel = selectedLevel;
		
		fireballSound = Gdx.audio.newSound(Gdx.files.internal("sound/fireball.wav"));
		chestOpenSound = Gdx.audio.newSound(Gdx.files.internal("sound/chest_effect.mp3"));
		chestClosedSound = Gdx.audio.newSound(Gdx.files.internal("sound/chest_locked.mp3"));
		
		switchDayTask = new Task(){
		    @Override
		    public void run() {
		        if (isDay) {
		        	isDay = false;
		    		for (Monster monster : map.getMonsterList()) {
		    			monster.sendFireballs();
		    		}
		        }
		        else {
		        	isDay = true;
		    		for (Monster monster : map.getMonsterList()) {
		    			monster.stopSendFireballs();
		    		}
		        }
		    }
		};
		Timer.schedule(switchDayTask, Settings.DAY_LENGTH, Settings.DAY_LENGTH);

		fullHeartTexture = new Texture("img/heart_full.png");
		emptyHeartTexture = new Texture("img/heart_empty.png");
		keyTexture = new Texture("img/key.png");
		closedChestTexture = new Texture("img/chest.png");
		openedChestTexture = new Texture("img/chest_coins.png");
		shieldTexture = new Texture("img/shield.png");
		
		textureAnimationsPlayerUp.add(new Texture("img/player_up_walk1.png"));
		textureAnimationsPlayerUp.add(new Texture("img/player_up_walk2.png"));
		textureAnimationsPlayerDown.add(new Texture("img/player_down_walk1.png"));
		textureAnimationsPlayerDown.add(new Texture("img/player_down_walk2.png"));
		textureAnimationsPlayerLeft.add(new Texture("img/player_left_walk1.png"));
		textureAnimationsPlayerLeft.add(new Texture("img/player_left_walk2.png"));
		textureAnimationsPlayerRight.add(new Texture("img/player_right_walk1.png"));
		textureAnimationsPlayerRight.add(new Texture("img/player_right_walk2.png"));
		
		textureAnimationsPlayerMoonWalkUp.add(new Texture("img/player_down_walk2.png"));
		textureAnimationsPlayerMoonWalkUp.add(new Texture("img/player_down_walk1.png"));
		textureAnimationsPlayerMoonWalkDown.add(new Texture("img/player_up_walk2.png"));
		textureAnimationsPlayerMoonWalkDown.add(new Texture("img/player_up_walk1.png"));
		textureAnimationsPlayerMoonWalkLeft.add(new Texture("img/player_right_walk2.png"));
		textureAnimationsPlayerMoonWalkLeft.add(new Texture("img/player_right_walk1.png"));
		textureAnimationsPlayerMoonWalkRight.add(new Texture("img/player_left_walk2.png"));
		textureAnimationsPlayerMoonWalkRight.add(new Texture("img/player_left_walk1.png"));
		
		textureAnimationsPlayerUpInvincible.add(new Texture("img/player_up_walk1_invincible.png"));
		textureAnimationsPlayerUpInvincible.add(new Texture("img/player_up_walk1.png"));
		textureAnimationsPlayerUpInvincible.add(new Texture("img/player_up_walk2_invincible.png"));
		textureAnimationsPlayerUpInvincible.add(new Texture("img/player_up_walk2.png"));
		textureAnimationsPlayerDownInvincible.add(new Texture("img/player_down_walk1_invincible.png"));
		textureAnimationsPlayerDownInvincible.add(new Texture("img/player_down_walk1.png"));
		textureAnimationsPlayerDownInvincible.add(new Texture("img/player_down_walk2_invincible.png"));
		textureAnimationsPlayerDownInvincible.add(new Texture("img/player_down_walk2.png"));
		textureAnimationsPlayerLeftInvincible.add(new Texture("img/player_left_walk1_invincible.png"));
		textureAnimationsPlayerLeftInvincible.add(new Texture("img/player_left_walk1.png"));
		textureAnimationsPlayerLeftInvincible.add(new Texture("img/player_left_walk2_invincible.png"));
		textureAnimationsPlayerLeftInvincible.add(new Texture("img/player_left_walk2.png"));
		textureAnimationsPlayerRightInvincible.add(new Texture("img/player_right_walk1_invincible.png"));
		textureAnimationsPlayerRightInvincible.add(new Texture("img/player_right_walk1.png"));
		textureAnimationsPlayerRightInvincible.add(new Texture("img/player_right_walk2_invincible.png"));
		textureAnimationsPlayerRightInvincible.add(new Texture("img/player_right_walk2.png"));
		
		textureAnimationsPlayerMoonWalkUpInvincible.add(new Texture("img/player_down_walk2_invincible.png"));
		textureAnimationsPlayerMoonWalkUpInvincible.add(new Texture("img/player_down_walk1_invincible.png"));
		textureAnimationsPlayerMoonWalkDownInvincible.add(new Texture("img/player_up_walk2_invincible.png"));
		textureAnimationsPlayerMoonWalkDownInvincible.add(new Texture("img/player_up_walk1_invincible.png"));
		textureAnimationsPlayerMoonWalkLeftInvincible.add(new Texture("img/player_right_walk2_invincible.png"));
		textureAnimationsPlayerMoonWalkLeftInvincible.add(new Texture("img/player_right_walk1_invincible.png"));
		textureAnimationsPlayerMoonWalkRightInvincible.add(new Texture("img/player_left_walk2_invincible.png"));
		textureAnimationsPlayerMoonWalkRightInvincible.add(new Texture("img/player_left_walk1_invincible.png"));
		
		textureAnimationsPlayerStandingUpInvincible.add(new Texture("img/player_up_invincible.png"));		
		textureAnimationsPlayerStandingUpInvincible.add(new Texture("img/player_up.png"));
		textureAnimationsPlayerStandingDownInvincible.add(new Texture("img/player_down_invincible.png"));		
		textureAnimationsPlayerStandingDownInvincible.add(new Texture("img/player_down.png"));
		textureAnimationsPlayerStandingLeftInvincible.add(new Texture("img/player_left_invincible.png"));		
		textureAnimationsPlayerStandingLeftInvincible.add(new Texture("img/player_left.png"));
		textureAnimationsPlayerStandingRightInvincible.add(new Texture("img/player_right_invincible.png"));		
		textureAnimationsPlayerStandingRightInvincible.add(new Texture("img/player_right.png"));
		
		animationsPlayer = new AnimationSetPlayer(
							new Animation<Texture>(0.3f/2f, textureAnimationsPlayerUp, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/2f, textureAnimationsPlayerDown, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/2f, textureAnimationsPlayerLeft, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/2f, textureAnimationsPlayerRight, PlayMode.LOOP_PINGPONG),						
							new Animation<Texture>(0.3f/2f, textureAnimationsPlayerMoonWalkUp, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/2f, textureAnimationsPlayerMoonWalkDown, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/2f, textureAnimationsPlayerMoonWalkLeft, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/2f, textureAnimationsPlayerMoonWalkRight, PlayMode.LOOP_PINGPONG),
							new Texture("img/player_up.png"),
							new Texture("img/player_down.png"),
							new Texture("img/player_left.png"),
							new Texture("img/player_right.png"),

							new Animation<Texture>(0.3f/4f, textureAnimationsPlayerUpInvincible, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/4f, textureAnimationsPlayerDownInvincible, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/4f, textureAnimationsPlayerLeftInvincible, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/4f, textureAnimationsPlayerRightInvincible, PlayMode.LOOP_PINGPONG),						
							new Animation<Texture>(0.3f/4f, textureAnimationsPlayerMoonWalkUpInvincible, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/4f, textureAnimationsPlayerMoonWalkDownInvincible, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/4f, textureAnimationsPlayerMoonWalkLeftInvincible, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/4f, textureAnimationsPlayerMoonWalkRightInvincible, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/4f, textureAnimationsPlayerStandingUpInvincible, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/4f, textureAnimationsPlayerStandingDownInvincible, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/4f, textureAnimationsPlayerStandingLeftInvincible, PlayMode.LOOP_PINGPONG),
							new Animation<Texture>(0.3f/4f, textureAnimationsPlayerStandingRightInvincible, PlayMode.LOOP_PINGPONG)
						);
		
		
		textureAnimationsMonster1Left.add(new Texture("img/monster1_left_red.png"));
		textureAnimationsMonster1Left.add(new Texture("img/monster1_left.png"));
		
		textureAnimationsMonster2Left.add(new Texture("img/monster2_left_red.png"));
		textureAnimationsMonster2Left.add(new Texture("img/monster2_left.png"));
		
		textureAnimationsMonster3Left.add(new Texture("img/monster3_left_red.png"));
		textureAnimationsMonster3Left.add(new Texture("img/monster3_left.png"));
		
		textureAnimationsMonster4Left.add(new Texture("img/monster4_left_red.png"));
		textureAnimationsMonster4Left.add(new Texture("img/monster4_left.png"));
		
		animationsMonster = new AnimationSetMonster(
				new Animation<Texture>(0.3f/2f, textureAnimationsMonster1Left, PlayMode.LOOP_PINGPONG),
				new Animation<Texture>(0.3f/2f, textureAnimationsMonster2Left, PlayMode.LOOP_PINGPONG),
				new Animation<Texture>(0.3f/2f, textureAnimationsMonster3Left, PlayMode.LOOP_PINGPONG),
				new Animation<Texture>(0.3f/2f, textureAnimationsMonster4Left, PlayMode.LOOP_PINGPONG),
				new Texture("img/monster1_left.png"),
				new Texture("img/monster2_left.png"),
				new Texture("img/monster3_left.png"),
				new Texture("img/monster4_left.png")
				);
		

		if (selectedLevel == SelectedLevel.INTRO) {
			dayGroundTextureMap.put(Ground.FLOOR, new Texture("img/floor.png"));
			dayGroundTextureMap.put(Ground.WALL, new Texture("img/wall.png"));
			dayGroundTextureMap.put(Ground.BED_T, new Texture("img/bed_top.png"));
			dayGroundTextureMap.put(Ground.BED_B, new Texture("img/bed_bottom.png"));
			dayGroundTextureMap.put(Ground.BRICK, new Texture("img/brick_wall.png"));
			dayGroundTextureMap.put(Ground.DRESR, new Texture("img/dresser.png"));
			dayGroundTextureMap.put(Ground.FURN1, new Texture("img/furniture1.png"));
			dayGroundTextureMap.put(Ground.FURN2, new Texture("img/furniture2.png"));
			dayGroundTextureMap.put(Ground.FURN3, new Texture("img/furniture3.png"));
			dayGroundTextureMap.put(Ground.FURN4, new Texture("img/furniture4.png"));
			dayGroundTextureMap.put(Ground.FURN5, new Texture("img/furniture5.png"));
			dayGroundTextureMap.put(Ground.FURN6, new Texture("img/furniture6.png"));
			dayGroundTextureMap.put(Ground.PAINT, new Texture("img/paint.png"));
			dayGroundTextureMap.put(Ground.TAB_L, new Texture("img/table_left.png"));
			dayGroundTextureMap.put(Ground.TAB_R, new Texture("img/table_right.png"));
			dayGroundTextureMap.put(Ground.GRDMA, new Texture("img/old_lady.png"));
			
			nightGroundTextureMap.put(Ground.FLOOR, new Texture("img/floor.png"));
			nightGroundTextureMap.put(Ground.WALL, new Texture("img/wall.png"));
			nightGroundTextureMap.put(Ground.BED_T, new Texture("img/bed_top.png"));
			nightGroundTextureMap.put(Ground.BED_B, new Texture("img/bed_bottom.png"));
			nightGroundTextureMap.put(Ground.BRICK, new Texture("img/brick_wall.png"));
			nightGroundTextureMap.put(Ground.DRESR, new Texture("img/dresser.png"));
			nightGroundTextureMap.put(Ground.FURN1, new Texture("img/furniture1.png"));
			nightGroundTextureMap.put(Ground.FURN2, new Texture("img/furniture2.png"));
			nightGroundTextureMap.put(Ground.FURN3, new Texture("img/furniture3.png"));
			nightGroundTextureMap.put(Ground.FURN4, new Texture("img/furniture4.png"));
			nightGroundTextureMap.put(Ground.FURN5, new Texture("img/furniture5.png"));
			nightGroundTextureMap.put(Ground.FURN6, new Texture("img/furniture6.png"));
			nightGroundTextureMap.put(Ground.PAINT, new Texture("img/paint.png"));
			nightGroundTextureMap.put(Ground.TAB_L, new Texture("img/table_left.png"));
			nightGroundTextureMap.put(Ground.TAB_R, new Texture("img/table_right.png"));
			nightGroundTextureMap.put(Ground.GRDMA, new Texture("img/old_lady.png"));
			
			for (int i = 1; i <= 12; i++) {
				dialogTextures.add(new Texture("dialogue/dialogue_" + i + ".png"));
			}
			
		} else {
			dayGroundTextureMap.put(Ground.GRASS, new Texture("img/grass.png"));
			dayGroundTextureMap.put(Ground.ROCK, new Texture("img/rock1.png"));
			dayGroundTextureMap.put(Ground.WATER, new Texture("img/water.png"));
			dayGroundTextureMap.put(Ground.TREE, new Texture("img/tree1.png"));
			dayGroundTextureMap.put(Ground.ICE, new Texture("img/iceberg.png"));
			dayGroundTextureMap.put(Ground.PLANK, new Texture("img/plank.png"));			

			nightGroundTextureMap.put(Ground.GRASS, new Texture("img/grass_night.png"));
			nightGroundTextureMap.put(Ground.ROCK, new Texture("img/rock_night.png"));
			nightGroundTextureMap.put(Ground.WATER, new Texture("img/water_night.png"));
			nightGroundTextureMap.put(Ground.TREE, new Texture("img/tree_night.png"));
			nightGroundTextureMap.put(Ground.ICE, new Texture("img/iceberg_night.png"));
			nightGroundTextureMap.put(Ground.PLANK, new Texture("img/plank_night.png"));
			
			orbTextureMap.put(OrbType.ICE, new Texture("img/orb_blue.png"));
			orbTextureMap.put(OrbType.ATTACK, new Texture("img/fireball.png"));
			orbTextureMap.put(OrbType.LIFE, new Texture("img/orb_red.png"));
			orbTextureMap.put(OrbType.INVINCIBILITY, new Texture("img/orb_green.png"));
			orbTextureMap.put(OrbType.SLOWER, new Texture("img/orb_purple.png"));
			
			fireballTextureMap.put(Direction.DOWN, new Texture("img/fireball_down.png"));
			fireballTextureMap.put(Direction.UP, new Texture("img/fireball_up.png"));
			fireballTextureMap.put(Direction.LEFT, new Texture("img/fireball_left.png"));
			fireballTextureMap.put(Direction.RIGHT, new Texture("img/fireball_right.png"));
			
			fireballCounterTextureMap.put(new Integer(0), new Texture("img/fireball_counter_0.png"));
			fireballCounterTextureMap.put(new Integer(1), new Texture("img/fireball_counter_1.png"));
			fireballCounterTextureMap.put(new Integer(2), new Texture("img/fireball_counter_2.png"));
			fireballCounterTextureMap.put(new Integer(3), new Texture("img/fireball_counter_3.png"));
		}
		
		
		Ground[][] groundMap = Settings.GROUNDMAPS.get(this.selectedLevel);
 		map = new TileMap(groundMap,
 						  groundMap[0].length,
 						  groundMap.length,
 						  this.selectedLevel);
		
 		Coordinates playerCoord = new Coordinates(Settings.PLAYER_ABS_MAP.get(selectedLevel),
 												  Settings.PLAYER_ORD_MAP.get(selectedLevel));
		player = new Player(playerCoord, map, animationsPlayer);
		playerController = new PlayerController(player);
		camera = new Camera();
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(playerController);
		gameMusic.play();
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
				Texture groundTexture;
				if (isDay) groundTexture = dayGroundTextureMap.get(map.getTile(abs, ord).getGroundType());
				else groundTexture = nightGroundTextureMap.get(map.getTile(abs, ord).getGroundType());
				game.batch.draw(groundTexture,
							    mapStartAbs + abs * Settings.TILE_SIZE,
							    mapStartOrd + ord * Settings.TILE_SIZE,
							    Settings.TILE_SIZE,
							    Settings.TILE_SIZE);
			}
		}
		
		if (this.selectedLevel == SelectedLevel.INTRO) {
			drawIntro(delta);
			return;
		}

		for (Orb orb : map.getOrbsList()) { 		      
	           game.batch.draw(orbTextureMap.get(orb.getOrbType()),
					   	  mapStartAbs + orb.getCoord().getAbs() * Settings.TILE_SIZE,
					   	  mapStartOrd + orb.getCoord().getOrd() * Settings.TILE_SIZE,
					   	  Settings.TILE_SIZE,
					   	  Settings.TILE_SIZE); 		
	    }	

		for (Monster monster : map.getMonsterList()) {
			monster.update(delta);
			game.batch.draw(monster.getSprite(animationsMonster),
				   	  mapStartAbs + monster.getCoord().getAbs() * Settings.TILE_SIZE,
				   	  mapStartOrd + monster.getCoord().getOrd() * Settings.TILE_SIZE,
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
		
		if (map.getChest().isOpen()) {
			game.batch.draw(openedChestTexture, 
					mapStartAbs + map.getChest().getCoord().getAbs() * Settings.TILE_SIZE,
					mapStartOrd + map.getChest().getCoord().getOrd() * Settings.TILE_SIZE,
					Settings.TILE_SIZE,
					Settings.TILE_SIZE);
		} else {
			game.batch.draw(closedChestTexture, 
					mapStartAbs + map.getChest().getCoord().getAbs() * Settings.TILE_SIZE,
					mapStartOrd + map.getChest().getCoord().getOrd() * Settings.TILE_SIZE,
					Settings.TILE_SIZE,
					Settings.TILE_SIZE);
		}
		
		if (map.getKey1() != null) {
			game.batch.draw(keyTexture, 
							mapStartAbs + map.getKey1().getCoord().getAbs() * Settings.TILE_SIZE,
							mapStartOrd + map.getKey1().getCoord().getOrd() * Settings.TILE_SIZE,
							Settings.TILE_SIZE,
							Settings.TILE_SIZE);
		} else if (player.hasFirstKey()) {
			game.batch.draw(keyTexture, 
							Settings.KEY1_ABS_SCREEN,
							Settings.KEY1_ORD_SCREEN,
							Settings.KEY1_ORD_SCREEN_SIZE,
							Settings.KEY1_ORD_SCREEN_SIZE);
		}
		
		if (map.getKey2() != null) {
			game.batch.draw(keyTexture, 
							mapStartAbs + map.getKey2().getCoord().getAbs() * Settings.TILE_SIZE,
							mapStartOrd + map.getKey2().getCoord().getOrd() * Settings.TILE_SIZE,
							Settings.TILE_SIZE,
							Settings.TILE_SIZE);
		} else if (player.hasSecondKey()) {
			game.batch.draw(keyTexture, 
							Settings.KEY2_ABS_SCREEN,
							Settings.KEY2_ORD_SCREEN,
							Settings.KEY2_ORD_SCREEN_SIZE,
							Settings.KEY2_ORD_SCREEN_SIZE);
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
		
		if (player.isInvincible()) {
			game.batch.draw(shieldTexture, 
							Settings.SHIELDABS,
							Settings.SHIELDORD,
							Settings.SHIELDSIZE,
							Settings.SHIELDSIZE);
			
		}
		
		game.batch.draw(fireballCounterTextureMap.get(new Integer(player.getNbFireball())), 
						Settings.FIREBALL_ABS,
						Settings.FIREBALL_ORD,
						Settings.FIREBALL_SIZE,
						Settings.FIREBALL_SIZE);
		
		game.batch.draw(player.getSprite(),
				   mapStartAbs + player.getCurrentCoord().getAbs() * Settings.TILE_SIZE,
				   mapStartOrd + player.getCurrentCoord().getOrd() * Settings.TILE_SIZE,
				   Settings.TILE_SIZE,
				   Settings.TILE_SIZE);
		
		
		game.batch.end();
		
		if (gameOver()) {
			if (this.map.getTile(player.getCoord()).getGroundType() == Ground.WATER && !isDeadInWater) {
				delayGameOver = 0f;
				isDeadInWater = true;
			}
			
			if (isDeadInWater && delayGameOver < Settings.DELAY_GAMEOVER) {
				delayGameOver += delta;
			} else {				
				switchDayTask.cancel();
				for (Monster monster : map.getMonsterList()) {
					monster.stopSendFireballs();
				}
				
				game.setScreen(new GameOverScreen(game));
			}
		}
		
		if (playerWon()) {
			
			if (hasJustWon) {
				delayWin = 0f;
				hasJustWon = false;
			}
			
			if (delayWin < Settings.DELAY_WINGAME) {
				delayWin += delta;
			} else {				
				switchDayTask.cancel();
				for (Monster monster : map.getMonsterList()) {
					monster.stopSendFireballs();
				}
				
				game.setScreen(new WinScreen(game));
			}
		}
	}
	
	private void drawIntro(float delta) {
		float mapStartAbs = Gdx.graphics.getWidth() / 2 - camera.getCameraAbs() * Settings.TILE_SIZE ;		
		float mapStartOrd = Gdx.graphics.getHeight() / 2 - camera.getCameraOrd() * Settings.TILE_SIZE ;
		
		game.batch.draw(player.getSprite(),
				   mapStartAbs + player.getCurrentCoord().getAbs() * Settings.TILE_SIZE,
				   mapStartOrd + player.getCurrentCoord().getOrd() * Settings.TILE_SIZE,
				   Settings.TILE_SIZE,
				   Settings.TILE_SIZE);
		
		if (player.getIndexDialog() > -1 && player.getIndexDialog() < dialogTextures.size) {
			game.batch.draw(dialogTextures.get(player.getIndexDialog()),
							Settings.SCREEN_WIDTH / 4,
							0,
						    Settings.SCREEN_WIDTH / 2,
						    1080 * Settings.SCREEN_WIDTH / (2 * 1920));
		} else if (player.getIndexDialog() >= dialogTextures.size) {
			if (hasJustWon) {
				delayWin = 0f;
				hasJustWon = false;
			}
			
			if (delayWin < Settings.DELAY_WINGAME) {
				delayWin += delta;
			} else {				
				switchDayTask.cancel();
				game.setScreen(new WinScreen(game));
			}
		}
		game.batch.end();
	}

	public boolean gameOver() {
		return player.getLifePoint() <= 0;
	}
	
	public boolean playerWon() {
		return this.map.getChest().isOpen();
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
		gameMusic.stop();
		
	}

	@Override
	public void dispose() {		
		fullHeartTexture.dispose();
		emptyHeartTexture.dispose();
		for(HashMap.Entry<OrbType, Texture> orb : orbTextureMap.entrySet()) {
		    orb.getValue().dispose();
		}
		for(HashMap.Entry<Ground, Texture> ground : dayGroundTextureMap.entrySet()) {
		    ground.getValue().dispose();
		}
		for(HashMap.Entry<Ground, Texture> ground : nightGroundTextureMap.entrySet()) {
		    ground.getValue().dispose();
		}
		for(HashMap.Entry<Direction, Texture> fireball : fireballTextureMap.entrySet()) {
		    fireball.getValue().dispose();
		}
		for(Texture texture : textureAnimationsPlayerDown) texture.dispose();
		for(Texture texture : textureAnimationsPlayerUp) texture.dispose();
		for(Texture texture : textureAnimationsPlayerRight) texture.dispose();
		for(Texture texture : textureAnimationsPlayerLeft) texture.dispose();
		
		gameMusic.dispose();
		fireballSound.dispose();
		chestOpenSound.dispose();
		chestClosedSound.dispose();
	}

}
