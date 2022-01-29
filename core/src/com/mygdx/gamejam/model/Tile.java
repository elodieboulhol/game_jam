package com.mygdx.gamejam.model;

public class Tile {
	private Coordinates coord;
	private Ground groundType;
	private GameObject gameObject = null;

	public GameObject getGameObject() {
		return gameObject;
	}

	public void setGameObject(GameObject gameObject) {
		this.gameObject = gameObject;
	}

	public Tile(Coordinates coord, Ground groundType) {
		super();
		this.coord = coord;
		this.groundType = groundType;
	}

	public Coordinates getCoord() {
		return coord;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	public Ground getGroundType() {
		return groundType;
	}

	public void setGroundType(Ground groundType) {
		this.groundType = groundType;
	}
	
	public boolean isWalkable() {
		if (this.gameObject != null && this.gameObject instanceof Chest) {
			return false;
		}
		return (this.groundType == Ground.GRASS || this.groundType == Ground.BRIDGE);
	}
	
	public boolean isEmpty() {
		return this.gameObject == null;
	}
}
