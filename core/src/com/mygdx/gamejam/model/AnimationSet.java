package com.mygdx.gamejam.model;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

public class AnimationSet {
	private Map<Direction, Animation<Texture>> walking;
	private Map<Direction, Texture> standing;
	
	public AnimationSet(Animation<Texture> walkUp,
					Animation<Texture> walkDown,
					Animation<Texture> walkLeft,
					Animation<Texture> walkRight,
					Texture standUp,
					Texture standDown,
					Texture standLeft,
					Texture standRight) {
		this.walking = new HashMap<Direction, Animation<Texture>>();
		this.walking.put(Direction.UP, walkUp);
		this.walking.put(Direction.DOWN, walkDown);
		this.walking.put(Direction.LEFT, walkLeft);
		this.walking.put(Direction.RIGHT, walkRight);
		
		this.standing = new HashMap<Direction, Texture>();
		this.standing.put(Direction.UP, standUp);
		this.standing.put(Direction.DOWN, standDown);
		this.standing.put(Direction.LEFT, standLeft);
		this.standing.put(Direction.RIGHT, standRight);
	}

	public Animation<Texture> getWalking(Direction dir) {
		return this.walking.get(dir);
	}
	
	public Texture getStanding(Direction dir) {
		return this.standing.get(dir);
	}
}
