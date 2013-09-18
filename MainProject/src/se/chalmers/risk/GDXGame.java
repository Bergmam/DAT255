package se.chalmers.risk;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GDXGame extends Game {
	SpriteBatch batch;
	BitmapFont font;
	FPSLogger logger;

	@Override
	public void create() {
		Gdx.app.log("Risk", "creating game");

		logger = new FPSLogger();

		batch = new SpriteBatch();
		font = new BitmapFont();
		
		setScreen(new MainMenu(this));

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		super.render();
		Gdx.app.log("Risk", "RenderingGame");
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
		batch.dispose();
		font.dispose();

	}

}
