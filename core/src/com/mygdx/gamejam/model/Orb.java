package com.mygdx.gamejam.model;

import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.gamejam.GameScreen;
import com.mygdx.gamejam.Settings;

public class Orb extends GameObject {
	private OrbType orbType;

	public Orb(Coordinates coord, TileMap map, OrbType orbType) {
		super(coord, map);
		this.orbType = orbType;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Orb))
			return false;
		Orb other = (Orb) obj;
		if (orbType != other.orbType || (!this.getCoord().equals(other.getCoord())))
			return false;
		return true;
	}

	public OrbType getOrbType() {
		return orbType;
	}

	public void setOrbType(OrbType orbType) {
		this.orbType = orbType;
	}
	
	@Override
	public void interact(Player player) {
		
		if (this.orbType == OrbType.ATTACK) {
			GameScreen.orbSound.play();
			if (player.getNbFireball() < Settings.MAX_NBFIREBALLS) player.incrNbFireball();
		} else if (this.orbType == OrbType.ICE) {
			GameScreen.freezingSound.play();

			for (int width = 0; width < getMap().getWidth(); width++) {
				for (int height = 0; height < getMap().getHeight(); height++) {
					if (getMap().getTile(new Coordinates(width, height)).getGroundType() == Ground.WATER) {
						getMap().getTile(new Coordinates(width, height)).setGroundType(Ground.ICE);
					}
				}
			}
			
			if (this.getMap().getMyTask() != null) this.getMap().getMyTask().cancel();
			Task task = new MyTask(player){
			    @Override
			    public void run() {
					for (int width = 0; width < getMap().getWidth(); width++) {
						for (int height = 0; height < getMap().getHeight(); height++) {
							if (getMap().getTile(new Coordinates(width, height)).getGroundType() == Ground.ICE) {
								getMap().getTile(new Coordinates(width, height)).setGroundType(Ground.WATER);
							}
						}
					}
					// If ice breaks and player is on water : he lose all of his lives
					if (getMap().getTile(this.param.getCoord()).getGroundType() == Ground.WATER) {
						this.param.setLifePoint(0);
						GameScreen.ploofSound.play();
					}
			    }
			};
			this.getMap().setMyTask(task);
			Timer.schedule(this.getMap().getMyTask(), Settings.ICE_TIMING);
		} else if (this.orbType == OrbType.LIFE) {
			GameScreen.orbSound.play();
			if (player.getLifePoint() < Settings.MAX_LIFEPOINTS) player.winLifePoint();
		}
		this.getMap().getOrbsList().remove(this);
		this.getMap().getTile(this.getCoord()).setGameObject(null);
		player.getMap().genNewOrb();
	}
}
