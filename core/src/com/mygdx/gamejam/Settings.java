package com.mygdx.gamejam;

import com.mygdx.gamejam.model.Ground;

public class Settings {
	
	public static int SCREEN_WIDTH = 1200;
	public static int SCREEN_HEIGHT = 720;
	
	public static int TILE_SIZE = 70;
	
	public static int MAX_LIFEPOINTS = 3;
	public static int MAX_NBFIREBALLS = 3;
	
	public static int LIFEABS = 10;
	public static int LIFESIZE = 2 * TILE_SIZE / 3;
	public static int LIFEORD = SCREEN_HEIGHT - (3 * LIFESIZE / 2);
	public static int LIFESPACE = 3;
	
	public static int FIREBALL_SIZE = 3 * TILE_SIZE / 2;
	public static int FIREBALL_ABS = Settings.SCREEN_WIDTH - Settings.LIFEABS - Settings.FIREBALL_SIZE;
	public static int FIREBALL_ORD = SCREEN_HEIGHT - FIREBALL_SIZE;
	
	public static int KEY1_ORD_SCREEN_SIZE = TILE_SIZE;
	public static int KEY1_ABS_SCREEN = FIREBALL_ABS;
	public static int KEY1_ORD_SCREEN = 0;
	
	public static int KEY2_ORD_SCREEN_SIZE = TILE_SIZE;
	public static int KEY2_ABS_SCREEN = FIREBALL_ABS;
	public static int KEY2_ORD_SCREEN = TILE_SIZE / 2;
	
	public static int KEY1_ABS_MAP = 25;
	public static int KEY1_ORD_MAP = 9;
	public static int KEY2_ABS_MAP = 12;
	public static int KEY2_ORD_MAP = 24;

	public static int MONSTER1_ABS_MAP = 12;
	public static int MONSTER1_ORD_MAP = 23;
	public static int MONSTER2_ABS_MAP = 11;
	public static int MONSTER2_ORD_MAP = 24;
	public static int MONSTER3_ABS_MAP = 12;
	public static int MONSTER3_ORD_MAP = 25;
	public static int MONSTER4_ABS_MAP = 13;
	public static int MONSTER4_ORD_MAP = 24;
	public static int MONSTER5_ABS_MAP = 18;
	public static int MONSTER5_ORD_MAP = 22;
	public static int MONSTER6_ABS_MAP = 18;
	public static int MONSTER6_ORD_MAP = 23;
	
	public static int CHEST_ABS= 18;
	public static int CHEST_ORD = 24;
	
	public static int PLAYER_ABS = 11;
	public static int PLAYER_ORD = 7;
	
	public static int NB_MONSTER = 7;
	public static int NB_NORMAL_MONSTER = 4;
	public static int FIREBALL_MONSTER_TIMING = 1;
	public static int FIREBALL_MONSTER_DELAY = 1;

	public static int ICE_TIMING = 5;
	
	public static float DELAY_GAMEOVER = 1f;
	
	public static float DAY_LENGTH = 6f; 
	
	public static Ground[][] GROUNDMAP1= {
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		
		
		
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.ROCK,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE,  Ground.ROCK,  Ground.GRASS, Ground.GRASS, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.ROCK,  Ground.TREE,  Ground.TREE,  Ground.GRASS, Ground.TREE,  Ground.TREE,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE,  Ground.TREE,  Ground.GRASS, Ground.GRASS, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.ROCK,  Ground.ROCK,  Ground.TREE,  Ground.TREE,  Ground.GRASS, Ground.TREE,  Ground.TREE,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.ROCK,  Ground.TREE,  Ground.TREE,  Ground.GRASS, Ground.TREE,  Ground.TREE,  Ground.WATER, Ground.WATER, Ground.PLANK, Ground.WATER, Ground.WATER, Ground.GRASS, Ground.GRASS, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE,  Ground.TREE,  Ground.GRASS, Ground.TREE,  Ground.TREE,  Ground.WATER, Ground.WATER, Ground.PLANK, Ground.PLANK, Ground.PLANK, Ground.GRASS, Ground.GRASS, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE,  Ground.TREE,  Ground.GRASS, Ground.TREE,  Ground.TREE,  Ground.WATER, Ground.WATER, Ground.PLANK, Ground.WATER, Ground.WATER, Ground.GRASS, Ground.GRASS, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.ROCK,  Ground.ROCK,  Ground.WATER, Ground.WATER, Ground.PLANK, Ground.WATER, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE,  Ground.GRASS, Ground.GRASS, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.GRASS, Ground.GRASS, Ground.PLANK, Ground.PLANK, Ground.PLANK, Ground.WATER, Ground.GRASS, Ground.WATER, Ground.WATER, Ground.ROCK,  Ground.WATER, Ground.GRASS, Ground.TREE,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.GRASS, Ground.GRASS, Ground.WATER, Ground.WATER, Ground.WATER, Ground.WATER, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.WATER, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.ROCK,  Ground.ROCK,  Ground.GRASS, Ground.GRASS, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.ROCK,  Ground.ROCK,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.ROCK,  Ground.ROCK,  Ground.GRASS, Ground.GRASS, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.ROCK,  Ground.ROCK,  Ground.ROCK,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.ROCK,  Ground.GRASS, Ground.GRASS, Ground.GRASS, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.TREE,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.ROCK,  Ground.ROCK,  Ground.GRASS, Ground.TREE,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE,  Ground.GRASS, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.TREE,  Ground.TREE,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.ROCK,  Ground.ROCK,  Ground.TREE,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.WATER, Ground.WATER, Ground.WATER, Ground.WATER, Ground.WATER, Ground.WATER, Ground.WATER, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.WATER, Ground.WATER, Ground.WATER, Ground.WATER, Ground.WATER, Ground.WATER, Ground.WATER, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.GRASS, Ground.GRASS, Ground.ROCK,  Ground.ROCK,  Ground.ROCK,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.WATER, Ground.WATER, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.WATER, Ground.WATER, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.GRASS, Ground.GRASS, Ground.ROCK,  Ground.TREE,  Ground.ROCK,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.WATER, Ground.WATER, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.WATER, Ground.WATER, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.GRASS, Ground.GRASS, Ground.ROCK,  Ground.ROCK,  Ground.ROCK,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.WATER, Ground.WATER, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.WATER, Ground.WATER, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE,  Ground.TREE,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.WATER, Ground.WATER, Ground.WATER, Ground.WATER, Ground.WATER, Ground.WATER, Ground.WATER, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, 		Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE,  Ground.TREE,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.WATER, Ground.WATER, Ground.WATER, Ground.WATER, Ground.WATER, Ground.WATER, Ground.WATER, 		Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		
		
		
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
	};
}
