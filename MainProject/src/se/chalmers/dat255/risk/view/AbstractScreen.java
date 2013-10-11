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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
	}

}
