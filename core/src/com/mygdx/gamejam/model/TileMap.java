package com.mygdx.gamejam.model;

public class TileMap {
	private Tile[][] map;
	private int width;
	private int height;

	public TileMap(Tile[][] map, int width, int height) {
		super();
		this.map = map;
		this.width = width;
		this.height = height;
	}
}
