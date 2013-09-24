package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.GDXGame;
import se.chalmers.dat255.risk.model.IGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

public class MainView extends AbstractScreen {

	GameScreen screen;
	public MainView(GDXGame game, IGame model) {
		super(game, model);
		camera.setToOrtho(false);
		screen = new GameScreen(game, model);

	}

	// returns the view that needs listeners
	public void getViews() {

	}

	@Override
	public void render(float render) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		batch.begin();
		font.draw(batch, "Tap anywhere to begin!", Gdx.graphics.getWidth() / 2,
				Gdx.graphics.getHeight() / 2);
		batch.end();

		if (Gdx.input.isTouched()) {

			game.setScreen(screen);
		}

	}

	@Override
	public void dispose() {
		super.dispose();
		screen.dispose();
	}

}
