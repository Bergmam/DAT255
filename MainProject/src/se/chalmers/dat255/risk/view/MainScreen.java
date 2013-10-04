package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class MainScreen extends AbstractScreen {

	private Button startButton;
	private Stage stage;

	public MainScreen(IGame model) {
		super(model);
		Table t = new Table();
		t.setFillParent(true);
		stage = new Stage();
		camera.setToOrtho(false);
		startButton = new Button(Resource.getInstance().skin);
		startButton.add("Start Game", "default");
		startButton.setName("startButton");
		t.add(startButton);
		stage.addActor(t);
	}
	
	// expand when needing more buttons
	public Actor getButton(){
		return startButton;
	}
	
	@Override
	public void show(){
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float render) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		batch.begin();
		stage.draw();
		batch.end();

	}

	@Override
	public void dispose() {
		super.dispose();
		stage.dispose();
	}

}
