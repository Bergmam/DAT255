package se.chalmers.dat255.risk.controller;

import se.chalmers.dat255.risk.view.ChangePhase;
import se.chalmers.dat255.risk.view.SwitchButton;
import se.chalmers.dat255.risk.view.UIStage;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class SwitchListener extends ClickListener {

	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
			int button) {
		if (event.getTarget() instanceof ChangePhase) {
			((SwitchButton) event.getTarget()).check();
		}
		return super.touchDown(event, x, y, pointer, button);
	}

	@Override
	public void clicked(InputEvent event, float x, float y) {
		if (event.getListenerActor() instanceof SwitchButton) {
			SwitchButton b = (SwitchButton) event.getListenerActor();
			b.switchText();
			b.check();
			((UIStage) b.getStage()).switchRender();
		}
	}
}
