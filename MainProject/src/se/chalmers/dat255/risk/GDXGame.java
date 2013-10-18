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
	public void resize(int width, int height) {

	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void pause() {
		Gdx.app.log("Risk", "Pausing game");
	}

	@Override
	public void resume() {
		Gdx.app.log("Risk", "Resuming game");

	}

	@Override
	public void dispose() {
		Gdx.app.log("Risk", "Destroying game");
		manager.dispose();
	}

}
