package com.mygdx.gamejam.model;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.gamejam.Settings;

public class TileMap {
	private Tile[][] map;
	private int width;
	private int height;
	private ArrayList<Orb> orbsList;
	private ArrayList<Fireball> fireballList = new ArrayList<Fireball>();
	private Key key1;
	private Key key2;
	private Chest chest;
	private Task myIceTask = null;
	private Task myInvicibilityTask = null;
	private Task mySlowerTask = null;
	private ArrayList<Monster> monsterList;
	
	private SelectedLevel selectedLevel;

	public TileMap(Ground[][] groundMap, int width, int height, SelectedLevel selectedLevel) {
		super();
		this.map = new Tile[height][width];
		this.width = width;
		this.height = height;
		this.selectedLevel = selectedLevel;
		
		for (int ord = 0; ord < height; ord++) {
			for (int abs = 0; abs < width; abs++) {
				this.map[ord][abs] = new Tile(new Coordinates(abs, ord), groundMap[height - 1 - ord][abs]);
			}
		}

		if (selectedLevel != SelectedLevel.INTRO) {
			Coordinates key1Coord = new Coordinates(Settings.KEY1_ABS_MAP.get(this.selectedLevel),
													Settings.KEY1_ORD_MAP.get(this.selectedLevel));
			this.key1 = new Key(key1Coord, this);
			this.getTile(key1Coord).setGameObject(this.key1);
			
			Coordinates key2Coord = new Coordinates(Settings.KEY2_ABS_MAP.get(this.selectedLevel),
													Settings.KEY2_ORD_MAP.get(this.selectedLevel));
			this.key2 = new Key(key2Coord, this);
			this.getTile(key2Coord).setGameObject(this.key2);
			
			Coordinates chestCoord = new Coordinates(Settings.CHEST_ABS_MAP.get(this.selectedLevel),
													 Settings.CHEST_ORD_MAP.get(this.selectedLevel));
			
			this.chest = new Chest(chestCoord, this);
			this.getTile(chestCoord).setGameObject(this.chest);
		}
		
		this.monsterList = new ArrayList<Monster>();
//		this.genStaticMonsters();
		for (int nbMonster = 0; nbMonster < Settings.NB_MONSTER_MAP.get(this.selectedLevel); nbMonster++) {
			this.genNewMonster();
		}
		
		this.orbsList = new ArrayList<Orb>();
		for (int nbOrb = 0; nbOrb < Settings.NB_ORB_MAP.get(this.selectedLevel); nbOrb++) {
			this.genNewOrb();
		}
	}
	
	public void genNewOrb() {
		Coordinates playerStartingCoord = new Coordinates(Settings.PLAYER_ABS_MAP.get(selectedLevel),
				  										  Settings.PLAYER_ORD_MAP.get(selectedLevel));
		
		// Pick random tile
		Coordinates coordOrb = Coordinates.randomCoordinates(this.width, this.height);
		Tile tileOrb = this.getTile(coordOrb);
		
		while (!tileOrb.isWalkable() || !tileOrb.isEmpty() || tileOrb.getGroundType() == Ground.ICE || 
				coordOrb.equals(playerStartingCoord) || getTile(coordOrb).getGameObject() != null || getTile(coordOrb).getPlayer() != null) {
			
			coordOrb = Coordinates.randomCoordinates(this.width, this.height);
			tileOrb = this.getTile(coordOrb);
		}

		// Pick random type
		OrbType orbType = OrbType.values()[new Random().nextInt(OrbType.values().length)];
		Orb newOrb = new Orb(coordOrb, this, orbType);
		this.orbsList.add(newOrb);
		tileOrb.setGameObject(newOrb);

	}
	
	public void genStaticMonsters() {		
		Coordinates coord1 = new Coordinates(Settings.MONSTER1_ABS_MAP, Settings.MONSTER1_ORD_MAP);
		this.genMonster(coord1);
		Coordinates coord2 = new Coordinates(Settings.MONSTER2_ABS_MAP, Settings.MONSTER2_ORD_MAP);
		this.genMonster(coord2);
		Coordinates coord3 = new Coordinates(Settings.MONSTER3_ABS_MAP, Settings.MONSTER3_ORD_MAP);
		this.genMonster(coord3);
		Coordinates coord4 = new Coordinates(Settings.MONSTER4_ABS_MAP, Settings.MONSTER4_ORD_MAP);
		this.genMonster(coord4);
		Coordinates coord5 = new Coordinates(Settings.MONSTER5_ABS_MAP, Settings.MONSTER5_ORD_MAP);
		this.genMonster(coord5);
		Coordinates coord6 = new Coordinates(Settings.MONSTER6_ABS_MAP, Settings.MONSTER6_ORD_MAP);
		this.genMonster(coord6);
	}

	public void genMonster(Coordinates coordMonster) {
		// Pick random monster
		MonsterType monsterType = MonsterType.values()[new Random().nextInt(Settings.NB_NORMAL_MONSTER)];

		// Get tile
		Tile tileMonster = this.getTile(coordMonster);
		Monster monster = new Monster(coordMonster, this, monsterType, MonsterState.LIVING);

		// Put monster on tile
		this.monsterList.add(monster);
		tileMonster.setGameObject(monster);
	}

	public void genNewMonster() {
		Coordinates playerStartingCoord = new Coordinates(Settings.PLAYER_ABS_MAP.get(selectedLevel),
				  										  Settings.PLAYER_ORD_MAP.get(selectedLevel));
		
		// Pick random monster
		MonsterType monsterType = MonsterType.values()[new Random().nextInt(Settings.NB_NORMAL_MONSTER)];
		
		// Pick random tile
		Coordinates coordMonster = Coordinates.randomCoordinates(this.width, this.height);
		Tile tileMonster = this.getTile(coordMonster);
		
		while (!tileMonster.isWalkable() || !tileMonster.isEmpty() || coordMonster.equals(playerStartingCoord)) {
			coordMonster = Coordinates.randomCoordinates(this.width, this.height);
			tileMonster = this.getTile(coordMonster);
		}
		
		// Put monster on tile
		Monster monster = new Monster(coordMonster, this, monsterType, MonsterState.LIVING);
		this.monsterList.add(monster);
		tileMonster.setGameObject(monster);
	}
	
	public ArrayList<Orb> getOrbsList() {
		return orbsList;
	}	

	public ArrayList<Monster> getMonsterList() {
		return monsterList;
	}

	public void setMonsterList(ArrayList<Monster> monsterList) {
		this.monsterList = monsterList;
	}

	public Tile[][] getMap() {
		return map;
	}

	public Tile getTile(Coordinates coord) {
		return map[coord.getOrd()][coord.getAbs()];
	}
	
	public Tile getTile(int abs, int ord) {
		if (abs >= this.width || abs < 0 || ord >= this.height || ord < 0) {
			return null;
		}
		return map[ord][abs];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Task getMyIceTask() {
		return myIceTask;
	}

	public void setMyIceTask(Task myIceTask) {
		this.myIceTask = myIceTask;
	}

	public Task getMyInvicibilityTask() {
		return myInvicibilityTask;
	}

	public void setMyInvicibilityTask(Task myInvicibilityTask) {
		this.myInvicibilityTask = myInvicibilityTask;
	}

	public Task getMySlowerTask() {
		return mySlowerTask;
	}

	public void setMySlowerTask(Task mySlowerTask) {
		this.mySlowerTask = mySlowerTask;
	}

	public ArrayList<Fireball> getFireballList() {
		return fireballList;
	}

	public Key getKey1() {
		return key1;
	}

	public void setKey1(Key key) {
		this.key1 = key;
	}

	public Key getKey2() {
		return key2;
	}

	public void setKey2(Key key2) {
		this.key2 = key2;
	}

	public Chest getChest() {
		return chest;
	}

}
