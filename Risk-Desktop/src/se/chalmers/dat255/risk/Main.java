package se.chalmers.dat255.risk;

import se.chalmers.dat255.risk.controller.GDXGame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class Main {

	public static void main(String[] args) {
		new LwjglApplication(new GDXGame(), "Game", 960, 640, true);
	}

}
