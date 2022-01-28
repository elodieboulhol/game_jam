package com.mygdx.gamejam.model;

public abstract class GameObject {
	private Coordinates coord;

	public Coordinates getCoord() {
		return coord;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	public GameObject(Coordinates coord) {
		this.coord = coord;
	}
	
}
