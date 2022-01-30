package com.mygdx.gamejam.model;

public class Tile {
	private Coordinates coord;
	private Ground groundType;
	private GameObject gameObject = null;
	private Player player = null;

	public GameObject getGameObject() {
		return gameObject;
	}

	public void setGameObject(GameObject gameObject) {
		this.gameObject = gameObject;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Tile(Coordinates coord, Ground groundType) {
		super();
		this.coord = coord;
		this.groundType = groundType;
	}

	public Coordinates getCoord() {
		return coord;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	public Ground getGroundType() {
		return groundType;
	}

	public void setGroundType(Ground groundType) {
		this.groundType = groundType;
	}
	
	public boolean isWalkable() {
		if (this.gameObject != null && this.gameObject instanceof Chest) {
			return false;
		}
		return (this.groundType == Ground.GRASS || this.groundType == Ground.PLANK || this.groundType == Ground.ICE);
	}
	
	public void interact(Player player) {
		player.setState(PlayerState.MOONWALKING);
		
		switch (player.getCurrentDir()) {
		case LEFT:
			player.move(Direction.RIGHT);
			break;
		case RIGHT:
			player.move(Direction.LEFT);
			break;
		case UP:
			player.move(Direction.DOWN);
			break;
		case DOWN:
			player.move(Direction.UP);
			break;
		}

		player.loseLifePoint();
	}
	
	public boolean isEmpty() {
		return (this.gameObject == null || this.gameObject instanceof Orb);
	}
}
