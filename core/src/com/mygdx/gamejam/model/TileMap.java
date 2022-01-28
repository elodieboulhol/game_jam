package com.mygdx.gamejam.model;

import java.util.ArrayList;
import java.util.Random;

public class TileMap {
	private Tile[][] map;
	private int width;
	private int height;
	private ArrayList<Orb> orbsList;
	private static int NB_ORB = 8;

	public TileMap(Ground[][] groundMap, int width, int height) {
		super();
		this.map = new Tile[width][height];
		this.width = width;
		this.height = height;
		for (int abs = 0; abs < width; abs++) {
			for (int ord = 0; ord < height; ord++) {
				map[abs][ord] = new Tile(new Coordinates(abs, ord), groundMap[abs][ord]);
			}
		}
		
		
		this.orbsList = new ArrayList<Orb>();
		for (int nbOrb = 0; nbOrb < NB_ORB; nbOrb++) {
			this.genNewOrb();
		}
	}
	
	public void genNewOrb() {
		// Pick random tile
		Coordinates coordOrb = Coordinates.randomCoordinates(this.width, this.height);
		Tile tileOrb = this.getTile(coordOrb);
		while (!tileOrb.isWalkable() || !tileOrb.isEmpty()) {
			coordOrb = Coordinates.randomCoordinates(this.width, this.height);
			tileOrb = this.getTile(coordOrb);
		}

		// Pick random type
		OrbType orbType = OrbType.values()[new Random().nextInt(OrbType.values().length)];
		Orb newOrb = new Orb(coordOrb, this, orbType);
		this.orbsList.add(newOrb);
		tileOrb.setGameObject(newOrb);

	}
	
	public ArrayList<Orb> getOrbsList() {
		return orbsList;
	}

	public Tile[][] getMap() {
		return map;
	}

	public Tile getTile(Coordinates coord) {
		return map[coord.getAbs()][coord.getOrd()];
	}
	
	public Tile getTile(int abs, int ord) {
		if (abs >= this.width || abs < 0 || ord >= this.height || ord < 0) {
			return null;
		}
		return map[abs][ord];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
