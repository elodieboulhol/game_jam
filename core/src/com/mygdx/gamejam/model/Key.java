package com.mygdx.gamejam.model;

import com.mygdx.gamejam.GameScreen;

public class Key extends GameObject {

	public Key(Coordinates coord, TileMap map) {
		super(coord, map);
	}
	
	@Override
	public void interact(Player player) {
		GameScreen.keyCollectSound.play();
		Key key1 = getMap().getKey1();
		Key key2 = getMap().getKey2();
		if (key1 !=  null && player.getCoord().equals(key1.getCoord())) {			
			getMap().getTile(key1.getCoord()).setGameObject(null);
			getMap().setKey1(null);
			player.setHasFirstKey(true);
		} else {
			getMap().getTile(key2.getCoord()).setGameObject(null);
			getMap().setKey2(null);
			player.setHasSecondKey(true);
		}
	}
}
