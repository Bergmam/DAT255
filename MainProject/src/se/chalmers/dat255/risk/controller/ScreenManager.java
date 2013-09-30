package se.chalmers.dat255.risk.controller;

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
import sun.security.util.Resources;

public class ScreenManager {
	private static ScreenManager instance;
	private MainScreen main;
	private GameScreen screen;
	private IGame model;
	GDXGame game;

	private ScreenManager() {

		Resource.getInstance();

		model = new Game(new String[] { "Anders", "Beta", "Cookie", "Dumbo" },
				Resource.getInstance().neighborsFile,
				Resource.getInstance().continentsFile);

		main = new MainScreen(model);
		screen = new GameScreen(model);
		ColorHandler.getInstance().instantiate(model);
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
		// changeScreen();
	}

	public static ScreenManager getInstance() {
		if (instance == null) {
			instance = new ScreenManager();
		}
		return instance;
	}

	public void dispose() {
		main.dispose();
	}

	public void instantiate(GDXGame game) {
		this.game = game;
	}

	public void changeScreen() {
		game.setScreen(game.getScreen() == main ? screen : main);
	}

}
