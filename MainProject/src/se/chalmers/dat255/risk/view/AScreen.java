package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.GDXGame;
import se.chalmers.dat255.risk.model.IGame;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AScreen implements Screen {

	protected GDXGame game;
	protected IGame model;
	protected BitmapFont font;
	protected SpriteBatch batch;
	protected OrthographicCamera camera;
	
	public AScreen(GDXGame game, IGame model) {
		this.game = game;
		this.model = model;
		font = new BitmapFont();
		batch = new SpriteBatch();
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
		font.dispose();
		batch.dispose();
		
	}

}
