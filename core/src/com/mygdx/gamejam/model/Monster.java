package com.mygdx.gamejam.model;

public class Monster extends GameObject {
	private MonsterType monsterType;
	private MonsterState monsterState;

	public Monster(Coordinates coord, TileMap map, MonsterType monsterType, MonsterState monsterState) {
		super(coord, map);
		this.monsterType = monsterType;
		this.monsterState = monsterState;
	}

	public MonsterType getMonsterType() {
		return monsterType;
	}

	public MonsterState getMonsterState() {
		return monsterState;
	}

	public void setMonsterState(MonsterState monsterState) {
		this.monsterState = monsterState;
	}
	
	public void interact(Player player) {
		this.setMonsterState(MonsterState.RED);
		player.move(Direction.LEFT);
		player.loseLifePoint();
	}
}
