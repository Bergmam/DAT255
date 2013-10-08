package se.chalmers.dat255.risk.view;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class MainScreen extends AbstractScreen {

	private Button startButton;
	private Button playerButton;
	private Table inputTable, playerTable ,mainTable;
	private Stage stage;
	private List<Button> buttonList;
	private TextField nameField;

	public MainScreen(IGame model) {
		super(model);
		buttonList = new ArrayList<Button>();
		
		stage = new Stage();
		camera.setToOrtho(false);
		
		inputTable = new Table(Resource.getInstance().skin);
		
		playerTable = new Table(Resource.getInstance().skin);
		
		mainTable = new Table(Resource.getInstance().skin);
		mainTable.setFillParent(true);
		
		startButton = new Button(Resource.getInstance().skin);
		startButton.add("Start Game");
		startButton.setName("startButton");
		buttonList.add(startButton);

		playerButton = new Button(Resource.getInstance().skin);
		playerButton.add("Add Player");
		playerButton.setName("addPlayer");
		buttonList.add(playerButton);

		nameField = new TextField("", Resource.getInstance().skin);
		nameField.setMessageText("Enter Name");

		playerTable.add("Players:");
		playerTable.pad(50);		
		inputTable.add(playerButton);
		inputTable.add(nameField);
		inputTable.row();
		inputTable.add(startButton);
		mainTable.add(inputTable);
		//t1.add();
		mainTable.add(playerTable);

		//t1.pack();
		inputTable.size(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight());
		playerTable.size(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight());

		stage.addActor(mainTable);
	}

	// expand when needing more buttons
	public List<Button> getButtons() {
		return buttonList;
	}

	public void addPlayer(String name) {
		playerTable.add(name);
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
	
	public void clearPlayers(){
		playerTable.clear();
		playerTable.add("Players:");
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
