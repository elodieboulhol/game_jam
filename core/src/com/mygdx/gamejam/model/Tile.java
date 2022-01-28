package com.mygdx.gamejam.model;

public class Tile {
	private Coordinates coord;
	private Ground groundType;

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
		return (this.groundType == Ground.GRASS || this.groundType == Ground.BRIDGE);
	}
}
