package com.mygdx.gamejam.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.mygdx.gamejam.GameScreen;
import com.mygdx.gamejam.Settings;

public class Player extends GameObject {
	private int lifePoint = Settings.MAX_LIFEPOINTS;
	private int nbFireball = 0;
	
	private boolean hasFirstKey = false;
	private boolean hasSecondKey = false;

	private PlayerState state = PlayerState.STANDING;
	private CoordinatesFloat currentCoord;
	private Coordinates srcCoord;
	private Tile destination = null;
	private Direction currentDir;
	private AnimationSetPlayer animations;

	private float animWalkingTimer = 0;
	private static float ANIM_WALKING_TIME = 0.25f;
	
	private float walkTimer;
	private float standingInvincibleTimer = 0f;
	private boolean moveRequestThisFrame;
	private boolean isInvincible = false;
	
	public Player(Coordinates coord, TileMap map, AnimationSetPlayer animations) {
		super(coord, map);
		this.currentCoord = new CoordinatesFloat(coord.getAbs(), coord.getOrd());
		this.currentDir = Direction.DOWN;
		this.animations = animations; 
	}
		
	public void setState(PlayerState state) {
		this.state = state;
	}

	public int getLifePoint() {
		return lifePoint;
	}

	public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;
	}

	public boolean isInvincible() {
		return isInvincible;
	}

	public void setInvincible(boolean isInvicible) {
		this.isInvincible = isInvicible;
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
		srcCoord = new Coordinates(this.getCoord().getAbs(), this.getCoord().getOrd());
		
		if (destination != null && (destination.isWalkable() || destination.getGroundType() == Ground.WATER)) {
			if (state == PlayerState.MOONWALKING) {
				animWalkingTimer = 0f;

				this.getMap().getTile(this.getCoord()).setPlayer(null);
				destination.setPlayer(this);

				this.getCoord().move(dir.getDeltaAbs(), dir.getDeltaOrd());
			} else {
				animWalkingTimer = 0f;
				state = PlayerState.WALKING;
				
				this.getMap().getTile(this.getCoord()).setPlayer(null);
				destination.setPlayer(this);
				
				this.getCoord().move(dir.getDeltaAbs(), dir.getDeltaOrd());
			}
		}
	}

	public void update(float delta) {
		if (state == PlayerState.STANDING) standingInvincibleTimer += delta;
		
		if (state == PlayerState.WALKING || state == PlayerState.MOONWALKING) {
			standingInvincibleTimer = 0f;
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
				} else if (this.destination.getGroundType() == Ground.WATER) {
					this.destination.interact(this);
					GameScreen.ploofSound.play(); 
				} else if (moveRequestThisFrame) {
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

	public PlayerState getState() {
		return state;
	}

	public void setCurrentCoord(CoordinatesFloat currentCoord) {
		this.currentCoord = currentCoord;
	}

	public Texture getSprite() {
		if (this.isInvincible()) {
			if (this.state == PlayerState.WALKING) {
				return animations.getWalkingInvincible(this.currentDir).getKeyFrame(walkTimer);
			} else if (this.state == PlayerState.MOONWALKING) {
				return animations.getMoonwalkingInvincible(this.currentDir).getKeyFrame(walkTimer);
			} else if (this.state == PlayerState.STANDING) {
				return animations.getStandingInvincible(this.currentDir).getKeyFrame(standingInvincibleTimer);
			}
			return animations.getStandingInvincible(Direction.DOWN).getKeyFrame(standingInvincibleTimer);
		}
		
		if (this.state == PlayerState.WALKING) {
			return animations.getWalking(this.currentDir).getKeyFrame(walkTimer);
		} else if (this.state == PlayerState.MOONWALKING) {
			return animations.getMoonwalking(this.currentDir).getKeyFrame(walkTimer);
		} else if (this.state == PlayerState.STANDING) {
			return animations.getStanding(this.currentDir);
		}
		return animations.getStanding(Direction.DOWN);
	}
	
	/**
	 * Throw a fireball
	 */
	public void attack() {
		if (nbFireball > 0) {
			nbFireball--;
			Fireball fireball = new Fireball(this.getCoord().clone(), this.getMap(), this.currentDir, false);
			this.getMap().getFireballList().add(fireball);
			fireball.move();
		}		
	}
	
	public int getNbFireball() {
		return nbFireball;
	}
	
	public void incrNbFireball() {
		nbFireball++;
	}
	
	public void loseLifePoint() {
		this.lifePoint -= 1;
	}
	
	public void winLifePoint() {
		this.lifePoint += 1;
	}

	public boolean hasFirstKey() {
		return hasFirstKey;
	}

	public void setHasFirstKey(boolean hasKey) {
		this.hasFirstKey = hasKey;
	}
	
	public boolean hasSecondKey() {
		return hasSecondKey;
	}

	public void setHasSecondKey(boolean hasSecondKey) {
		this.hasSecondKey = hasSecondKey;
	}


	public Direction getCurrentDir() {
		return currentDir;
	}
}
