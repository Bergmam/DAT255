package se.chalmers.dat255.risk.view;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class MainScreen extends AbstractScreen {

	private Button startButton;
	private Button playerButton;
	private Table table;
	private Stage stage;
	private List<Button> buttonList;
	private TextField nameField;

	public MainScreen(IGame model) {
		super(model);
		buttonList = new ArrayList<Button>();
		table = new Table();
		table.setFillParent(true);
		stage = new Stage();
		camera.setToOrtho(false);

		startButton = new Button(Resource.getInstance().skin);
		startButton.add("Start Game", "default");
		startButton.setName("startButton");
		buttonList.add(startButton);

		playerButton = new Button(Resource.getInstance().skin);
		playerButton.add("Add Player", "default");
		playerButton.setName("addPlayer");
		buttonList.add(playerButton);

		nameField = new TextField("", Resource.getInstance().skin);
		nameField.setMessageText("Enter Name");

		table.add(playerButton);
		table.add(nameField);
		table.row();
		table.add(startButton);
		stage.addActor(table);
	}

	// expand when needing more buttons
	public List<Button> getButtons() {
		return buttonList;
	}
	
	public void addPlayer(String name){
		table.add(new Label(name,Resource.getInstance().skin));
	}

	public String getText() {
		String tmp = nameField.getText();
		nameField.setText("");
		return tmp;
	}

	public void setText(String text) {
		nameField.setText(text);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float render) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		stage.draw();

	}

	@Override
	public void dispose() {
		stage.dispose();
	}

}
