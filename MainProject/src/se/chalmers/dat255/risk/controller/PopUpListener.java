package se.chalmers.dat255.risk.controller;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.view.PopUp;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class PopUpListener extends ClickListener {

	IGame model;

	public PopUpListener(IGame model) {
		this.model = model;

	}

	@Override
	public void clicked(InputEvent event, float x, float y) {

		PopUp pop = (PopUp) event.getListenerActor().getParent().getParent();
		String name = event.getTarget().getParent().getName();
		if(name.equals("confirm")){
			//model.doSomething
		} else if(name.equals("cancel")){
			//model.don'tDoSomething?
		}
		
		
		
	}

}
