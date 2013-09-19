package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.GDXGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

public class MainMenu extends AScreen {

	public MainMenu(GDXGame game) {
		super(game);
		camera.setToOrtho(false, 800, 480);
		
		
	}
	
	@Override
	public void render(float render){
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		font.draw(batch, "Welcome to Stolen code!!! ", 100, 150);
		font.draw(batch, "Tap anywhere to begin!", 100, 100);
		batch.end();

		if (Gdx.input.isTouched()) {
			game.setScreen(new MapScreen(game));
			dispose();
		}
		
	}
	
	@Override
	public void dispose(){
		super.dispose();
	}

}
