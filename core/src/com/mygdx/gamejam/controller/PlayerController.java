package com.mygdx.gamejam.controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.InputAdapter;
import com.mygdx.gamejam.model.Chest;
import com.mygdx.gamejam.model.Direction;
import com.mygdx.gamejam.model.Player;
import com.mygdx.gamejam.model.PlayerState;
import com.mygdx.gamejam.model.Tile;

public class PlayerController extends InputAdapter {
	private Player player;
	private boolean up, down, left, right;
	
	private Sound fireballSound;
	private Sound chestOpenSound;
	private Sound chestClosedSound;
	
	public PlayerController(Player player, Sound fireballSound, Sound chestOpenSound, Sound chestClosedSound) {
		this.player = player;
		this.fireballSound = fireballSound;
		this.chestClosedSound = chestClosedSound;
		this.chestOpenSound = chestOpenSound;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.UP) {
			up = true;
		} else if (keycode == Keys.DOWN) {
			down = true;
		} else if (keycode == Keys.LEFT) {
			left = true;
		} else if (keycode == Keys.RIGHT) {
			right = true;
		} else if (keycode == Keys.SPACE) {
			Tile destination = player.getMap().getTile(player.getCoord().getAbs() + player.getCurrentDir().getDeltaAbs(),
					   								   player.getCoord().getOrd() + player.getCurrentDir().getDeltaOrd());
			if (destination.getGameObject() != null && destination.getGameObject() instanceof Chest) {
				Chest chest = (Chest) destination.getGameObject();
				if (player.hasFirstKey() && player.hasSecondKey()) {
					chest.setOpen(true);
					chestOpenSound.play();
					return false;
				} else {
					chestClosedSound.play();
				}
			} else if (player.getNbFireball() > 0) {
				fireballSound.play();
				player.attack();
			}
		}
		return false;
	}
	
	public boolean keyUp(int keycode) {
		if (keycode == Keys.UP) {
			up = false;
		} else if (keycode == Keys.DOWN) {
			down = false;
		} else if (keycode == Keys.LEFT) {
			left = false;
		} else if (keycode == Keys.RIGHT) {
			right = false;
		}
		return false;
	}
	
	
	public void update(float delta) {
		if (player.getState() == PlayerState.MOONWALKING) return;
		if (up) {
			player.move(Direction.UP);
			return;
		} else if (down) {
			player.move(Direction.DOWN);
			return;
		} else if (left) {
			player.move(Direction.LEFT);
			return;
		} else if (right) {
			player.move(Direction.RIGHT);
			return;
		}
	}
}
