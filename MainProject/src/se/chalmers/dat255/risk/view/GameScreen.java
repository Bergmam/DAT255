package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.GDXGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * shows the gameboard, including provinces, cards and buttons.
 * 
 */
public class GameScreen extends AScreen {
	Stage stage;

	public GameScreen(GDXGame game) {
		super(game);
		//Create four provinceViews, 4 CardViews and one ChangePhaseButton.



		// I dont really know why? something about province.png is not a powers of 2?
		Texture.setEnforcePotImages(false);

		camera.setToOrtho(false, 800, 480);
		stage = new ProvinceStage(4);

	}

	@Override
	public void show() {

	}

	@Override
	public void render(float render) {
		Gdx.gl.glClearColor(0f, 1f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();

		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

		}

	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
