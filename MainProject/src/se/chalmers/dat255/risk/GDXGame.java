package se.chalmers.dat255.risk;

import se.chalmers.dat255.risk.view.MainView;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;

public class GDXGame extends Game {
	FPSLogger logger;

	@Override
	public void create() {
		Gdx.app.log("Risk", "creating game");

		logger = new FPSLogger();

		setScreen(new MainView(this, new se.chalmers.dat255.risk.model.Game(
				new String[] { "a", "b", "c", "d" })));

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		super.render();
		// Gdx.app.log("Risk", "RenderingGame");
		logger.log();
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

	}

}
