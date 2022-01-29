package com.mygdx.gamejam.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;

public class Monster extends GameObject {
	private MonsterType monsterType;
	private MonsterState monsterState;

	private static float ANIM_TIME = 1.5f;
	private float animTimer = 0;
	private float monsterTimer;
	

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
		if (this.monsterType == MonsterType.MONSTER1_NORMAL) this.monsterType = MonsterType.MONSTER1_RED;
		if (this.monsterType == MonsterType.MONSTER2_NORMAL) this.monsterType = MonsterType.MONSTER2_RED;
		if (this.monsterType == MonsterType.MONSTER3_NORMAL) this.monsterType = MonsterType.MONSTER3_RED;
		if (this.monsterType == MonsterType.MONSTER4_NORMAL) this.monsterType = MonsterType.MONSTER4_RED;
		
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
	
	public void update(float delta) {
		if (this.monsterState == MonsterState.RED) {
			animTimer += delta;
			monsterTimer += delta;
			
			if (animTimer > ANIM_TIME) {
				monsterTimer = 0f;
				this.setMonsterState(MonsterState.LIVING);
				if (this.monsterType == MonsterType.MONSTER1_RED) this.monsterType = MonsterType.MONSTER1_NORMAL;
				if (this.monsterType == MonsterType.MONSTER2_RED) this.monsterType = MonsterType.MONSTER2_NORMAL;
				if (this.monsterType == MonsterType.MONSTER3_RED) this.monsterType = MonsterType.MONSTER3_NORMAL;
				if (this.monsterType == MonsterType.MONSTER4_RED) this.monsterType = MonsterType.MONSTER4_NORMAL;
			}
		}
	}

	public Texture getSprite(AnimationSetMonster animations) {
		if (this.monsterState == MonsterState.RED) {
			return animations.getRedTexture(this.monsterType).getKeyFrame(this.monsterTimer);
		} else {
			return animations.getNormalTexture(this.monsterType);
		}
	}
}
