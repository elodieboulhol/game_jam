package com.mygdx.gamejam.model;

import java.util.ArrayList;
import java.util.HashMap;

public class TileMap {
	private Tile[][] map;
	private int width;
	private int height;
	private ArrayList<Orb> orbs;

	public TileMap(Tile[][] map, int width, int height) {
		super();
		this.map = map;
		this.width = width;
		this.height = height;
		this.orbs = new ArrayList<Orb>();
	}
}
