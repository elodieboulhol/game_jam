package com.mygdx.gamejam.model;

import java.util.Random;

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

	public void move(int deltaAbs, int deltaOrd) {
		this.abs += deltaAbs;
		this.ord += deltaOrd;
	}
	
	public static Coordinates randomCoordinates(int width, int height) {
		int absOrb = new Random().nextInt(width);
		int ordOrb = new Random().nextInt(height);
		return new Coordinates(absOrb, ordOrb);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Coordinates))
			return false;
		Coordinates other = (Coordinates) obj;
		if (abs != other.abs || ord != other.ord)
			return false;
		return true;
	}
	
	
	@Override
	public Coordinates clone() {
		return new Coordinates(this.abs, this.ord);
	}
}
