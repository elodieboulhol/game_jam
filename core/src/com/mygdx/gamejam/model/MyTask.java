package com.mygdx.gamejam.model;


import com.badlogic.gdx.utils.Timer.Task;

abstract class MyTask extends Task {
    Player param;

    public MyTask(Player param) {
    	super();
        this.param = param;
    }
}