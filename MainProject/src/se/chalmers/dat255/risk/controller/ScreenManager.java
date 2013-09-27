package se.chalmers.dat255.risk.controller;

import se.chalmers.dat255.risk.GDXGame;
import se.chalmers.dat255.risk.model.Game;
import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.view.AbstractView;
import se.chalmers.dat255.risk.view.CardView;
import se.chalmers.dat255.risk.view.ChangePhase;
import se.chalmers.dat255.risk.view.MainScreen;
import se.chalmers.dat255.risk.view.ProvinceView;
import se.chalmers.dat255.risk.view.SwitchButton;

public class ScreenManager {
	MainScreen main;
	IGame model;

	public ScreenManager(GDXGame game) {
		
		model = new Game(new String[] { "a", "b",
				"c", "d" });
		main = new MainScreen(game, model);
		
		for (AbstractView v : main.getViews()) {
			if (v instanceof ProvinceView) {
				v.addListener(new ProvinceListener());
			} else if (v instanceof CardView) {
				v.addListener(new CardListener());
			} else if (v instanceof ChangePhase) {
				v.addListener(new ChangePhaseListener());
			} else if (v instanceof SwitchButton) {
				v.addListener(new SwitchListener());
			}
		}
		game.setScreen(main);
	}
	
	public void dispose(){
		main.dispose();
	}
	
}
