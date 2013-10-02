package se.chalmers.dat255.risk.controller;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.view.PopUp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class PopUpListener extends ClickListener {

	IGame model;

	public PopUpListener(IGame model) {
		this.model = model;
		Gdx.app.log("construct", "popup ");
	}

	@Override
	public void clicked(InputEvent event, float x, float y) {
		//I can't for the life of me figure out why I can't reach the buttons at once
		if (event.getTarget() instanceof Label) {
			Gdx.app.log("name", "" + event.getTarget().getClass());
			Gdx.app.log("name", "" + event.getTarget().getParent().getClass());

			PopUp pop = (PopUp) event.getListenerActor();

			String name = event.getTarget().getParent().getName();
			Gdx.app.log("name", "" + name);
			if (name.equals("confirm")) {
				Gdx.app.log("popup", "" + pop.getValue());
				model.battle((int) pop.getValue());
			} else if (name.equals("cancel")) {
				// model.don'tDoSomething?
			}
		}
	}
}
