package com.mygdx.gamejam.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Chest extends GameObject {
	
	private boolean isOpen = false;
	
	private static Sound chestSound = Gdx.audio.newSound(Gdx.files.internal("sound/chest_effect.mp3"));
	
	public Chest(Coordinates coord, TileMap map) {
		super(coord, map);
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
		chestSound.play();
	}
}
