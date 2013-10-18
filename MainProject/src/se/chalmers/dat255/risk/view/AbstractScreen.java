package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.IGame;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

public abstract class AbstractScreen implements Screen {

	protected IGame model;
	protected OrthographicCamera camera;
	
	public AbstractScreen(IGame model) {
		this.model = model;
		camera = new OrthographicCamera();
	}

	@Override
	public void render(float delta) {
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}
