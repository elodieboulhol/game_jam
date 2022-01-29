package com.mygdx.gamejam.controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.mygdx.gamejam.model.Direction;
import com.mygdx.gamejam.model.Player;

public class PlayerController extends InputAdapter {
	private Player player;
	private boolean up, down, left, right, attack;
	
	public PlayerController(Player player) {
		this.player = player;
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
			attack = true;
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
		} else if (keycode == Keys.SPACE) {
			attack = false;
		}
		return false;
	}
	
	
	public void update(float delta) {
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
		} else if (attack) {
			player.attack();
		}
	}
}
