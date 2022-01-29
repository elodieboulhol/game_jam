package com.mygdx.gamejam.model;

public class Key extends GameObject {

	public Key(Coordinates coord, TileMap map) {
		super(coord, map);
	}
	
	@Override
	public void interact(Player player) {
		this.getMap().setKey(null);
		player.setHasKey(true);
	}
}
