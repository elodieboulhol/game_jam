package com.mygdx.gamejam.model;

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
			// TODO
		} else if (this.orbType == OrbType.ICE) {
			// TODO
		} else if (this.orbType == OrbType.LIFE) {
			// TODO
		}
		this.getMap().getOrbsList().remove(this);
		this.getMap().getTile(this.getCoord()).setGameObject(null);
		player.getMap().genNewOrb();
	}

}
