package com.mygdx.gamejam.controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.mygdx.gamejam.model.Player;

public class PlayerController extends InputAdapter {
	private Player player;
	
	public PlayerController(Player player) {
		this.player = player;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.UP) {
			player.move(0, 1);
		} else if (keycode == Keys.DOWN) {
			player.move(0, -1);
		} else if (keycode == Keys.LEFT) {
			player.move(-1, 0);
		} else if (keycode == Keys.RIGHT) {
			player.move(1, 0);
		}
		return false;
	}
}
