package com.mygdx.gamejam.model;

import com.mygdx.gamejam.GameScreen;

public class Chest extends GameObject {
	
	private boolean isOpen = false;
	
	public Chest(Coordinates coord, TileMap map) {
		super(coord, map);
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
		GameScreen.chestSound.play();
	}
}
