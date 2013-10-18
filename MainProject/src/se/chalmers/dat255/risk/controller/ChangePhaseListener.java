package se.chalmers.dat255.risk.controller;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.view.ChangePhase;
import se.chalmers.dat255.risk.view.UIStage;
import se.chalmers.dat255.risk.view.UIStage.Render;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ChangePhaseListener extends ClickListener {

	IGame theGame;

	public ChangePhaseListener(IGame theGame) {
		this.theGame = theGame;
	}

	@Override
	public void clicked(InputEvent event, float x, float y) {
		if (event.getListenerActor() instanceof ChangePhase) {
			theGame.handlePhaseEvent();
		}
	}
}
