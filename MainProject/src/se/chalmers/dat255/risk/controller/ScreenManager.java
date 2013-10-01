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

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ScreenManager extends ClickListener {
	private static ScreenManager instance;
	private MainScreen main;
	private GameScreen screen;
	private IGame model;
	private GDXGame game;

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

		main.getButton().addListener(this);
	}

	public static ScreenManager getInstance() {
		if (instance == null) {
			instance = new ScreenManager();
		}
		return instance;
	}

	public void dispose() {
		main.dispose();
		screen.dispose();
	}

	public void instantiate(GDXGame game) {
		this.game = game;
		changeScreen(main);
	}

	public void changeScreen(Screen screen) {
		game.setScreen(screen);
	}

	@Override
	public void clicked(InputEvent event, float x, float y) {
		if (event.getTarget() instanceof Button) {
			Button b = (Button) event.getTarget();
			String s = b.getName();

			if (s.equalsIgnoreCase("startButton")) {
				changeScreen(screen);
			}

		}
	}
}
