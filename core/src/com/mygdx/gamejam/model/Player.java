package com.mygdx.gamejam.model;

public class Player extends GameObject {

	public Player(Coordinates coord) {
		super(coord);
	}
	
	public void move(int absMove, int ordMove) {
		this.getCoord().move(absMove, ordMove);
	}
}
