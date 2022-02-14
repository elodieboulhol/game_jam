package com.mygdx.gamejam.controller;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;
import com.mygdx.gamejam.MainMenuScreen;
import com.mygdx.gamejam.model.SelectedLevel;


public class MenuController extends InputAdapter {
	
	private boolean isArrowOnPlay = true;
	private boolean shouldGameStop = false;
	private boolean shouldGameStart = false;
	private SelectedLevel levelSelected = SelectedLevel.NONE;
	
	
	@Override
	public boolean keyDown(int keycode) {
		if (levelSelected == SelectedLevel.NONE) {
			// Choice between play and exit
			if (keycode == Keys.UP || keycode == Keys.DOWN) {
				if (isArrowOnPlay) isArrowOnPlay = false;
				else isArrowOnPlay = true;
				MainMenuScreen.beepSound.play();
			}

			// Level selection
		} else {
			if (keycode == Keys.UP) {
				if (levelSelected.getValue() < 3) levelSelected = SelectedLevel.from(levelSelected.getValue() + 1);
				else levelSelected = SelectedLevel.BACK;
				MainMenuScreen.beepSound.play();
			} else if (keycode == Keys.DOWN) {
				if (levelSelected.getValue() > -1) levelSelected = SelectedLevel.from(levelSelected.getValue() - 1);
				else levelSelected = SelectedLevel.INTRO;
				MainMenuScreen.beepSound.play();
			}
		}
		
		if (keycode == Keys.SPACE || keycode == Keys.ENTER) {
			if (levelSelected == SelectedLevel.NONE) {
				if (isArrowOnPlay) levelSelected = SelectedLevel.INTRO;
				else shouldGameStop = true;
			} else {
				if (levelSelected == SelectedLevel.BACK) levelSelected = SelectedLevel.NONE;
				else shouldGameStart = true;
				
			}
		}
		return true;
	}

	public Boolean getIsArrowOnPlay() {
		return isArrowOnPlay;
	}

	public Boolean getShouldGameStop() {
		return shouldGameStop;
	}

	public Boolean getShouldGameStart() {
		return shouldGameStart;
	}

	public SelectedLevel getLevelSelected() {
		return levelSelected;
	}
}