package com.mygdx.gamejam.model;

public abstract class GameObject {
	private Coordinates coord;
	private TileMap map;

	public Coordinates getCoord() {
		return coord;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	public GameObject(Coordinates coord, TileMap map) {
		this.coord = coord;
		this.map = map;
	}
	
}
