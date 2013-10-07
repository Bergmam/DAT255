package se.chalmers.dat255.risk.controller;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.GDXGame;
import se.chalmers.dat255.risk.model.Game;
import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.view.AbstractView;
import se.chalmers.dat255.risk.view.CardView;
import se.chalmers.dat255.risk.view.ChangePhase;
import se.chalmers.dat255.risk.view.GameScreen;
import se.chalmers.dat255.risk.view.MainScreen;
import se.chalmers.dat255.risk.view.ProvinceView;
import se.chalmers.dat255.risk.view.SwitchButton;
import se.chalmers.dat255.risk.view.resource.ColorHandler;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ScreenManager extends ClickListener {
	private static ScreenManager instance;
	private MainScreen main;
	private GameScreen screen;
	private IGame model;
	private GDXGame game;
	private boolean isLoaded;
	private final List<String> list = new ArrayList<String>();

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
		String[] tmp = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			tmp[i] = list.get(i);
		}
		model.setupGame(tmp, Resource.getInstance().neighborsFile,
				Resource.getInstance().continentsFile);

		screen.setupGame();

		for (AbstractView v : screen.getViews()) {
			if (v instanceof ProvinceView) {
				v.addListener(new ProvinceListener(model));
			} else if (v instanceof CardView) {
				v.addListener(new CardListener(model));
			} else if (v instanceof ChangePhase) {
				v.addListener(new ChangePhaseListener(model));
			} else if (v instanceof SwitchButton) {
				v.addListener(new SwitchListener());
			}
		}

		screen.getPopUp().setListener(new PopUpListener(model));
	}

	@Override
	public void clicked(InputEvent event, float x, float y) {
		Button b = (Button) event.getListenerActor();
		String s = b.getName();

		if (s.equalsIgnoreCase("addPlayer")) {
			if (list.size() < 6) {
				s = main.getText();
				if (s.length() > 1 && s.length() <10) {
					list.add(s);
					main.addPlayer(s);
					System.out.println("added player " + s);
				} else{
					main.setText("too many/few letters");
				}
			} else {
				main.setText("cannot add more");
			}

		} else if (s.equalsIgnoreCase("startButton")) {
			if (list.size() >= 2) {
				setupGame();
				changeScreen(screen);
				System.out.println("You have touched the startButton");

			}
		}
	}

	public void dispose() {
		Resource.getInstance().dispose();
		main.dispose();
		screen.dispose();
	}

	/*
	 * if (list.size() <= 6) { Gdx.input.getTextInput(new TextInputListener() {
	 * 
	 * @Override public void input(String text) { list.add(text); }
	 * 
	 * @Override public void canceled() {
	 * 
	 * }
	 * 
	 * }, "Add a Player", "Name");
	 * 
	 * }
	 */

}
