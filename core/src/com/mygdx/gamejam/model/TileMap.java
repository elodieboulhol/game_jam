package com.mygdx.gamejam.model;

import java.util.ArrayList;
import java.util.Random;

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

	private static int NB_ORB = 8;
	private ArrayList<Monster> monsterList;

	public TileMap(Ground[][] groundMap, int width, int height) {
		super();
		this.map = new Tile[height][width];
		this.width = width;
		this.height = height;
		for (int ord = 0; ord < height; ord++) {
			for (int abs = 0; abs < width; abs++) {
				map[ord][abs] = new Tile(new Coordinates(abs, ord), groundMap[height - 1 - ord][abs]);
			}
		}
		
		Coordinates key1Coord = new Coordinates(Settings.KEY1_ABS_MAP, Settings.KEY1_ORD_MAP);
		this.key1 = new Key(key1Coord, this);
		this.getTile(key1Coord).setGameObject(this.key1);
		
		Coordinates key2Coord = new Coordinates(Settings.KEY2_ABS_MAP, Settings.KEY2_ORD_MAP);
		this.key2 = new Key(key2Coord, this);
		this.getTile(key2Coord).setGameObject(this.key2);
		
		Coordinates chestCoord = new Coordinates(Settings.CHEST_ABS, Settings.CHEST_ORD);
		this.chest = new Chest(chestCoord, this);
		this.getTile(chestCoord).setGameObject(this.chest);
		
		this.orbsList = new ArrayList<Orb>();
		for (int nbOrb = 0; nbOrb < NB_ORB; nbOrb++) {
			this.genNewOrb();
		}
		
		this.monsterList = new ArrayList<Monster>();
		for (int nbMonster = 0; nbMonster < Settings.NB_MONSTER; nbMonster++) {
			this.genNewMonster();
		}
	}
	
	public void genNewOrb() {
		// Pick random tile
		Coordinates coordOrb = Coordinates.randomCoordinates(this.width, this.height);
		Tile tileOrb = this.getTile(coordOrb);
		while (!tileOrb.isWalkable() || !tileOrb.isEmpty() || tileOrb.getGroundType() == Ground.ICE) {
			coordOrb = Coordinates.randomCoordinates(this.width, this.height);
			tileOrb = this.getTile(coordOrb);
		}

		// Pick random type
		OrbType orbType = OrbType.values()[new Random().nextInt(OrbType.values().length)];
		Orb newOrb = new Orb(coordOrb, this, orbType);
		this.orbsList.add(newOrb);
		tileOrb.setGameObject(newOrb);

	}
	
	public void genNewMonster() {
		// Pick random monster
		MonsterType monsterType = MonsterType.values()[new Random().nextInt(Settings.NB_NORMAL_MONSTER)];
		
		// Pick random tile
		Coordinates coordMonster = Coordinates.randomCoordinates(this.width, this.height);
		Tile tileMonster = this.getTile(coordMonster);
		while (!tileMonster.isWalkable() || !tileMonster.isEmpty()) {
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
