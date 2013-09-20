package se.chalmers.dat255.risk.view;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.GDXGame;
import se.chalmers.dat255.risk.model.IProvince;
import se.chalmers.dat255.risk.model.Province;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * shows the gameboard, including provinces, cards and buttons.
 * 
 */
public class GameScreen extends AScreen {
	Stage stage;
	private List<IProvince> provinces= new ArrayList<IProvince>();

	public GameScreen(GDXGame game) {
		super(game);
		//Create four provinceViews, 4 CardViews and one ChangePhaseButton.
		
		camera.setToOrtho(false, 800, 480);
		provinces.add(new Province("Ungern"));
		provinces.add(new Province("Frankrike"));
		provinces.add(new Province("Spanien"));
		provinces.add(new Province("Sverige"));
		stage = new ProvinceStage(provinces);

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
