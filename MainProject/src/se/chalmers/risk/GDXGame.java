package se.chalmers.risk;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;

public class GDXGame implements ApplicationListener {

	FPSLogger logger;

	@Override
	public void create() {

		Gdx.app.log("Risk", "creating game");

		logger = new FPSLogger();

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		Gdx.app.log("Risk", "Render");
		Gdx.gl.glClearColor(0f, 1f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
