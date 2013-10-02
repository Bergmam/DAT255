package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class MainScreen extends AbstractScreen {

	private Button startButton;
	private Stage stage;

	public MainScreen(IGame model) {
		super(model);
		stage = new Stage();
		camera.setToOrtho(false);
		startButton = new Button(Resource.getInstance().skin);
		Label label = new Label("Start Game", Resource.getInstance().skin);
		startButton.add(label);
		startButton.size(label.getWidth(), label.getHeight());
		startButton.setPosition(stage.getWidth() / 2 - startButton.getWidth(),
				stage.getHeight() / 2 - startButton.getHeight());
		startButton.setName("startButton");
		stage.addActor(startButton);
		Gdx.input.setInputProcessor(stage);
	}
	
	// expand when needing more buttons
	public Actor getButton(){
		return startButton;
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
