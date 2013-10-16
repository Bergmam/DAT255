package se.chalmers.dat255.risk.view;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class MainScreen extends AbstractScreen {

	private Table inputTable, playerTable ,mainTable;
	private Stage stage;
	private List<Button> buttonList;
	private TextField nameField;
	private Label msg;
	private Label risk;

	public MainScreen(IGame model) {
		super(model);
		buttonList = new ArrayList<Button>();
		
		stage = new Stage();
		camera.setToOrtho(false);
		
		inputTable = new Table(Resource.getInstance().skin);
		
		playerTable = new Table(Resource.getInstance().skin);
		
		mainTable = new Table(Resource.getInstance().skin);
		mainTable.setFillParent(true);
		
		Button startButton = new Button(Resource.getInstance().skin);
		startButton.add("Start Game");
		startButton.setName("startButton");
		buttonList.add(startButton);

		Button playerButton = new Button(Resource.getInstance().skin);
		playerButton.add("Add Player");
		playerButton.setName("addPlayer");
		buttonList.add(playerButton);

		nameField = new TextField("", Resource.getInstance().skin);
		nameField.setMessageText("Enter Name");
		
		msg = new Label("Enter name below",Resource.getInstance().skin);

		risk = new Label("Risk", Resource.getInstance().skin);
		risk.setFontScale(3);
		
		playerTable.add("Players:").expandX().left();
		
		inputTable.add();
		inputTable.add(msg).left().row();
		inputTable.add(playerButton);
		inputTable.add(nameField);
		inputTable.row();
		inputTable.add(startButton).colspan(2).fill();
		
		mainTable.left().top();
		mainTable.add(risk).colspan(2).row().expandX();
		mainTable.add(inputTable).expand();
		mainTable.add(playerTable).fill();

		inputTable.size(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight());
		playerTable.size(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight());

		stage.addActor(mainTable);
//		mainTable.debug();
//		inputTable.debug();
//		playerTable.debug();
	}

	public List<Button> getButtons() {
		return buttonList;
	}

	public void addPlayer(String name) {
		playerTable.add(name).left();
	}

	public String getText() {
		String tmp = nameField.getText();
		nameField.setText("");
		return tmp;
	}

	public void setText(String text) {
		msg.setText(text);
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
		Gdx.gl.glClearColor(0.7f, 0.7f, 0.7f, 0.7f);//Background color
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		stage.draw();
//		Table.drawDebug(stage);
	}

	@Override
	public void dispose() {
		stage.dispose();
	}
}
