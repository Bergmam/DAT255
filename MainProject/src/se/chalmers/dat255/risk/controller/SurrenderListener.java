package se.chalmers.dat255.risk.controller;

import se.chalmers.dat255.risk.model.IGame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class SurrenderListener extends ClickListener {
	private IGame model;

	public SurrenderListener(IGame model) {
		this.model = model;
	}

	@Override
	public void clicked(InputEvent event, float x, float y) {
		model.playerLose(model.getActivePlayer());
	}

}
