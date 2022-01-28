package com.mygdx.gamejam.model;

import com.badlogic.gdx.math.Interpolation;
import com.mygdx.gamejam.Settings;

public class Player extends GameObject {
	private int lifePoint = Settings.LIFEPOINTS;
	
	private PlayerState state = PlayerState.STANDING;
	private CoordinatesFloat currentCoord;
	private Coordinates srcCoord;
	private float animWalkingTimer = 0;
	private static float ANIM_WALKING_TIME = 0.25f;
	private Tile destination = null;
	
	public Player(Coordinates coord, TileMap map) {
		super(coord, map);
		currentCoord = new CoordinatesFloat(coord.getAbs(), coord.getOrd());
	}
	
	public int getLifePoint() {
		return lifePoint;
	}

	public void move(int deltaAbs, int deltaOrd) {
		if (state != PlayerState.STANDING) return;
		
		destination = this.getMap().getTile(this.getCoord().getAbs() + deltaAbs, this.getCoord().getOrd() + deltaOrd);
		if (destination != null && destination.isWalkable()) {
			
			srcCoord = new Coordinates(this.getCoord().getAbs(),
									   this.getCoord().getOrd());
			animWalkingTimer = 0f;
			state = PlayerState.WALKING;
			
			this.getCoord().move(deltaAbs, deltaOrd);
		}
	}
	
	public void update(float delta) {
		if (state == PlayerState.WALKING) {
			animWalkingTimer += delta;
			
			currentCoord.setAbs(Interpolation.pow2.apply(
				srcCoord.getAbs(),
				destination.getCoord().getAbs(),
				animWalkingTimer / ANIM_WALKING_TIME));
			
			currentCoord.setOrd(Interpolation.pow2.apply(
				srcCoord.getOrd(),
				destination.getCoord().getOrd(),
				animWalkingTimer / ANIM_WALKING_TIME));
			
			if (animWalkingTimer > ANIM_WALKING_TIME) {
				state = PlayerState.STANDING;
				this.currentCoord.setAbs(destination.getCoord().getAbs());
				this.currentCoord.setOrd(destination.getCoord().getOrd());
				this.srcCoord = null;
				this.destination = null;
			}
		}
	}

	public CoordinatesFloat getCurrentCoord() {
		return currentCoord;
	}

	public void setCurrentCoord(CoordinatesFloat currentCoord) {
		this.currentCoord = currentCoord;
	}

	public void loseLifePoint() {
		this.lifePoint -= 1;
	}
	
	public void winLifePoint() {
		this.lifePoint += 1;
	}
}
