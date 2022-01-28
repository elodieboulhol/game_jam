package com.mygdx.gamejam.model;

public class CoordinatesFloat {
	private float abs;
	private float ord;
	
	public CoordinatesFloat(float abs, float ord) {
		super();
		this.abs = abs;
		this.ord = ord;
	}
	
	public float getAbs() {
		return abs;
	}
	
	public void setAbs(float abs) {
		this.abs = abs;
	}
	
	public float getOrd() {
		return ord;
	}
	
	public void setOrd(float ord) {
		this.ord = ord;
	}
	
	public void move(float deltaAbs, float deltaOrd) {
		this.abs += deltaAbs;
		this.ord += deltaOrd;
	}
}
