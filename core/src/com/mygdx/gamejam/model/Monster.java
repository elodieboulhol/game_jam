package com.mygdx.gamejam.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Monster extends GameObject {
	private MonsterType monsterType;
	private MonsterState monsterState;
	
	private static Sound hitSound = Gdx.audio.newSound(Gdx.files.internal("sound/punch.mp3"));;

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
//		this.setMonsterState(MonsterState.RED);
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
		hitSound.play();
	}
}
