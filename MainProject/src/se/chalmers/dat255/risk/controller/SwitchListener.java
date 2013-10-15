package se.chalmers.dat255.risk.controller;

import se.chalmers.dat255.risk.view.SwitchButton;
import se.chalmers.dat255.risk.view.UIStage;
import se.chalmers.dat255.risk.view.UIStage.Render;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class SwitchListener extends ClickListener {

	@Override
	public void clicked(InputEvent event, float x, float y) {
		if (event.getListenerActor() instanceof SwitchButton) {
			SwitchButton b = (SwitchButton) event.getListenerActor();
			UIStage stage = (UIStage) b.getStage();

			switch (stage.getRender()) {
			case Map:
				b.switchText();
				stage.switchRender(b.getType());
				break;
			case Card:
				if (b.getType() == Render.Card) {
					b.switchText();
					stage.switchRender(Render.Map);
				}
				break;
			case Stat:
				if (b.getType() == Render.Stat) {
					b.switchText();
					stage.switchRender(Render.Map);
				}
				break;
			}

		}
	}
}
