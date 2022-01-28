package com.mygdx.gamejam.model;

public enum Direction {
	UP(0,1),
	DOWN(0,-1),
	LEFT(-1,0),
	RIGHT(1,0);
	
	private int deltaAbs, deltaOrd;
 
	private Direction(int deltaAbs, int deltaOrd) {
		this.deltaAbs = deltaAbs;
		this.deltaOrd = deltaOrd;
	}

	public int getDeltaAbs() {
		return deltaAbs;
	}

	public int getDeltaOrd() {
		return deltaOrd;
	}	
}
