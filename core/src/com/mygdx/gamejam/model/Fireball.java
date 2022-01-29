package com.mygdx.gamejam.model;

import com.badlogic.gdx.math.Interpolation;

public class Fireball extends GameObject {

	private Direction currentDir;
	private CoordinatesFloat currentCoord;
	private Coordinates srcCoord;
	private Tile destination = null;

	private float animThrowingTimer = 0;
	private static float ANIM_THROWING_TIME = 0.25f;
	
	public Fireball(Coordinates coord, TileMap map, Direction currentDir) {
		super(coord, map);
		this.currentDir = currentDir;
		this.currentCoord = new CoordinatesFloat(coord.getAbs(), coord.getOrd());
	}

	/**
	 * Move the fireball on the map.
	 */
	public void move() {
		destination = this.getMap().getTile(this.getCoord().getAbs() + this.currentDir.getDeltaAbs(), this.getCoord().getOrd() + this.currentDir.getDeltaOrd());
		srcCoord = new Coordinates(this.getCoord().getAbs(),
	   			   				   this.getCoord().getOrd());
		
		if (destination != null && destination.isWalkable()) {
			animThrowingTimer = 0f;
			
			this.getCoord().move(this.currentDir.getDeltaAbs(), this.currentDir.getDeltaOrd());
		}
	}
	
	/**
	 * Update the position of the fireball
	 * @param delta
	 * @return true if the fireball hits an obstacle, false otherwise
	 */
	public boolean update(float delta) {
		if (destination != null) {
			animThrowingTimer += delta;
			
			currentCoord.setAbs(Interpolation.linear.apply(
				srcCoord.getAbs(),
				destination.getCoord().getAbs(),
				animThrowingTimer / ANIM_THROWING_TIME));
			
			currentCoord.setOrd(Interpolation.linear.apply(
				srcCoord.getOrd(),
				destination.getCoord().getOrd(),
				animThrowingTimer / ANIM_THROWING_TIME));
			
			// End move
			if (animThrowingTimer > ANIM_THROWING_TIME) {
				
				if (destination.isWalkable() && destination.isEmpty()) {
					this.move();
					return false;
				} else {
					this.currentCoord.setAbs(destination.getCoord().getAbs());
					this.currentCoord.setOrd(destination.getCoord().getOrd());
					
					if (this.destination.getGameObject() != null) {
						this.destination.getGameObject().interact(this);
					}

					return true;
				}
			}
		}
		return false;
	}

	public Direction getCurrentDir() {
		return currentDir;
	}
}
