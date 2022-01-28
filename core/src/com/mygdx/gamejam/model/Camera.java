package com.mygdx.gamejam.model;

public class Camera {
	private float cameraAbs = 0;
	private float cameraOrd = 0;
	
	public float getCameraAbs() {
		return cameraAbs;
	}

	public float getCameraOrd() {
		return cameraOrd;
	}
	
	public void update(float newCameraAbs, float newCameraOrd) {
		this.cameraAbs = newCameraAbs;
		this.cameraOrd = newCameraOrd;
	}
}
