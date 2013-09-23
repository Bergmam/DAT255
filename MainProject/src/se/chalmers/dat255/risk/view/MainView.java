package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.GDXGame;
import se.chalmers.dat255.risk.model.IGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

public class MainView extends AbstractScreen {

	public MainView(GDXGame game, IGame model) {
		super(game, model);
		camera.setToOrtho(false, 800, 480);
		
		
	}
	
	// returns the view that needs listeners
	public void getViews(){
		
	}
	
	@Override
	public void render(float render){
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		font.draw(batch, "Tap anywhere to begin!", 100, 100);
		batch.end();

		if (Gdx.input.isTouched()) {
			game.setScreen(new GameScreen(game, model));
			dispose();
		}
		
	}
	
	@Override
	public void dispose(){
		super.dispose();
	}

}
