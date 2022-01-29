package com.mygdx.gamejam.model;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

public class AnimationSetMonster {
	private Map<MonsterType, Animation<Texture>> red;
	private Map<MonsterType, Texture> normal;
	
	public AnimationSetMonster(Animation<Texture> animation_monster1_left,
					Animation<Texture> animation_monster2_left,
					Animation<Texture> animation_monster3_left,
					Animation<Texture> animation_monster4_left,
					Texture monster1_left,
					Texture monster2_left,
					Texture monster3_left,
					Texture monster4_left) {
		this.red = new HashMap<MonsterType, Animation<Texture>>();
		this.red.put(MonsterType.MONSTER1_RED, animation_monster1_left);
		this.red.put(MonsterType.MONSTER2_RED, animation_monster2_left);
		this.red.put(MonsterType.MONSTER3_RED, animation_monster3_left);
		this.red.put(MonsterType.MONSTER4_RED, animation_monster4_left);

		this.normal= new HashMap<MonsterType, Texture>();
		this.normal.put(MonsterType.MONSTER1_NORMAL, monster1_left);
		this.normal.put(MonsterType.MONSTER2_NORMAL, monster2_left);
		this.normal.put(MonsterType.MONSTER3_NORMAL, monster3_left);
		this.normal.put(MonsterType.MONSTER4_NORMAL, monster4_left);
	}

	public Animation<Texture> getRedTexture(MonsterType monsterType) {
		return this.red.get(monsterType);
	}

	public Texture getNormalTexture(MonsterType monsterType) {
		return this.normal.get(monsterType);
	}
}
