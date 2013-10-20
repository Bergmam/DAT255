package se.chalmers.dat255.risk;

import se.chalmers.dat255.risk.controller.ScreenManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class GDXGame extends Game {
	ScreenManager manager;

	@Override
	public void create() {
		Gdx.app.log("Risk", "creating game");
		manager = ScreenManager.getInstance();
		manager.instantiate(this);
		
	}

	@Override
	public void dispose() {
		Gdx.app.log("Risk", "Destroying game");
		manager.dispose();
	}

}
