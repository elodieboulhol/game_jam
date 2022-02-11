package com.mygdx.gamejam.model;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

public class AnimationSetPlayer {
	private Map<Direction, Animation<Texture>> walking;
	private Map<Direction, Animation<Texture>> moonwalking;
	private Map<Direction, Texture> standing;

	private Map<Direction, Animation<Texture>> walkingInvincible;
	private Map<Direction, Animation<Texture>> moonwalkingInvincible;
	private Map<Direction, Animation<Texture>> standingInvincible;
	
	public AnimationSetPlayer(Animation<Texture> walkUp,
					Animation<Texture> walkDown,
					Animation<Texture> walkLeft,
					Animation<Texture> walkRight,
					Animation<Texture> moonwalkUp,
					Animation<Texture> moonwalkDown,
					Animation<Texture> moonwalkLeft,
					Animation<Texture> moonwalkRight,
					Texture standUp,
					Texture standDown,
					Texture standLeft,
					Texture standRight,
					
					Animation<Texture> walkUpInvincible,
					Animation<Texture> walkDownInvincible,
					Animation<Texture> walkLeftInvincible,
					Animation<Texture> walkRightInvincible,
					Animation<Texture> moonwalkUpInvincible,
					Animation<Texture> moonwalkDownInvincible,
					Animation<Texture> moonwalkLeftInvincible,
					Animation<Texture> moonwalkRightInvincible,
					Animation<Texture> standUpInvincible,
					Animation<Texture> standDownInvincible,
					Animation<Texture> standLeftInvincible,
					Animation<Texture> standRightInvincible) {

		this.walking = new HashMap<Direction, Animation<Texture>>();
		this.walking.put(Direction.UP, walkUp);
		this.walking.put(Direction.DOWN, walkDown);
		this.walking.put(Direction.LEFT, walkLeft);
		this.walking.put(Direction.RIGHT, walkRight);

		this.moonwalking = new HashMap<Direction, Animation<Texture>>();
		this.moonwalking.put(Direction.UP, moonwalkUp);
		this.moonwalking.put(Direction.DOWN, moonwalkDown);
		this.moonwalking.put(Direction.LEFT, moonwalkLeft);
		this.moonwalking.put(Direction.RIGHT, moonwalkRight);
		
		this.standing = new HashMap<Direction, Texture>();
		this.standing.put(Direction.UP, standUp);
		this.standing.put(Direction.DOWN, standDown);
		this.standing.put(Direction.LEFT, standLeft);
		this.standing.put(Direction.RIGHT, standRight);
		
		
		this.walkingInvincible = new HashMap<Direction, Animation<Texture>>();
		this.walkingInvincible.put(Direction.UP, walkUpInvincible);
		this.walkingInvincible.put(Direction.DOWN, walkDownInvincible);
		this.walkingInvincible.put(Direction.LEFT, walkLeftInvincible);
		this.walkingInvincible.put(Direction.RIGHT, walkRightInvincible);

		this.moonwalkingInvincible = new HashMap<Direction, Animation<Texture>>();
		this.moonwalkingInvincible.put(Direction.UP, moonwalkUpInvincible);
		this.moonwalkingInvincible.put(Direction.DOWN, moonwalkDownInvincible);
		this.moonwalkingInvincible.put(Direction.LEFT, moonwalkLeftInvincible);
		this.moonwalkingInvincible.put(Direction.RIGHT, moonwalkRightInvincible);
		
		this.standingInvincible = new HashMap<Direction, Animation<Texture>>();
		this.standingInvincible.put(Direction.UP, standUpInvincible);
		this.standingInvincible.put(Direction.DOWN, standDownInvincible);
		this.standingInvincible.put(Direction.LEFT, standLeftInvincible);
		this.standingInvincible.put(Direction.RIGHT, standRightInvincible);
	}

	public Animation<Texture> getWalking(Direction dir) {
		return this.walking.get(dir);
	}
	
	public Animation<Texture> getMoonwalking(Direction dir) {
		return this.moonwalking.get(dir);
	}
	
	public Texture getStanding(Direction dir) {
		return this.standing.get(dir);
	}
	
	
	public Animation<Texture> getWalkingInvincible(Direction dir) {
		return this.walkingInvincible.get(dir);
	}
	
	public Animation<Texture> getMoonwalkingInvincible(Direction dir) {
		return this.moonwalkingInvincible.get(dir);
	}
	
	public Animation<Texture> getStandingInvincible(Direction dir) {
		return this.standingInvincible.get(dir);
	}
}
