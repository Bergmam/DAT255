package se.chalmers.dat255.risk;

import se.chalmers.dat255.risk.controller.ProvinceListener;
import se.chalmers.dat255.risk.view.AbstractView;
import se.chalmers.dat255.risk.view.MainScreen;
import se.chalmers.dat255.risk.view.ProvinceView;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;

public class GDXGame extends Game {
	FPSLogger logger;
	MainScreen main;
	se.chalmers.dat255.risk.model.Game game;

	@Override
	public void create() {
		Gdx.app.log("Risk", "creating game");

		game = new se.chalmers.dat255.risk.model.Game(new String[] { "a", "b",
				"c", "d" });

		logger = new FPSLogger();
		main = new MainScreen(this, game);
		for (AbstractView v : main.getViews()) {
			v.addListener(v instanceof ProvinceView? new ProvinceListener() : null);
		}
		setScreen(main);
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
		main.dispose();
	}

}
