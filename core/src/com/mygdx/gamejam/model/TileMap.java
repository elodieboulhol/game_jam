package com.mygdx.gamejam.model;

import java.util.ArrayList;
import java.util.HashMap;

public class TileMap {
	private Tile[][] map;
	private int width;
	private int height;
	private ArrayList<Orb> orbs;

	public TileMap(Ground[][] groundMap, int width, int height) {
		super();
		this.map = new Tile[width][height];
		this.width = width;
		this.height = height;
		this.orbs = new ArrayList<Orb>();
		for (int abs = 0; abs < width; abs++) {
			for (int ord = 0; ord < height; ord++) {
				map[abs][ord] = new Tile(new Coordinates(abs, ord), groundMap[abs][ord]);
			}
		}
	}
	
	public Tile getTile(int abs, int ord) {
		return map[abs][ord];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
