package se.chalmers.dat255.risk.controller;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.model.Game;
import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.model.IGame.GameMode;
import se.chalmers.dat255.risk.view.AbstractView;
import se.chalmers.dat255.risk.view.CardView;
import se.chalmers.dat255.risk.view.ChangePhase;
import se.chalmers.dat255.risk.view.ConfirmDialog;
import se.chalmers.dat255.risk.view.GameScreen;
import se.chalmers.dat255.risk.view.MainScreen;
import se.chalmers.dat255.risk.view.Message;
import se.chalmers.dat255.risk.view.PopUp;
import se.chalmers.dat255.risk.view.ProvinceView;
import se.chalmers.dat255.risk.view.SwitchButton;
import se.chalmers.dat255.risk.view.resource.ColorHandler;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ScreenManager extends ClickListener {
	private static ScreenManager instance;
	private MainScreen main;
	private GameScreen screen;
	private IGame model;
	private GDXGame game;
	private final List<String> list = new ArrayList<String>();
	private final int maxNbrOfPlayers = 6;
	//min player usually two, but we haven't implemented that functionality  
	private final int minNbrOfPlayers = 3;

	private ScreenManager() {
		Resource.getInstance();
	}

	public static ScreenManager getInstance() {
		if (instance == null) {
			instance = new ScreenManager();
		}
		return instance;
	}

	public void instantiate(GDXGame game) {
		this.game = game;

		model = new Game();
		main = new MainScreen(model);
		screen = new GameScreen(model);
		ColorHandler.getInstance().instantiate(model);

		for (Button b : main.getButtons()) {
			b.addListener(this);
		}
		changeScreen(main);

	}

	public void changeScreen(Screen screen) {
		game.setScreen(screen);
	}

	public void setupGame() {

		model.setupGame(list, Resource.getInstance().neighborsFile,
				Resource.getInstance().continentsFile,
				Resource.getInstance().missionsFile);

		model.setGameMode(GameMode.valueOf(main.getMode()));

		screen.setupGame();

		for (AbstractView v : screen.getViews()) {
			if (v instanceof ProvinceView) {
				v.addListener(new ProvinceListener(model));
			} else if (v instanceof CardView) {
				v.addListener(new CardListener(model));
			}
		}

		for (Actor a : screen.getSpecActors()) {
			if (a.getClass() == TextButton.class) {
				a.addListener(new SurrenderListener(model));
			} else if (a instanceof PopUp) {
				a.addListener(new PopUpListener(model));
			} else if (a instanceof ChangePhase) {
				a.addListener(new ChangePhaseListener(model));
			} else if (a instanceof SwitchButton) {
				a.addListener(new SwitchListener());
			} else if (a instanceof ConfirmDialog) {
				a.addCaptureListener(new ConfirmListener(model));
			} else if (a instanceof Message) {
				a.addListener(new MessageListener());
			}
		}
	}

	@Override
	public void clicked(InputEvent event, float x, float y) {
		Button b = (Button) event.getListenerActor();
		String s = b.getName();

		if (s.equalsIgnoreCase("addPlayer")) {
			main.setText("Enter name below");
			if (list.size() < maxNbrOfPlayers) {
				s = main.getText();
				if (s.length() >= 1 && s.length() <= 10) {
					if (!list.contains(s)) {
						list.add(s);
						main.addPlayer(s);
						System.out.println("added player " + s);
					} else {
						main.setText("Player already exists");
					}
				} else {
					main.setText("Too many/few letters");
				}
			} else {
				main.setText("Cannot add more");
			}

		} else if (s.equalsIgnoreCase("startButton")) {
			if (list.size() >= minNbrOfPlayers) {
				setupGame();
				changeScreen(screen);
			}
		}
	}

	public void gameOver() {
		changeScreen(main);
		list.clear();
		main.clearPlayers();
	}

	public void dispose() {
		Resource.getInstance().dispose();
		main.dispose();
		screen.dispose();
	}

}
