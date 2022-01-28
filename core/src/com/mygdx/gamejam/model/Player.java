package com.mygdx.gamejam.model;

import com.mygdx.gamejam.Settings;

public class Player extends GameObject {
	private int lifePoint;
	
	public Player(Coordinates coord) {
		super(coord);
		this.lifePoint = Settings.LIFEPOINTS;
	}
	
	public int getLifePoint() {
		return lifePoint;
	}

	public void move(int deltaAbs, int deltaOrd) {
		this.getCoord().move(deltaAbs, deltaOrd);
	}

	public void loseLifePoint() {
		this.lifePoint -= 1;
	}
	
	public void winLifePoint() {
		this.lifePoint += 1;
	}
}
