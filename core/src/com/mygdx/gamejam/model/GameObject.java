package com.mygdx.gamejam.model;

public abstract class GameObject {
	private Coordinates coord;
	private TileMap map;
	public GameObject(Coordinates coord, TileMap map) {
		this.coord = coord;
		this.map = map;
	}
	
	public Coordinates getCoord() {
		return coord;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	public TileMap getMap() {
		return map;
	}

	public void setMap(TileMap map) {
		this.map = map;
	}
	
	public void interact(Player player) {
		// Nothing, defined in the sub classes
	}
}
