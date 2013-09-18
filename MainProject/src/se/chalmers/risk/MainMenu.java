package se.chalmers.risk;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainMenu extends AScreen {
	OrthographicCamera camera;

	public MainMenu(GDXGame game) {
		super(game);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		
	}
	
	@Override
	public void render(float render){
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		game.batch.begin();
		game.font.draw(game.batch, "Welcome to Stolen code!!! ", 100, 150);
		game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
		game.batch.end();

		if (Gdx.input.isTouched()) {
			game.setScreen(new MapScreen(game));
			dispose();
		}
		
	}

}
