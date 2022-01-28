package com.mygdx.gamejam.model;

public class Coordinates {
	private int abs;
	private int ord;
	
	public Coordinates(int abs, int ord) {
		this.abs = abs;
		this.ord = ord;
	}
	
	public int getAbs() {
		return abs;
	}

	public void setAbs(int abs) {
		this.abs = abs;
	}

	public int getOrd() {
		return ord;
	}

	public void setOrd(int ord) {
		this.ord = ord;
	}

	public void move(int absMove, int ordMove) {
		this.abs += absMove;
		this.ord += ordMove;
	}
}
