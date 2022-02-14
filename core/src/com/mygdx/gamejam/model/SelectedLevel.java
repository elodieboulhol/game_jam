package com.mygdx.gamejam.model;

public enum SelectedLevel {
	NONE(-2),
	BACK(-1),
	LEVEL3(0),
	LEVEL2(1),
	LEVEL1(2),
	INTRO(3);
	
	private final int value;

	private SelectedLevel(final int newValue) {
        value = newValue;
    }
	
    public int getValue() {
    	return value;
    }
    
    public static SelectedLevel from(int value) {
    	if (value == -1) return SelectedLevel.BACK;
    	else if (value == 0) return SelectedLevel.LEVEL3;
    	else if (value == 1) return SelectedLevel.LEVEL2;
    	else if (value == 2) return SelectedLevel.LEVEL1;
    	else if (value == 3) return SelectedLevel.INTRO;
    	else return SelectedLevel.NONE;
    }
}
