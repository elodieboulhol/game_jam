package com.mygdx.gamejam.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.mygdx.gamejam.Settings;

public class Player extends GameObject {
	private int lifePoint = Settings.MAX_LIFEPOINTS;
	
	private PlayerState state = PlayerState.STANDING;
	private CoordinatesFloat currentCoord;
	private Coordinates srcCoord;
	private Tile destination = null;
	private Direction currentDir;
	private AnimationSet animations;

	private float animWalkingTimer = 0;
	private static float ANIM_WALKING_TIME = 0.25f;

	private float walkTimer;
	private boolean moveRequestThisFrame;
	
	public Player(Coordinates coord, TileMap map, AnimationSet animations) {
		super(coord, map);
		this.currentCoord = new CoordinatesFloat(coord.getAbs(), coord.getOrd());
		this.currentDir = Direction.DOWN;
		this.animations = animations; 
	}
	
	public int getLifePoint() {
		return lifePoint;
	}

	public void move(Direction dir) {
		this.currentDir = dir;
		
		if (state == PlayerState.WALKING) {
			if (currentDir == dir) {
				moveRequestThisFrame = true;
			}
			return;
		}
		
		destination = this.getMap().getTile(this.getCoord().getAbs() + dir.getDeltaAbs(), this.getCoord().getOrd() + dir.getDeltaOrd());
		if (destination != null && destination.isWalkable()) {
			
			srcCoord = new Coordinates(this.getCoord().getAbs(),
									   this.getCoord().getOrd());
			animWalkingTimer = 0f;
			state = PlayerState.WALKING;
			
			this.getCoord().move(dir.getDeltaAbs(), dir.getDeltaOrd());
		}
	}
	
	public void update(float delta) {
		if (state == PlayerState.WALKING) {
			animWalkingTimer += delta;
			walkTimer += delta;
			
			currentCoord.setAbs(Interpolation.pow2.apply(
				srcCoord.getAbs(),
				destination.getCoord().getAbs(),
				animWalkingTimer / ANIM_WALKING_TIME));
			
			currentCoord.setOrd(Interpolation.pow2.apply(
				srcCoord.getOrd(),
				destination.getCoord().getOrd(),
				animWalkingTimer / ANIM_WALKING_TIME));
			
			// End move
			if (animWalkingTimer > ANIM_WALKING_TIME) {
				float leftOverTimer = animWalkingTimer - ANIM_WALKING_TIME;
				walkTimer -= leftOverTimer;
				
				state = PlayerState.STANDING;
				this.currentCoord.setAbs(destination.getCoord().getAbs());
				this.currentCoord.setOrd(destination.getCoord().getOrd());
				
				if (this.destination.getGameObject() != null) {
					this.destination.getGameObject().interact(this);
				}

				this.srcCoord = null;
				this.destination = null;

				if (moveRequestThisFrame) {
					move(this.currentDir);
				} else {
					walkTimer = 0f;
				}
			}
		}
		moveRequestThisFrame = false;
	}

	public CoordinatesFloat getCurrentCoord() {
		return currentCoord;
	}

	public void setCurrentCoord(CoordinatesFloat currentCoord) {
		this.currentCoord = currentCoord;
	}

	public Texture getSprite() {
		if (this.state == PlayerState.WALKING) {
			return animations.getWalking(this.currentDir).getKeyFrame(walkTimer);
		} else if (this.state == PlayerState.STANDING) {
			return animations.getStanding(this.currentDir);
		}
		return animations.getStanding(Direction.DOWN);
	}
	
	public void loseLifePoint() {
		this.lifePoint -= 1;
	}
	
	public void winLifePoint() {
		this.lifePoint += 1;
	}
	
//	public void playerKilledByMonster(Monster monster) {
//		monster.setMonsterState(MonsterState.RED);
//		this.loseLifePoint();
//	}

//	public void playerKillsMonster(Monster monster) {
//		monster.setMonsterState(MonsterState.DEAD);
//		this.getMap().getMonsterList().remove(monster);
//		this.getMap().getTile(this.srcCoord).setGameObject(null);
//	}
}
