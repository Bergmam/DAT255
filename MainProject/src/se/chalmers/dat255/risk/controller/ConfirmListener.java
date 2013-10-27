package se.chalmers.dat255.risk.controller;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.view.ConfirmDialog;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ConfirmListener extends ClickListener {
	private IGame model;

	public ConfirmListener(IGame model) {
		this.model = model;
	}

	@Override
	public void clicked(InputEvent event, float x, float y) {
		ConfirmDialog confirm = (ConfirmDialog) event.getListenerActor();
		String title = confirm.getTitle();
		String name = null;
		
		// you can press both the button and the label...
		if (event.getTarget() instanceof Label) {
			name = event.getTarget().getParent().getName();
		} else if (event.getTarget() instanceof Button) {
			name = event.getTarget().getName();
		}
		
		if (name != null) {
			if (title.equalsIgnoreCase(IGame.SURRENDER)) {
				if (name.equals("confirm")) {
					model.surrender(true);
				} else if (name.equals("cancel")) {
					model.surrender(false);
				}
			} 
		}

	
		
	}
}
