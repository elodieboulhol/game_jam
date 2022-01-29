package com.mygdx.gamejam;

import com.mygdx.gamejam.model.Ground;

public class Settings {
	
	public static int SCREEN_WIDTH = 800;
	public static int SCREEN_HEIGHT = 480;
	
	public static int TILE_SIZE = 50;
	
	// public static int HEIGHT = 18;
	// public static int WIDTH = 18;
	public static int MAX_LIFEPOINTS = 3;
	
	public static int LIFEABS = 10;
	public static int LIFEORD = SCREEN_HEIGHT - 40;
	public static int LIFESIZE = 32;
	public static int LIFESPACE = 3;
	
	
	public static Ground[][] GROUNDMAP1= {
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		
		
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.ROCK,  Ground.ROCK,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.ROCK,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.GRASS, Ground.TREE,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.WATER, Ground.WATER, Ground.WATER, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.WATER, Ground.WATER, Ground.WATER, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.WATER, Ground.WATER, Ground.WATER, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.WATER, Ground.WATER, Ground.WATER, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.WATER, Ground.WATER, Ground.WATER, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE,  Ground.TREE,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE,  Ground.TREE,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.ROCK, 	Ground.ROCK,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.GRASS, Ground.ROCK,  Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.GRASS, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		
		
		
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
		{ Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, Ground.TREE, 	Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE,  Ground.TREE, },
	};
}
